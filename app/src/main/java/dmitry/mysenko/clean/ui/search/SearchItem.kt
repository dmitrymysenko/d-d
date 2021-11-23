package dmitry.mysenko.clean.ui.search

import dmitry.mysenko.clean.util_recycler.DiffUtilable

data class SearchItem(
    val index: String,
    val name: String,
    val url: String
): DiffUtilable<SearchItem> {

    override fun areItemsTheSame(other: DiffUtilable<SearchItem>) =
        url == (other as SearchItem).url


    override fun areContentsTheSame(other: DiffUtilable<SearchItem>) =
        name == (other as SearchItem).name
}



