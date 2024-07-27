plugins {
    id("kotdev.android.library")
    id("kotdev.android.kodein")
}

android {
    namespace = "com.kotdev.trading.appwrite"
}

dependencies {
    implementation(project(":core"))
    api(libs.android.appwrite)
}

