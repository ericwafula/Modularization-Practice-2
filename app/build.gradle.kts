plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")

}

android {
    namespace = "tech.ericwathome.modularizationpractice2"
    compileSdk = ProjectConfig.COMPILE_SDK

    defaultConfig {
        applicationId = "tech.ericwathome.modularizationpractice2"
        minSdk = ProjectConfig.MINIMUM_SDK
        targetSdk = ProjectConfig.TARGET_SDK
        versionCode = ProjectConfig.VERSION_CODE
        versionName = ProjectConfig.VERSION_NAME

        testInstrumentationRunner = TestRunners.ANDROID_JUNIT_RUNNER
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packagingOptions {
        resources {
            excludes += ProjectConfig.PACKAGING_OPTIONS_EXCLUDES
        }
    }
}

dependencies {
    implementation(project(Modules.GREETING))
    implementation(project(Modules.CORE_DATA))
    implementation(libs.bundles.implementation)
    testImplementation(libs.bundles.testImplementation)
    androidTestImplementation(libs.bundles.androidTestImplementation)
    debugImplementation(libs.bundles.debugImplementation)
    kapt(libs.bundles.kapt)
}