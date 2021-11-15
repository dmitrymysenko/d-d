object Dependencies {

    object Android {
        const val coreKtx = "androidx.core:core-ktx:1.7.0"
        const val appCompat = "androidx.appcompat:appcompat:1.3.1"
        const val material = "com.google.android.material:material:1.4.0"
        const val constraintlayout = "androidx.constraintlayout:constraintlayout:2.1.1"
    }

    object Coroutines{
        const val version = "1.5.1"

        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
    }

    object Dagger {
        const val version = "2.38.1"

        const val dagger = "com.google.dagger:dagger:$version"
        const val daggerKapt = "com.google.dagger:dagger-compiler:$version"
    }

    object Kotlin {
        const val version = "1.5.31"
        const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:$version"
        const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.2"
    }

    object Lifecycle {
        const val version = "2.4.0"
        const val runtimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
        const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
    }

    object Navigation {
        const val version = "2.3.5"
        const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:$version"
        const val navigationUi = "androidx.navigation:navigation-ui-ktx:$version"
        const val navigationRuntime = "androidx.navigation:navigation-runtime-ktx:$version"
    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:2.9.0"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:4.9.1"
        const val okhttp = "com.squareup.okhttp3:okhttp:4.9.1"
        const val serializationConverter = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0"
    }

    object Room {
        const val version = "2.3.0"
        const val ktx = "androidx.room:room-ktx:$version"
        const val runtime = "androidx.room:room-runtime:$version"
        const val paging = "androidx.room:room-paging:2.4.0-alpha04"
        const val compiler = "androidx.room:room-compiler:$version"
    }

    object Splash {
        const val splash = "androidx.core:core-splashscreen:1.0.0-alpha02"
    }

    object Test {
        const val jUnit = "junit:junit:4.13.2"
        const val androidJUnit = "androidx.test.ext:junit:1.1.2"
        const val espresso = "androidx.test.espresso:espresso-core:3.3.0"
    }
}