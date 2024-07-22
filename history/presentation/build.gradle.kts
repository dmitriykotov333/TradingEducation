plugins {
    id("kotdev.android.library")
    id("kotdev.android.hilt")
}

android {
    namespace = "com.kotdev.trading.history.presentation"
}

dependencies {
    api(project(":history:data"))
    api(project(":core"))
    implementation(libs.android.lifecycle.runtime)
    kapt(libs.android.lifecycle.compiler)

}

