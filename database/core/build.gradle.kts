plugins {
    id("kotdev.android.library")
    id("kotdev.android.room")
    id("kotdev.android.hilt")
}

android {
    namespace = "com.kotdev.trading.database.core"
}

dependencies {
    api(project(":database:history"))
    api(project(":database:pair"))
    api(project(":database:balance"))
}

