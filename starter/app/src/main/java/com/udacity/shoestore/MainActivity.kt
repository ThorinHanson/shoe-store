package com.udacity.shoestore

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var drawerLayout: DrawerLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loggedIn = false
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        drawerLayout = binding.drawerLayout

        val navController = findNavController(R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController)

        appBarConfiguration = AppBarConfiguration(navController.graph)
        NavigationUI.setupWithNavController(binding.navView, navController)

        Timber.plant(Timber.DebugTree())
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.nav_host_fragment)
        return NavigationUI.navigateUp(navController, appBarConfiguration)
    }


//    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
//        menu?.let {
//            val item = it.findItem(R.id.rulesFragment)
//            if (item != null) {
//                if (loggedIn) {
//                    item.setVisible(true)
//                } else {
//                    item.setVisible(false)
//                }
//            }
//        }
//        return true
//    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        if(loggedIn) {
                val inflater: MenuInflater = menuInflater
                inflater.inflate(R.menu.navdrawer_menu, menu)
                return true
        }
        return false
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.login_layout -> logout()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun logout() {
        this.findNavController(R.id.nav_host_fragment).popBackStack(R.id.login_destination, false)
    }

    companion object {
        var loggedIn: Boolean = false
    }
}

