package com.stormsec.senacap

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var fragment : Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fragment = HomeFragment()
        val fragmentTransaction : FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_home -> {
                fragment = HomeFragment()
                title = "Home"
                val fragmentTransaction : FragmentTransaction = supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.fragment_container, fragment)
                fragmentTransaction.commit()
            }
            R.id.nav_buy -> {
               fragment = BuyFragment()
                title = "Comprar Títulos"
                val fragmentTransaction : FragmentTransaction = supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.fragment_container, fragment)
                fragmentTransaction.commit()
            }
            R.id.nav_mine -> {
              fragment = MineFragment()
              title = "Meus Títulos"
              val fragmentTransaction : FragmentTransaction = supportFragmentManager.beginTransaction()
              fragmentTransaction.replace(R.id.fragment_container, fragment)
              fragmentTransaction.commit()
            }
            R.id.nav_results -> {
              fragment = ResultsFragment()
              title = "Resultados"
              val fragmentTransaction : FragmentTransaction = supportFragmentManager.beginTransaction()
              fragmentTransaction.replace(R.id.fragment_container, fragment)
              fragmentTransaction.commit()

            }
            R.id.nav_rescue -> {
              fragment = RescueFragment()
              title ="Resgatar Títulos"
              val fragmentTransaction : FragmentTransaction = supportFragmentManager.beginTransaction()
              fragmentTransaction.replace(R.id.fragment_container, fragment)
              fragmentTransaction.commit()

            }
            R.id.nav_config -> {
                Toast.makeText(this,"NÃO DISPONÍVEL", Toast.LENGTH_LONG).show()
            }
            R.id.nav_logout -> {
              finish()
            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
