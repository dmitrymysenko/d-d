package dmitry.mysenko.clean.ui

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.ViewTreeObserver
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import dmitry.mysenko.clean.R
import dmitry.mysenko.clean.domain.classes.usecases.GetCharacterClassesShortUseCase
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject
import android.app.UiModeManager
import android.content.Context

import android.os.Build.VERSION
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var getCharacterClassesShortUseCase: GetCharacterClassesShortUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashScreen = installSplashScreen()
        setContentView(R.layout.activity_main)

        var isReady = false
        val content: View = findViewById(android.R.id.content)
        content.viewTreeObserver.addOnPreDrawListener(
            object : ViewTreeObserver.OnPreDrawListener {
                override fun onPreDraw(): Boolean {
                    return if (isReady) {
                        content.viewTreeObserver.removeOnPreDrawListener(this)
                        true
                    } else {
                        false
                    }
                }
            }
        )
        Handler(Looper.getMainLooper()).postDelayed({
            isReady = true
            lifecycleScope.launch {
                val response = getCharacterClassesShortUseCase.execute()
                Timber.e("response $response")
            }
        }, 2000)


    }
}