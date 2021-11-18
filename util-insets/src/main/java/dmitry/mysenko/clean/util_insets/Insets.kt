package dmitry.mysenko.clean.util_insets

import android.graphics.Rect
import android.view.View
import android.view.ViewGroup
import androidx.core.view.*

fun View.updatePadding(
    left: Int = paddingLeft,
    top: Int = paddingTop,
    right: Int = paddingRight,
    bottom: Int = paddingBottom
) {
    setPadding(left, top, right, bottom)
}

fun View.updateMargin(
    left: Int = marginLeft,
    top: Int = marginTop,
    right: Int = marginRight,
    bottom: Int = marginBottom
) {
    val lp = layoutParams as ViewGroup.MarginLayoutParams
    lp.setMargins(left, top, right, bottom)
    layoutParams = lp
}

fun View.addSystemTopPadding(
    targetView: View = this
) {
    doOnApplyWindowInsets { _, insets, initialPadding ->
        targetView.updatePadding(
            top = initialPadding.top + maxOf(
                insets.getInsets(WindowInsetsCompat.Type.statusBars()).top,
                insets.getInsets(WindowInsetsCompat.Type.displayCutout()).top
            )
        )
        insets
    }
}

data class Target(
    val targetView: View,
    val startMargin: Int
)

fun View.addSystemTopMargin(
    targets: List<Target>
) {
    doOnApplyWindowInsets { _, insets, _ ->
        targets.forEach { target ->
            target.targetView.updateMargin(
                top = target.startMargin + maxOf(
                    insets.getInsets(WindowInsetsCompat.Type.statusBars()).top,
                    insets.getInsets(WindowInsetsCompat.Type.displayCutout()).top
                )
            )
        }
        insets
    }
}

fun View.addSystemBottomPadding(
    targetView: View = this
) {
    doOnApplyWindowInsets { _, insets, initialPadding ->
        targetView.updatePadding(
            bottom = initialPadding.bottom + maxOf(
                insets.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom,
                insets.getInsets(WindowInsetsCompat.Type.displayCutout()).bottom
            )
        )
        insets
    }
}

fun View.doOnApplyWindowInsets(block: (View, insets: WindowInsetsCompat, initialPadding: Rect) -> WindowInsetsCompat) {
    val initialPadding = recordInitialPaddingForView(this)
    ViewCompat.setOnApplyWindowInsetsListener(this) { v, insets ->
        block(v, insets, initialPadding)
    }
    requestApplyInsetsWhenAttached()
}

private fun recordInitialPaddingForView(view: View) =
    Rect(view.paddingLeft, view.paddingTop, view.paddingRight, view.paddingBottom)

private fun View.requestApplyInsetsWhenAttached() {
    if (isAttachedToWindow) {
        ViewCompat.requestApplyInsets(this)
    } else {
        addOnAttachStateChangeListener(object : View.OnAttachStateChangeListener {
            override fun onViewAttachedToWindow(v: View) {
                v.removeOnAttachStateChangeListener(this)
                ViewCompat.requestApplyInsets(v)
            }

            override fun onViewDetachedFromWindow(v: View) = Unit
        })
    }
}