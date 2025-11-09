/*
 * Copyright (C) 2016-2025 Yuriy Yarosh
 * All rights reserved.
 *
 * SPDX-License-Identifier: MPL-2.0
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

import nl.littlerobots.vcu.plugin.resolver.VersionSelectors
import org.gradle.internal.extensions.stdlib.toDefaultLowerCase

plugins {
  alias(libs.plugins.version.update)
  alias(libs.plugins.android.library) apply false
  alias(libs.plugins.spotless) apply false
  alias(libs.plugins.ksp) apply false
  alias(libs.plugins.kotlin.multiplatform) apply false
  alias(libs.plugins.maven.publish) apply false
}

versionCatalogUpdate {
  versionSelector(VersionSelectors.PREFER_STABLE)
}

// Function to read and parse the .env file
fun loadDotEnv(): Map<String, String> {
  val envMap = mutableMapOf<String, String>()
  val envFile = File("${project.rootDir}/.env")

  if (envFile.exists()) {
    envFile.forEachLine { line ->
      val trimmedLine = line.trim()
      if (trimmedLine.isNotEmpty() && !trimmedLine.startsWith("#")) {
        val parts = trimmedLine.split("=", limit = 2)
        if (parts.size == 2) {
          val key = parts[0].trim()
          val value = parts[1].trim().trim('"').trim()
          if (key.isNotEmpty()) {
            envMap[key] = value
          }
        }
      }
    }
  } else {
    println("Warning: .env file not found at ${project.rootDir}/.env")
  }

  return envMap
}

val envVars = loadDotEnv()

subprojects {
  apply(plugin = "com.diffplug.spotless")
  apply(plugin = "com.vanniktech.maven.publish")

  afterEvaluate {
    extensions.configure(com.diffplug.gradle.spotless.SpotlessExtension::class.java) {
      kotlin {
        licenseHeaderFile(rootProject.file("header.kt"))
        target("**/*.kt")
        targetExclude("**/build/**", "**/.gradle/**", "**/tmp/**", "**/resources/**")
        ktfmt("0.56").kotlinlangStyle()
        trimTrailingWhitespace()
        endWithNewline()
      }
    }
  }
}

allprojects {
  val variables = listOf("GITHUB_TOKEN")

  // Configure JDK 24 for Java and Kotlin compilation
  tasks.withType<JavaCompile>().configureEach {
    sourceCompatibility = "24"
    targetCompatibility = "24"
  }

  tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    compilerOptions {
      jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_24)
    }
  }

  tasks.withType<Test> {
    variables.forEach { variable -> environment(variable, envVars[variable] ?: "")}

    testLogging {
      events("passed", "skipped", "failed")
      showStandardStreams = true
    }
  }

  // For JVM tests
  tasks.withType<JavaExec> {
    variables.forEach { variable -> environment(variable, envVars[variable] ?: "")}
  }

  tasks.matching { it.name.toDefaultLowerCase().contains("test") }.configureEach {
    if (this is Exec) {
      variables.forEach { variable -> environment(variable, envVars[variable] ?: "")}
    }
  }
}
