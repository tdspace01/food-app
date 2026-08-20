plugins {
    alias(libs.plugins.convention.android.library)
}

android {
    namespace = "com.example.menu"
}

dependencies{
    implementation(project(":core:ui"))
    implementation(project(":core:domain"))
    implementation(project(":core:navigation"))
    implementation(project(":core:designsystem"))
}