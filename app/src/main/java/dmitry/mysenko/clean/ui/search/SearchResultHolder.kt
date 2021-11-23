package dmitry.mysenko.clean.ui.search

import dmitry.mysenko.clean.databinding.HolderSearchResultBinding
import dmitry.mysenko.clean.util_recycler.BaseViewHolder

class SearchResultHolder(private val binding: HolderSearchResultBinding) :
    BaseViewHolder<SearchItem>(binding.root) {

    override fun bind(item: SearchItem) {
        with(binding) {
            name.text = item.name
        }
    }
}