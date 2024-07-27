plugins {
    id("kotdev.android.library")
}

android {
    namespace = "com.kotdev.trading.trading.presentation"
}

dependencies {
    api(project(":trading:data"))
    implementation(libs.android.lifecycle.runtime)
    kapt(libs.android.lifecycle.compiler)
}

