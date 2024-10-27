// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.10" apply false
    id("com.google.dagger.hilt.android") version "2.48.1" apply false
    kotlin("plugin.serialization") version "1.8.10" apply false
    id("com.google.devtools.ksp") version "1.9.10-1.0.13" apply false
    id "org.sonarqube" version "5.1.0.4882"
}

sonar {
  properties {
    property "sonar.projectKey", "ofonsecan_vinilos-4203-2023-15"
    property "sonar.organization", "ofonsecan"
    property "sonar.host.url", "https://sonarcloud.io"
  }
}