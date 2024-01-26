// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val composeVersion = "1.3.3"
    System.setProperty("composeVersion", composeVersion)
    val kotlinVersion = "1.9.0"
    System.setProperty("kotlinVersion", kotlinVersion)

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.48")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${System.getProperty("kotlinVersion")}")
    }
}

plugins {
    id("com.android.application") version "8.2.1" apply false
    id("com.android.library") version "7.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("com.google.dagger.hilt.android") version "2.48" apply false
}