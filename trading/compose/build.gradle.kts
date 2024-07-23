plugins {
    id("kotdev.core.ui")
}

android {
    namespace = "com.kotdev.trading.trading.compose"
}

dependencies {
    api(project(":trading:presentation"))
    implementation(libs.android.coil.compose)
}

