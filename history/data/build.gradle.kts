plugins {
    id("kotdev.android.library")
    id("kotdev.android.hilt")
}

android {
    namespace = "com.kotdev.trading.history.data"
}

dependencies {
    api(project(":database:core"))
    api(project(":history:model"))
}

