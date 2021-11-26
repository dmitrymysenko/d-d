package dmitry.mysenko.clean.ui.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import dmitry.mysenko.clean.R
import dmitry.mysenko.clean.databinding.FragmentSearchDetailsBinding
import dmitry.mysenko.clean.ui.search.Categories
import dmitry.mysenko.clean.ui.search.SearchFragment
import timber.log.Timber

inline fun <reified T : Enum<*>> enumValueOrNull(name: String): T? =
    T::class.java.enumConstants.firstOrNull { it.name == name }

@AndroidEntryPoint
class SearchDetailsFragment : Fragment(R.layout.fragment_search_details) {

    private val viewModel: SearchDetailsViewModel by viewModels()
    private val viewBinding by viewBinding (FragmentSearchDetailsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = arguments?.getString(SearchFragment.URL)?.split("/")
        if (list == null) {
            //show error
        } else {
            val category = enumValueOrNull<Categories>(list[2])
            val index = list[3]
            Timber.e("category = $category index = $index")
        }

    }


}


