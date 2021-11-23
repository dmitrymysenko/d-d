package dmitry.mysenko.clean.util_recycler

import androidx.recyclerview.widget.DiffUtil

class MyDiffUtil<T>(
    private val oldList: List<T>,
    private val newList: List<T>
): DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        (oldList[oldItemPosition] as DiffUtilable<T>).areItemsTheSame(newList[newItemPosition] as DiffUtilable<T>)

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        (oldList[oldItemPosition] as DiffUtilable<T>).areContentsTheSame(newList[newItemPosition] as DiffUtilable<T>)
}