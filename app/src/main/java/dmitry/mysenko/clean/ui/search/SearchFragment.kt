package dmitry.mysenko.clean.ui.search

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.CalendarView
import android.widget.RadioButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.children
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import dmitry.mysenko.clean.R
import dmitry.mysenko.clean.databinding.FragmentSearchBinding
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@AndroidEntryPoint
class SearchFragment : Fragment(R.layout.fragment_search) {

    private val viewModel: SearchViewModel by viewModels()

    private val viewBinding by viewBinding(FragmentSearchBinding::bind)

    private var isFiltersOpened = false

    @FlowPreview
    @ExperimentalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        view.findViewById<Button>(R.id.search).setOnClickListener {
//            findNavController().navigate(R.id.action_searchFragment_to_searchResultFragment)
//        }

        with(viewBinding) {
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
                        SearchScreenState.Loading -> {}
                        SearchScreenState.Empty -> {}
                        SearchScreenState.Data -> {}
                        SearchScreenState.Error -> {}
                    }
                }
                .launchIn(lifecycleScope)
        }
    }
}