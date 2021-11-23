package dmitry.mysenko.clean.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import dmitry.mysenko.clean.databinding.HolderSearchResultBinding
import dmitry.mysenko.clean.util_recycler.BaseAdapter
import dmitry.mysenko.clean.util_recycler.BaseViewHolder
import timber.log.Timber

class SearchResultAdapter: BaseAdapter<SearchItem>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<SearchItem> {
        return SearchResultHolder(HolderSearchResultBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

}