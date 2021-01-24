package com.fahim.navigationjetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var navController: NavController
    lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        navController = navHostFragment.findNavController()
        setSupportActionBar(toolbar)
//        setupActionBarWithNavController(navController)

        appBarConfiguration= AppBarConfiguration(
            setOf(R.id.homeFragment,R.id.searchFragment),
            drawer_layout
        )
        setupActionBarWithNavController(navController,appBarConfiguration)
        bottom_nav.setupWithNavController(navController)
        navigation_drawer.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId==R.id.termsAndConditions){

            val action=NavGraphDirections.actionGlobalTermsFragment()
            navController.navigate(action)
            true
        }
        else{

            item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
        }

    }
}