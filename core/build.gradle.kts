plugins {
    id("kotdev.android.library")
    id("kotdev.navigation")
}

android {
    namespace = "com.kotdev.trading.core"
}

dependencies {
    api(libs.android.coroutine)
    api(libs.android.collections.immutable)
    api(libs.android.lifecycle.viewmodel)
    api(libs.android.viewmodel.savedstate)
}