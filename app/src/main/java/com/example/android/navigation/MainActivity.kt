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

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    // TODO (05) Add private lateinit vars drawerLayout and appBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        )
        // TODO (06) Initialize drawerLayout var from binding

        with(this){
            navController= findNavController(R.id.myNavHostFragment)
            // TODO (07) Add the DrawerLayout as the second parameter to setupActionBarWithNavController

            // Remove AppBar from some Fragments
            val appBarConfiguration = AppBarConfiguration(
                setOf(R.id.titleFragment,
                      R.id.gameOverFragment,
                      R.id.gameWonFragment
                )
            )

            NavigationUI.setupActionBarWithNavController(
                this,
                navController,
                appBarConfiguration
            )
            // TODO (08) Create appBarConfiguration with the navController.graph and drawerLayout
            // TODO (09) Hook the navigation UI up to the navigation view. (navView)
        }

    }

    override fun onSupportNavigateUp(): Boolean{
        // TODO (10) Replace navController.navigateUp with NavigationUI.navigateUp with drawerLayout param
        return navController.navigateUp()
    }
}
