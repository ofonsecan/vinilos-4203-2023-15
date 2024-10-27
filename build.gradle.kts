// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application")
    id("kotlin-android")
    id("jacoco") // Apply the JaCoCo plugin here
    id("dagger.hilt.android.plugin")
    kotlin("plugin.serialization")
}

jacoco {
    toolVersion = "0.8.7" // Latest version at this time
}

tasks.register<JacocoReport>("jacocoTestReport") {
    dependsOn("testDebugUnitTest") // Ensure this matches your test task

    reports {
        xml.required.set(true)       // XML report for SonarCloud
        html.required.set(false)
        csv.required.set(false)
    }

    sourceDirectories.setFrom(files("src/main/java"))
    classDirectories.setFrom(
        fileTree(
            mapOf(
                "dir" to "build/intermediates/classes/debug",
                "excludes" to listOf("**/R.class", "**/R$*.class", "**/BuildConfig.*", "**/Manifest*.*")
            )
        )
    )
    executionData.setFrom(fileTree(mapOf("dir" to "build", "includes" to listOf("**/jacoco/testDebugUnitTest.exec"))))
}