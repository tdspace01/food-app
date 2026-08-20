import org.gradle.api.JavaVersion
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

object ConventionConstants {
    const val COMPILE_SDK = 37
    const val MIN_SDK = 24
    const val TARGET_SDK = 37
    const val APPLICATION_ID = "com.chatapp"
    const val VERSION_CODE = 1
    const val VERSION_NAME = "1.0"
    val JAVA_VERSION = JavaVersion.VERSION_17
    val JVM_TARGET = JvmTarget.JVM_17

    object Plugins {
        const val ANDROID_APPLICATION = "com.android.application"
        const val ANDROID_LIBRARY = "com.android.library"
        const val KOTLIN_JVM = "org.jetbrains.kotlin.jvm"
        const val KOTLIN_SERIALIZATION = "org.jetbrains.kotlin.plugin.serialization"
        const val KOTLIN_COMPOSE = "org.jetbrains.kotlin.plugin.compose"
        const val JAVA_LIBRARY = "java-library"
        const val KSP = "com.google.devtools.ksp"
    }

    object Configurations {
        const val IMPLEMENTATION = "implementation"
        const val TEST_IMPLEMENTATION = "testImplementation"
        const val DEBUG_IMPLEMENTATION = "debugImplementation"
        const val KSP = "ksp"
    }

    object Libraries {
        const val KOIN_ANDROID = "koin-android"
        const val KOIN_COMPOSE = "koin-androidx-compose"
        const val KOIN_CORE_VIEWMODEL = "koin-core-viewmodel"
        const val COMPOSE_BOM = "androidx-compose-bom"
        const val ROOM_RUNTIME = "androidx-room-runtime"
        const val ROOM_KTX = "androidx-room-ktx"
        const val ROOM_COMPILER = "androidx-room-compiler"
        const val ANDROIDX_CORE_KTX = "androidx-core-ktx"
        const val ANDROIDX_LIFECYCLE_RUNTIME = "androidx-lifecycle-runtime-ktx"
        const val ANDROIDX_ACTIVITY_COMPOSE = "androidx-activity-compose"
    }

    object Bundles {
        const val NAVIGATION = "navigation"
        const val TESTING = "testing"
        const val COMPOSE = "compose"
        const val COMPOSE_DEBUG = "compose-debug"
    }
}