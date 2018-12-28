package com.comers.wananzhuo.page

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.comers.wananzhuo.R
import com.comers.wananzhuo.extra.autoDispose
import com.comers.wananzhuo.extra.io_main
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_home.*
import java.util.concurrent.TimeUnit

class HomeActivity : AppCompatActivity(), MainInterfaces.MainView {
    override fun showView() {

    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                message.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                message.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        showData()
    }

    var check: MainPresenter? = MainPresenter(this)
    private fun showData() {
        Observable.interval(1000, TimeUnit.MILLISECONDS)
            .autoDispose(this)
            .io_main()
            .subscribe {
                Log.i("autoDispose", "-----------3333333333333333333333333333--------$it")
            }
    }

}
