plugins {
    id("kotdev.android.library")
    id("kotdev.android.hilt")
    kotlin("plugin.serialization") version "2.0.0"
}

android {
    namespace = "com.kotdev.trading.service"
}

dependencies {
    implementation(project(":core"))
    implementation(project(":appwrite"))
    api(project(":database:core"))
    implementation(libs.serialization.json)
    implementation(libs.android.hilt)
    kapt(libs.android.hilt.compiler)
    implementation(libs.android.coroutine)
    implementation(libs.android.ktor.core)
    implementation(libs.android.ktor.json)
    implementation(libs.android.ktor.serialization)
    implementation(libs.android.ktor.serialization.json)
    implementation(libs.android.ktor.client)
    implementation(libs.android.ktor.negotiation)
    implementation(libs.android.ktor.logging)
}

