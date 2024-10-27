plugins {
    id("com.android.application") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.10" apply false
    id("com.google.dagger.hilt.android") version "2.48.1" apply false
    kotlin("plugin.serialization") version "1.8.10" apply false
    id("com.google.devtools.ksp") version "1.9.10-1.0.13" apply false
    id("org.sonarqube") version "4.0.0.2929" apply true
}

// Apply the SonarQube plugin in the app module where it is needed
subprojects {
    apply(plugin = "org.sonarqube")

    sonarqube {
    properties {
        property("sonar.projectKey", "ofonsecan_vinilos-4203-2023-15")
        property("sonar.organization", "ofonsecan")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}
}
