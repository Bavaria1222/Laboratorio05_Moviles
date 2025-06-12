// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    extra["kotlinVersion"] = "1.8.20"
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${extra["kotlinVersion"]}")
    }
}

plugins {
    id("com.android.application") apply false
    kotlin("android") apply false
    kotlin("kapt") apply false
}