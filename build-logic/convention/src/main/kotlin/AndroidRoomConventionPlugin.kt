import com.android.build.api.dsl.CommonExtension
import com.android.build.gradle.LibraryExtension
import extensions.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidRoomConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.kapt")
            }
            extensions.getByType<LibraryExtension>().apply {
                defaultConfig {
                    javaCompileOptions {
                        annotationProcessorOptions {
                            arguments += mapOf(
                                "room.schemaLocation" to "${rootProject.projectDir}/schemas",
                                "room.incremental" to "true"
                            )
                        }
                    }
                }
            }
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            dependencies {
                "implementation"(libs.findLibrary("android.room.ktx").get())
                "implementation"(libs.findLibrary("android.room.runtime").get())
                "kapt"(libs.findLibrary("android.room.compiler").get())
            }
        }
    }
}