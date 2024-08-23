plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdk = 34
    namespace = "com.example.jobapplication"

    defaultConfig {
        applicationId = "com.example.jobapplication"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
        kotlinCompilerExtensionVersion = "1.5.1"
    }

    packaging {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {
  //  implementation(libs.androidx.compose.material)
    //implementation(libs.androidx.material3.android)
    //implementation(libs.androidx.material3.android)
    //  implementation ("androidx.room:room-runtime:2.3.0")
    //kapt ("androidx.room:room-compiler:2.3.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.1.0-alpha05")
    implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")
    //  implementation ("androidx.room:room-runtime:2.3.0")
    kapt ("androidx.room:room-compiler:2.3.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.3")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0")
    implementation ("androidx.compose.runtime:runtime-livedata:1.0.0")
    implementation ("androidx.compose.ui:ui:1.0.0")
    // implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.3.1")
    implementation ("androidx.compose.material:material:1.6.8")
    //  implementation "androidx.compose.ui:ui-tooling:1.0.0"
    // AndroidX Libraries
    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0")
    implementation("androidx.activity:activity-compose:1.4.0")
    implementation("androidx.compose.ui:ui:1.1.0-alpha05")
    implementation("androidx.compose.ui:ui-graphics:1.1.0-alpha05")
    implementation("androidx.compose.ui:ui-tooling:1.1.0-alpha05")
    implementation("androidx.compose.material3:material3:1.1.0-alpha05")
    testImplementation("androidx.compose.ui:ui-test-junit4:1.1.0-alpha05")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.1.0-alpha05")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

    // Room Database Dependencies
    val room_version = "2.6.1"
    implementation("androidx.room:room-runtime:$room_version")
    kapt("androidx.room:room-compiler:$room_version")
    implementation("androidx.room:room-ktx:$room_version")
    implementation("androidx.room:room-rxjava3:$room_version")
    implementation("androidx.room:room-paging:$room_version")
    testImplementation("androidx.room:room-testing:$room_version")

    // Other Dependencies
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.6.0")
}