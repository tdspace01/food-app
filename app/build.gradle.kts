plugins {
    alias(libs.plugins.convention.android.application)
}

android {
    namespace = "com.example.foodapp"
}

dependencies{
    implementation(projects.core.navigation)
}