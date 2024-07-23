plugins {
    id("kotdev.android.library")
}

android {
    namespace = "com.kotdev.trading.history.model"
}

dependencies {
    api(project(":core"))
}

