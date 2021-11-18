package dmitry.mysenko.clean.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.ViewTreeObserver
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import dmitry.mysenko.clean.R
import dmitry.mysenko.clean.domain.categories.usecases.GetCategoryItemsUseCase
import dmitry.mysenko.clean.domain.classes.usecases.GetCharacterClassUseCase
import dmitry.mysenko.clean.domain.races.usecases.GetCharacterRaceUseCase
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var getCategoryItemsUseCase: GetCategoryItemsUseCase

    @Inject
    lateinit var getCharacterClassUseCase: GetCharacterClassUseCase

    @Inject
    lateinit var getCharacterRaceUseCase: GetCharacterRaceUseCase

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
                getCharacterRaceUseCase.execute("dragonborn")
//                getCategoryItemsUseCase.execute("races")
                getCharacterClassUseCase.execute("warlock")
            }
        }, 2000)


    }
}