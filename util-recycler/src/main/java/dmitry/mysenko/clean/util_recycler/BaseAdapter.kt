package dmitry.mysenko.clean.util_recycler

import android.util.Log
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T> : RecyclerView.Adapter<BaseViewHolder<T>>() {
    protected var dataList: MutableList<T> = mutableListOf()
    protected var callback: BaseAdapterCallback<T>? = null


    var hasItems = false

    fun attachCallback(callback: BaseAdapterCallback<T>) {
        this.callback = callback
    }

    fun detachCallback() {
        this.callback = null
    }

    fun setList(newDataList: List<T>) {
        val diffUtils = MyDiffUtil(dataList, newDataList)
        val diffResult = DiffUtil.calculateDiff(diffUtils)
        this.dataList.clear()
        this.dataList.addAll(newDataList)
        hasItems = true
        diffResult.dispatchUpdatesTo(this)
    }

    fun getList(): List<T> {
        return dataList
    }

    fun addItem(newItem: T) {
        dataList.add(newItem)
        notifyItemInserted(dataList.size - 1)
    }

    fun addItemToTop(newItem: T) {
        dataList.add(0, newItem)
        notifyItemInserted(0)
    }

    fun updateItem(newItem: T, position: Int) {
        dataList[position] = newItem
        notifyItemChanged(position)
    }

    fun removeItem(item: T) {
        val position = dataList.indexOf(item)
        removeItem(position)
    }

    fun removeItem(position: Int) {
        dataList.removeAt(position)
        notifyItemRemoved(position)
    }

    fun updateItems(itemsList: List<T>) {
        dataList.clear()
        setList(itemsList)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.bind(dataList[position])

        holder.itemView.setOnClickListener {
            callback?.onItemClick(
                dataList[holder.adapterPosition],
                holder.itemView,
                holder.adapterPosition
            )
        }
    }

    override fun getItemCount(): Int {
        return dataList.count()
    }


}