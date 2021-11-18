package dmitry.mysenko.clean.ui.search

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dmitry.mysenko.clean.R

class SearchFragment: Fragment(R.layout.fragment_search) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.search).setOnClickListener {
            findNavController().navigate(R.id.action_searchFragment_to_searchResultFragment)
        }
    }
}