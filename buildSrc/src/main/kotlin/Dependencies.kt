object Dependencies {

    object Android {
        const val coreKtx = "androidx.core:core-ktx:1.7.0"
        const val appCompat = "androidx.appcompat:appcompat:1.3.1"
        const val material = "com.google.android.material:material:1.4.0"
        const val constraintlayout = "androidx.constraintlayout:constraintlayout:2.1.1"
    }

    object Coroutines{
        const val version = "1.5.2"

        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
    }

    object Hilt {
        const val version = "2.38.1"

        const val hilt = "com.google.dagger:hilt-android:$version"
        const val hiltDaggerCompiler = "com.google.dagger:hilt-android-compiler:$version"
        const val hiltPlugin = "com.google.dagger:hilt-android-gradle-plugin:$version"
    }

    object Inject{
        const val javaInject = "javax.inject:javax.inject:1"
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
        const val version = "2.4.0-beta02"
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

    object Timber {
        const val timber = "com.jakewharton.timber:timber:5.0.1"
    }

    object ViewBinding {
        const val delegate = "com.github.kirich1409:viewbindingpropertydelegate-noreflection:1.5.0-beta01"
    }

    object Modules{
        const val data = ":data"
        const val domain = ":domain"
        const val util_log = ":util-log"
        const val util_insets = ":util-insets"
    }
}