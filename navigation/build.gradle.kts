plugins {
    id("kotdev.android.library")
    id("kotdev.navigation")
    alias(libs.plugins.compose.compiler)
}
android {
    namespace = "com.kotdev.trading.navigation"
}

composeCompiler {
    enableStrongSkippingMode = true

    reportsDestination = layout.buildDirectory.dir("compose_compiler")
}
dependencies {
    implementation(project(":core"))
    implementation(project(":splash:compose"))
    implementation(project(":history:compose"))
    implementation(project(":articles:compose"))
    implementation(project(":trading:compose"))
}