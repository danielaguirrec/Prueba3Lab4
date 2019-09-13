package com.example.prueba3lab4


import android.net.Uri
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import android.view.MenuItem
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import androidx.fragment.app.FragmentTransaction
import com.example.prueba3lab4.Fragments.AgregarFragment
import com.example.prueba3lab4.Fragments.BuscarFragment
import com.example.prueba3lab4.Fragments.EliminarFragment
import com.example.prueba3lab4.Fragments.InventarioFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), comunicador{

    private lateinit var peluchito: Peluchitos

    override fun enviarDatos(nombre: String, id: String, cantidad: String, precio: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        peluchito = Peluchitos(nombre, id, cantidad, precio)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()

        val addFragment = AddFragment()
        transaction.replace(R.id.container, addFragment).commit()



        /*   val supermanFragment = SupermanFragment()
           transaction.add(R.id.contenedor, supermanFragment).commit()*/

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()





NavigationView.OnNavigationItemSelectedListener,
AgregarFragment.OnFragmentInteractionListener,
        EliminarFragment.OnFragmentInteractionListener,
        BuscarFragment.OnFragmentInteractionListener,
        InventarioFragment.OnFragmentInteractionListener
{

    lateinit var eliminarFragment: EliminarFragment
    lateinit var agregarFragment: AgregarFragment
    lateinit var buscarFragment: BuscarFragment
    lateinit var inventarioFragment: InventarioFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

   /*     val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }*/
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)
         eliminarFragment= EliminarFragment.newInstance("param 1","param 2")
        agregarFragment = AgregarFragment.newInstance("param 1","param 2")
         buscarFragment = BuscarFragment.newInstance("param 1","param 2")
        inventarioFragment = InventarioFragment.newInstance()

    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_home -> {
                // Handle the camera action
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container, agregarFragment)
                    .addToBackStack(agregarFragment.toString())
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.nav_gallery -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container, eliminarFragment)
                    .addToBackStack(eliminarFragment.toString())
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.nav_slideshow -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container, buscarFragment)
                    .addToBackStack(buscarFragment.toString())
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()

            }
            R.id.nav_tools -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container, inventarioFragment)
                    .addToBackStack(inventarioFragment.toString())
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()

            }

        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onFragmentInteraction(uri: Uri) {

    }
}
