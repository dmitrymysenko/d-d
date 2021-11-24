package dmitry.mysenko.clean.ui.search

import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.RadioButton
import androidx.core.os.bundleOf
import androidx.core.view.children
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import dmitry.mysenko.clean.R
import dmitry.mysenko.clean.databinding.FragmentSearchBinding
import dmitry.mysenko.clean.util_recycler.BaseAdapterCallback
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*

@AndroidEntryPoint
class SearchFragment : Fragment(R.layout.fragment_search) {

    private val viewModel: SearchViewModel by viewModels()

    private val viewBinding by viewBinding (FragmentSearchBinding::bind)

    private var isFiltersOpened = false
    private val adapter = SearchResultAdapter()

    @FlowPreview
    @ExperimentalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(viewBinding) {
            recyclerView.adapter = adapter
            adapter.attachCallback(object : BaseAdapterCallback<SearchItem>{
                override fun onItemClick(model: SearchItem, view: View, position: Int) {
                    findNavController().navigate(R.id.action_searchFragment_to_searchDetailsFragment, bundleOf(Pair(URL, model.url)))
                }
            })
            filters.setOnClickListener {
                isFiltersOpened = !isFiltersOpened
                arrow.animate()
                    .rotation(if (isFiltersOpened) 180f else 0f)
                    .withStartAction {
                        radioGroup.isVisible = isFiltersOpened
                    }
                    .setInterpolator(AccelerateDecelerateInterpolator())
                    .duration = 200

            }
            radioGroup.children.forEach { child ->
                if (child is RadioButton) {
                    child.setOnCheckedChangeListener { _, isChecked ->
                        if (isChecked) {
                            radioGroup.children.forEach { v ->
                                if (child != v) (v as RadioButton).isChecked = false
                            }
                            viewModel.setNewCategory(
                                when (child.id) {
                                    R.id.rb_races -> Categories.races
                                    R.id.rb_equipments -> Categories.equipments
                                    R.id.rb_spells -> Categories.spells
                                    R.id.rb_feats -> Categories.feats
                                    R.id.rb_monsters -> Categories.monsters
                                    R.id.rb_rules -> Categories.rules
                                    else -> Categories.classes
                                }
                            )
                        }
                    }
                }
            }

            viewModel.observeSearch(
                callbackFlow {
                    etSearch.addTextChangedListener(afterTextChanged = {
                        trySend(it.toString().trim())
                    })
                    this.awaitClose { etSearch.addTextChangedListener() }
                }
            )

            viewModel.stateFlow
                .onEach { state ->
                    when(state.searchScreenState){
                        SearchScreenState.Loading -> {
                            loader.isVisible = true
                        }
                        SearchScreenState.Empty -> {
                            loader.isVisible = false
                            error.isVisible = false
                            empty.isVisible = true
                            adapter.setList(listOf())
                        }
                        SearchScreenState.Data -> {
                            loader.isVisible = false
                            error.isVisible = false
                            empty.isVisible = false
                            (state.data)?.let { adapter.setList(it) }
                        }
                        SearchScreenState.Error -> {
                            loader.isVisible = false
                            error.isVisible = true
                            empty.isVisible = false
                            adapter.setList(listOf())
                        }
                    }
                }
                .launchIn(lifecycleScope)
        }
    }

    companion object{
        const val URL = "url"
    }
}