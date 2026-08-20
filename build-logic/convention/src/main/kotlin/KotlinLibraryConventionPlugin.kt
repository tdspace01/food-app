import ConventionConstants.Plugins
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension

class KotlinLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(Plugins.JAVA_LIBRARY)
                apply(Plugins.KOTLIN_JVM)
            }

            extensions.configure<JavaPluginExtension> {
                sourceCompatibility = ConventionConstants.JAVA_VERSION
                targetCompatibility = ConventionConstants.JAVA_VERSION
            }

            extensions.configure<KotlinJvmProjectExtension> {
                compilerOptions {
                    jvmTarget.set(ConventionConstants.JVM_TARGET)
                }
            }
        }
    }
}