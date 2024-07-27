plugins {
    id("kotdev.android.library")
    id("kotdev.android.kodein")
}

android {
    namespace = "com.kotdev.trading.trading.data"
}

dependencies {
    api(project(":trading:model"))
    api(project(":database:core"))
    implementation(libs.android.datastore)
    implementation(libs.android.datastore.core)
}

