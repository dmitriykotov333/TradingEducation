plugins {
    id("kotdev.android.library")
    id("kotdev.android.hilt")
}

android {
    namespace = "com.kotdev.trading.splash.presentation"
}

dependencies {
    api(project(":core"))
    implementation(project(":service"))
    implementation(libs.android.lifecycle.runtime)
    kapt(libs.android.lifecycle.compiler)

}

