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

pluginManagement {
  repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
    maven { url = uri("https://jitpack.io") }
  }
}

dependencyResolutionManagement {
  repositories {
    mavenCentral()
    google()
    gradlePluginPortal()
    maven {
      url = uri("https://packages.confluent.io/maven/")
    }
  }
}

rootProject.name = "ktform"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include(":ktform-app-android")
include(":ktform-app-ios")
include(":ktform-app-web-dashboard")
include(":ktform-catalog")
include(":ktform-controller")
include(":ktform-controller-autoscaling")
include(":ktform-controller-cache")
include(":ktform-controller-cache-memcached")
include(":ktform-controller-cache-valkey")
include(":ktform-controller-cloud")
include(":ktform-controller-cloud-alicloud")
include(":ktform-controller-cloud-aws")
include(":ktform-controller-cloud-azure")
include(":ktform-controller-cloud-cloudflare")
include(":ktform-controller-cloud-digitalocean")
include(":ktform-controller-cloud-gcp")
include(":ktform-controller-cloud-virtual-gpu")
include(":ktform-controller-cloud-hetzner")
include(":ktform-controller-cloud-ibm")
include(":ktform-controller-cloud-kubernetes")
include(":ktform-controller-cloud-nvidia")
include(":ktform-controller-cloud-openstack")
include(":ktform-controller-cloud-oracle")
include(":ktform-controller-cloud-ovhcloud")
include(":ktform-controller-cloud-vultr")
include(":ktform-controller-db")
include(":ktform-controller-db-cassandra")
include(":ktform-controller-db-clickhouse")
include(":ktform-controller-db-mysql")
include(":ktform-controller-db-postgresql")
include(":ktform-controller-dns")
include(":ktform-controller-messages")
include(":ktform-controller-messages-argo")
include(":ktform-controller-messages-kafka")
include(":ktform-controller-messages-nats")
include(":ktform-controller-messages-rabbitmq")
include(":ktform-controller-observability")
include(":ktform-controller-observability-datadog")
include(":ktform-controller-observability-grafana")
include(":ktform-controller-observability-splunk")
include(":ktform-controller-organization")
include(":ktform-controller-pipelines")
include(":ktform-controller-pipelines-beam")
include(":ktform-controller-pipelines-datafusion")
include(":ktform-controller-pipelines-flink")
include(":ktform-controller-repo")
include(":ktform-controller-repo-gitea")
include(":ktform-controller-repo-github")
include(":ktform-controller-repo-gitlab")
include(":ktform-controller-secrets")
include(":ktform-controller-secrets-openbao")
include(":ktform-controller-workflows")
include(":ktform-controller-workflows-argo")
include(":ktform-controller-workflows-n8n")
include(":ktform-controller-workflows-nifi")
include(":ktform-engine")
include(":ktform-machine")
include(":ktform-machine-bottlerocket")
include(":ktform-machine-debian")
include(":ktform-model")
include(":ktform-target")
include(":ktform-target-docker")
include(":ktform-target-kubernetes")
include(":ktform-target-virtual-kubernetes")
include(":ktform-ui")
include(":ktform-usage-analytics")
include(":ktform-usage-reporter")

check(JavaVersion.current().isCompatibleWith(JavaVersion.VERSION_24)) {
  """
    Sumicare requires JDK 24 but it is currently using JDK ${JavaVersion.current()}.
    Java Home: [${System.getProperty("java.home")}]
  """.trimIndent()
}
