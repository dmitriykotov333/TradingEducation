import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.project

class CoreUiConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            pluginManager.run {
                apply("kotdev.android.library")
                apply("kotdev.android.library.compose")
                apply("org.jetbrains.kotlin.plugin.compose")
            }
            dependencies {
                add("api", project(":core_ui"))
                add("api", libs.findLibrary("android-lifecycle-viewmodel").get())
                add("api", libs.findLibrary("android-hilt-navigation").get())
            }
        }
    }

}