package dmitry.mysenko.clean.ui.search

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.RadioButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.children
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import dmitry.mysenko.clean.R
import dmitry.mysenko.clean.databinding.FragmentSearchBinding

class SearchFragment : Fragment(R.layout.fragment_search) {

    private val viewBinding by viewBinding(FragmentSearchBinding::bind)

    private var isFiltersOpened = false

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
                if(child is RadioButton){
                    child.setOnClickListener {
                        if(!child.isChecked){
                            radioGroup.children.forEach { view ->
                                (view as RadioButton).isChecked = false
                            }
                            child.isChecked = true
                        }
                    }
                }
            }
        }


    }
}