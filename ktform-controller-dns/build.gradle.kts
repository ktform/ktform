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

import org.gradle.kotlin.dsl.kotlin
import org.jetbrains.kotlin.gradle.tasks.KotlinCompilationTask
import dev.ktform.build.kspKmp

plugins {
  alias(libs.plugins.android.library)
  alias(libs.plugins.ksp)
  alias(libs.plugins.kotlin.serialization)

//  alias(libs.plugins.compose.hot.reload)
//  alias(libs.plugins.compose.multiplatform)
//  alias(libs.plugins.compose.compiler)
  kotlin("multiplatform")
}

group = "dev.ktform.dns"
version = libs.versions.settings.versionName.get()

android {
  namespace = "dev.ktform.dns"
  compileSdk = libs.versions.settings.compileSdk.get().toInt()
  buildToolsVersion = libs.versions.settings.buildTools.get()

  defaultConfig {
    minSdk = libs.versions.settings.minSdk.get().toInt()
  }
}

kotlin {
  jvm()
  js {
    browser {
      testTask {
        useKarma {
          useFirefox()
        }
      }
    }
    nodejs()
  }
  iosX64()
  iosArm64()
  iosSimulatorArm64()
  androidTarget {
    publishLibraryVariants("release")
    publishLibraryVariantsGroupedByFlavor = true
  }

  sourceSets {
    commonMain.dependencies {
      implementation(libs.bundles.common)
      implementation(libs.bundles.arrow)
    }
    commonTest.dependencies {
      implementation(libs.bundles.common.testing)
    }
    androidMain.dependencies {
      implementation(libs.bundles.android)
    }
    androidInstrumentedTest.dependencies {
      implementation(libs.bundles.common.testing)
      implementation(libs.bundles.android.testing)
      runtimeOnly(libs.testing.junit.engine)
    }
    jvmMain.dependencies {
      implementation(libs.bundles.jvm)
    }
    jvmTest.dependencies {
      implementation(libs.bundles.common.testing)
      implementation(libs.bundles.jvm.testing)
      runtimeOnly(libs.testing.junit.engine)
    }
    nativeMain.dependencies {
      implementation(libs.bundles.native)
    }
    nativeTest.dependencies {
      implementation(libs.bundles.common.testing)
//      implementation(libs.bundles.native.testing)
    }
    jsMain.dependencies {
      implementation(libs.bundles.js)
    }
    jsTest.dependencies {
      implementation(libs.bundles.common.testing)
      implementation(libs.bundles.js.testing)
    }
    iosMain.dependencies {
      implementation(libs.bundles.ios)
    }
    iosTest.dependencies {
      implementation(libs.bundles.common.testing)
//      implementation(libs.bundles.ios.testing)
    }
  }
}

tasks.configureEach {
  if (name.endsWith("sourcesJar", ignoreCase = true)) {
    dependsOn("kspCommonMainKotlinMetadata")
  }
}

project.tasks.withType(KotlinCompilationTask::class.java).configureEach {
  if(name != "kspCommonMainKotlinMetadata") {
    dependsOn("kspCommonMainKotlinMetadata")
  }
}

dependencies {
  kspKmp(libs.arrow.optics.compiler)
}
