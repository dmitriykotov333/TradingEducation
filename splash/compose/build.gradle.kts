plugins {
    id("kotdev.core.ui")
}

android {
    namespace = "com.kotdev.trading.splash.compose"
}

dependencies {
    api(project(":splash:presentation"))
}

