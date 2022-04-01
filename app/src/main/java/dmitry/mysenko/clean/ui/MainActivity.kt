package dmitry.mysenko.clean.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.ViewTreeObserver
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.fragment.app.FragmentContainerView
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import dmitry.mysenko.clean.R
import dmitry.mysenko.clean.domain.categories.usecases.GetCategoryItemsUseCase
import dmitry.mysenko.clean.domain.classes.usecases.GetCharacterClassUseCase
import dmitry.mysenko.clean.domain.races.usecases.GetCharacterRaceUseCase
import dmitry.mysenko.clean.util_insets.addSystemBottomPadding
import dmitry.mysenko.clean.util_insets.addSystemTopPadding
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

    private var navController: NavController? = null
    private var navHostFragment: NavHostFragment? = null
    private var bottomNavigationView: BottomNavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_main)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        bottomNavigationView = findViewById(R.id.bottom_nav_view)
        bottomNavigationView?.addSystemBottomPadding()
        findViewById<FragmentContainerView>(R.id.main_nav_host_fragment).addSystemTopPadding()

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
//            lifecycleScope.launch {
//                getCharacterRaceUseCase.execute("dragonborn")
////                getCategoryItemsUseCase.execute("races")
//                getCharacterClassUseCase.execute("warlock")
//
//            }
        }, 2000)

        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.main_nav_host_fragment) as NavHostFragment
        navController = navHostFragment?.navController

        navController?.let {
            bottomNavigationView?.setupWithNavController(it)
        }

    }
}