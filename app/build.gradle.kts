plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    // IMPORTANT: Make sure this namespace matches your package name.
    namespace = "com.example.samarth_admin123"
    compileSdk = 34 // Or your project's target SDK

    defaultConfig {
        applicationId = "com.example.samarth_admin123"
        minSdk = 24 // Or your project's minimum SDK
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    // Enable View Binding or Data Binding if you use it
    buildFeatures {
        viewBinding = true
        // dataBinding = true
    }
}

dependencies {
    // These are standard dependencies for a basic Android app.
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // Test dependencies
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
