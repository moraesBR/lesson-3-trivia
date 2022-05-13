package com.example.android.navigation

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentTitleBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_title,
            container,
            false
        )

        with(binding) {
            playButton.setOnClickListener(
                Navigation.createNavigateOnClickListener(
                    R.id.action_titleFragment2_to_gameFragment
                )
            )
        }

        // TODO (03) Call setHasOptionsMenu(true)
        // This tells Android that our fragment has an Options Menu, so it will call
        // onCreateOptionsMenu
        setHasOptionsMenu(true)

        return binding.root
    }

    // TODO (04) Override onCreateOptionsMenu
    // Use the passed-in MenuInflater to inflate the overflow_menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu,menu)
    }

    // TODO (05) Override onOptionsItemSelected
    // Return true if NavigationUI.onNavDestinationSelected returns true, else return
    // super.onOptionsItemSelected.
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item, requireView().findNavController()
        ) || super.onOptionsItemSelected(item)
    }
}