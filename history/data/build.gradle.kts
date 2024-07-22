plugins {
    id("kotdev.android.library")
    id("kotdev.android.hilt")
}

android {
    namespace = "com.kotdev.trading.history.data"
}

dependencies {
    implementation(project(":core"))
    api(project(":database:core"))
}

