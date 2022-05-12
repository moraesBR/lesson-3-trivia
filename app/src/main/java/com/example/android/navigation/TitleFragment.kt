package com.example.android.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
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

        // TODO (09) Call binding.playButton.setOnClickListener and navigate to the gameFragment
        with(binding) {
            playButton.setOnClickListener(
                Navigation.createNavigateOnClickListener(
                    R.id.action_titleFragment2_to_gameFragment
                )
            )
        }
        return binding.root
    }
}