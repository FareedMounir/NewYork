package com.example.newyork.ui.most_popular

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import com.example.newyork.R
import com.example.newyork.databinding.ActivityMostPopularBinding
import com.example.newyork.ui.base.BaseBindingActivity
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MostPopularActivity :
    BaseBindingActivity<ActivityMostPopularBinding, MostPopularViewModel>() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUpNavController()
        setUpNavigation()
    }

    private fun setUpNavController(){
        navController = findNavController(R.id.nav_host_fragment)
    }

    private fun setUpNavigation() {
        setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun getLayoutResId(): Int = R.layout.activity_most_popular


    override fun initViewModel() {
        getViewModel<MostPopularViewModel>().apply {
            binding.viewModel = this
            viewModel = this
        }
    }


}