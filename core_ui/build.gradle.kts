plugins {
    id("kotdev.android.library")
    id("kotdev.android.library.compose")
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.kotdev.trading.core_ui"
}

dependencies {
}