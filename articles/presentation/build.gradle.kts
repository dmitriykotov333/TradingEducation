plugins {
    id("kotdev.android.library")
    id("kotdev.android.kodein")
}

android {
    namespace = "com.kotdev.trading.articles.presentation"
}

dependencies {
    api(project(":core"))
    implementation(libs.android.lifecycle.runtime)
    kapt(libs.android.lifecycle.compiler)
}

