plugins {
    alias(libs.plugins.convention.android.application)
}

android {
    namespace = "com.example.foodapp"
}

dependencies{
    implementation(projects.core.data)
    implementation(projects.feature.menu)
    implementation(projects.feature.cart)
    implementation(projects.core.navigation)
    implementation(projects.core.designsystem)
}