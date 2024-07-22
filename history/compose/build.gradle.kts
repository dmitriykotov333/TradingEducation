plugins {
    id("kotdev.core.ui")
}

android {
    namespace = "com.kotdev.trading.history.compose"
}

dependencies {
    api(project(":history:presentation"))
    implementation(libs.android.coil.compose)
}

