/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.navigation

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.android.navigation.databinding.FragmentGameWonBinding


class GameWonFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        val binding: FragmentGameWonBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_game_won, container, false)

        with(binding){
            nextMatchButton.setOnClickListener(
                Navigation.createNavigateOnClickListener(
                    GameWonFragmentDirections.actionGameWonFragmentToTitleFragment()
                )
            )
        }

        val args = arguments?.let { GameWonFragmentArgs.fromBundle(it) }
        Toast.makeText(context,
            "NumCorrect:${args?.numCorrect}, NumQuestions: ${args?.numQuestions}",
            Toast.LENGTH_LONG
        ).show()

        // TODO (01) Add setHasOptionsMenu(true)
        // This allows onCreateOptionsMenu to be called
        setHasOptionsMenu(true)

        return binding.root
    }

    // TODO (02) Create getShareIntent method
    private fun getShareIntent(): Intent {
        val args = arguments?.let { GameWonFragmentArgs.fromBundle(it) }
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(
                Intent.EXTRA_TEXT,
                getString(
                    R.string.share_success_text,
                    args?.numCorrect,
                    args?.numQuestions
                )
            )
        return shareIntent
    }

    // TODO (03) Create shareSuccess method
    private fun shareSuccess() {
        startActivity(getShareIntent())
    }

    // TODO (04) Override and fill out onCreateOptionsMenu
    // Inflate the winner_menu and set the share menu item to invisible if the activity doesn't
    // resolve
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.winner_menu, menu)

        if (null == getShareIntent().resolveActivity(requireActivity().packageManager)){
            menu.findItem(R.id.share)?.setVisible(false)
        }
    }

    // TODO (05) Override onOptionsItemSelected
    // Call the shareSuccess method when the item id matches R.id.share
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }

}
