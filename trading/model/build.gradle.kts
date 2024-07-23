plugins {
    id("kotdev.android.library")
}

android {
    namespace = "com.kotdev.trading.trading.model"
}

dependencies {
    api(project(":history:model"))
    api(project(":core"))
    api(libs.android.chart)
}

