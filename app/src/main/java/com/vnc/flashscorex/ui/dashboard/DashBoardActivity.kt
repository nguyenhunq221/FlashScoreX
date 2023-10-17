package com.vnc.flashscorex.ui.dashboard

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationBarView
import com.vnc.flashscorex.R
import com.vnc.flashscorex.databinding.ActivityDashBoardBinding

class DashBoardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashBoardBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.findNavController()

//        val mNavigationItemSelected = object : NavigationBarView.OnItemSelectedListener {
//            override fun onNavigationItemSelected(item: MenuItem): Boolean {
//                when (item.itemId) {
//                    R.id.fragmentHome -> {
//                        NavigationUI.onNavDestinationSelected(
//                            item,
//                            navController
//                        )
//                        return true
//                    }
//                    R.id.favorFragment -> {
//                        NavigationUI.onNavDestinationSelected(
//                            item,
//                            navController
//                        )
//                        return true
//                    }
//                    R.id.predictFragment -> {
//                        NavigationUI.onNavDestinationSelected(
//                            item,
//                            navController
//                        )
//                        return true
//                    }
//                    R.id.newsFragment -> {
//                        NavigationUI.onNavDestinationSelected(
//                            item,
//                            navController
//                        )
//                        return true
//                    }
//                    else -> {
//                        return false
//                    }
//                }
//            }
//        }

        val appBarConfiguration = AppBarConfiguration(setOf(R.id.fragmentHome,R.id.favorFragment,R.id.favorFragment,R.id.predictFragment))
        setupActionBarWithNavController(navController,appBarConfiguration)

        binding.bottomNavigation.setupWithNavController(navController)
//        binding.bottomNavigation.apply {
//            setOnItemSelectedListener(mNavigationItemSelected)
//        }

    }
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
//
//    val swipeDelete = object : SwipeToDeleteCallback(this) {
//        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
//            val product = adapter.getStageList()[viewHolder.adapterPosition]
//
//            AlertDialog.Builder(this@ErrorStatisticActivity)
//                .setTitle(getString(R.string.stage_list_delete, product.productCode))
//                .setPositiveButton(getString(R.string.dialog_ok)) { _, _ ->
//                    viewmodel.stageErrorStatisticDelete(product.id!!)
//                }.setNegativeButton(getString(R.string.dialog_cancel)) { _, _ ->
//                    adapter.notifyDataSetChanged()
//                }
//                .setCancelable(false).create().show()
//        }
//    }

}