plugins {
    id("kotdev.core.ui")
}

android {
    namespace = "com.kotdev.trading.articles.compose"
}

dependencies {
    implementation(project(":core"))
    api(project(":articles:presentation"))
    implementation(libs.android.coil.compose)
}

