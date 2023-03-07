plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "tech.ericwathome.data"
    compileSdk = ProjectConfig.COMPILE_SDK

    defaultConfig {
        minSdk = ProjectConfig.MINIMUM_SDK
        targetSdk = ProjectConfig.TARGET_SDK

        testInstrumentationRunner = TestRunners.ANDROID_JUNIT_RUNNER
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.bundles.implementation)
    testImplementation(libs.bundles.testImplementation)
    androidTestImplementation(libs.bundles.androidTestImplementation)
    debugImplementation(libs.bundles.debugImplementation)
    kapt(libs.bundles.kapt)
}