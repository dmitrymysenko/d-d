plugins {
    id("com.android.application")
    id("kotlinx-serialization")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = Config.packageName
        minSdk = Config.minSDK
        targetSdk = Config.targetSDK
        versionCode = Config.versionCode
        versionName = Config.version()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = Config.minifyEnabled
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
        viewBinding = true
    }
}

dependencies {

    implementation(Dependencies.Android.coreKtx)
    implementation(Dependencies.Android.appCompat)
    implementation(Dependencies.Android.material)
    implementation(Dependencies.Android.constraintlayout)

    implementation(Dependencies.Coroutines.core)
    implementation(Dependencies.Coroutines.android)

    implementation(Dependencies.Dagger.dagger)
    kapt(Dependencies.Dagger.daggerKapt)

    implementation(Dependencies.Kotlin.kotlin)
    implementation(Dependencies.Kotlin.serialization)

    implementation(Dependencies.Lifecycle.runtimeKtx)
    implementation(Dependencies.Lifecycle.viewModelKtx)

    implementation(Dependencies.Navigation.navigationFragment)
    implementation(Dependencies.Navigation.navigationRuntime)
    implementation(Dependencies.Navigation.navigationUi)

    implementation(Dependencies.Retrofit.retrofit)
    implementation(Dependencies.Retrofit.loggingInterceptor)
    implementation(Dependencies.Retrofit.okhttp)
    implementation(Dependencies.Retrofit.serializationConverter)

    implementation(Dependencies.Room.ktx)
    implementation(Dependencies.Room.runtime)
    implementation(Dependencies.Room.paging)
    kapt(Dependencies.Room.compiler)

    implementation(Dependencies.Splash.splash)

    testImplementation(Dependencies.Test.jUnit)
    androidTestImplementation(Dependencies.Test.androidJUnit)
    androidTestImplementation(Dependencies.Test.espresso)
}