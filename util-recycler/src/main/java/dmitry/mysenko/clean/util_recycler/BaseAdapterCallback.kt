package dmitry.mysenko.clean.util_recycler

import android.view.View

interface BaseAdapterCallback<T> {
    fun onItemClick(model: T, view: View, position: Int)
}