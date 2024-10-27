// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.10" apply false
    id("com.google.dagger.hilt.android") version "2.48.1" apply false
    kotlin("plugin.serialization") version "1.8.10" apply false
    id("com.google.devtools.ksp") version "1.9.10-1.0.13" apply false
    id("jacoco")
}

jacoco {
    toolVersion = "0.8.7" // Use the latest stable version
}

tasks.withType<Test> {
    extensions.configure(JacocoTaskExtension::class) {
        isIncludeNoLocationClasses = true
        excludes = listOf("jdk.internal.*")
    }
}

tasks.register<JacocoReport>("jacocoTestReport") {
    dependsOn("testDebugUnitTest") // Run tests in debug mode

    reports {
        xml.required.set(true)       // XML report required by SonarCloud
        html.required.set(false)     // Optional HTML report
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