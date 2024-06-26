plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "eu.tutorials.myapplicationretrofit"
    compileSdk = 34

    defaultConfig {
        applicationId = "eu.tutorials.myapplicationretrofit"
        minSdk = 24
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

    viewBinding {
        enable = true
    }

    buildFeatures{
        viewBinding = true
    }
}

dependencies {
    implementation("io.coil-kt:coil:2.1.0")
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.android.gms:play-services-basement:18.3.0")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.7")
    testImplementation("junit:junit:4.13.2")

    //retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    //gson
    implementation ("com.google.code.gson:gson:2.10.1")
    implementation ("com.squareup.okhttp3:okhttp:5.0.0-alpha.2")
    implementation ("androidx.webkit:webkit:1.10.0")
    implementation ("com.google.android.material:material:1.11.0")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation ("com.github.denzcoskun:ImageSlideshow:0.1.2")

    implementation ("com.google.android.material:material:1.11.0")
    implementation ("androidx.activity:activity-compose:1.8.2")
    implementation ("androidx.compose.material:material:1.6.6")
    //picaso for converting image link given into API
    implementation ("com.squareup.picasso:picasso:2.8")


}
