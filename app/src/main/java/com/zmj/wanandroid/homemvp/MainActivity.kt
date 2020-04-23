package com.zmj.wanandroid.homemvp

import android.content.ContentValues
import android.content.Context
import android.net.Uri
import android.net.wifi.p2p.nsd.WifiP2pDnsSdServiceRequest
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.zmj.baselibray.common.showToast
import com.zmj.baselibray.log.LogUtil
import com.zmj.baselibray.ui.BaseActivity
import com.zmj.wanandroid.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.withTestContext

class MainActivity: BaseActivity<HomePresenter>(),IHomeView{

    private lateinit var drawer: DrawerLayout

    override val layoutRes: Int
        get() = R.layout.activity_main

    override fun createPresenter(): HomePresenter? {
        return HomePresenter(this)
    }

    override fun homeStep() {
    }

    override fun getContext(): Context? {
        return this
    }

    override fun onLoading(loadInfo: String) {
    }

    override fun onCloseLoading() {
    }

    override fun initData(savedInstanceState: Bundle?) {
        //presenter?.fetchHomeData()

        drawer = findViewById(R.id.drawer_layout)
        initToolbar()

        initFloatingActionBtnAndSnackBar()

    }

    private fun initToolbar(){
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu1)
        }

        navView.setCheckedItem(R.id.nav_call)
        navView.setNavigationItemSelectedListener(object :NavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                drawer.closeDrawers()
                return true
            }
        })
    }

    private fun initFloatingActionBtnAndSnackBar(){
        fab.setOnClickListener {
            Snackbar.make(it,"Data deleted",Snackbar.LENGTH_LONG)
                .setAction("Undo",object :View.OnClickListener {
                    override fun onClick(v: View?) {
                        Toast.makeText(this@MainActivity,"Data restored",Toast.LENGTH_SHORT).show()
                    }
                }).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                drawer.openDrawer(GravityCompat.START)
            }
            R.id.backup -> {
                showToast(this,"You clicked backup")
            }
            R.id.delete -> {
                showToast(this,"You clicked delete")
            }
            R.id.settings -> {
                showToast(this,"You clicked setting")
            }
        }
        return true
    }
}
