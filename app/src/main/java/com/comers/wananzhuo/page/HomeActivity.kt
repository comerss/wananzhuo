package com.comers.wananzhuo.page

import android.arch.lifecycle.Lifecycle
import android.support.design.widget.BottomNavigationView
import android.util.Log
import com.comers.wananzhuo.R
import com.comers.wananzhuo.base.activity.BaseMvpActivity
import com.comers.wananzhuo.extra.autoDispose
import com.comers.wananzhuo.extra.io_main
import com.comers.wananzhuo.extra.showToast
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_home.*
import java.util.concurrent.TimeUnit

class HomeActivity : BaseMvpActivity<MainPresenter>(), MainInterfaces.MainView {
    override fun createPresenter(): MainPresenter {
        return MainPresenter(this, this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_home
    }

    override fun initToolbar() {
    }

    override fun initListener() {
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    override fun initData() {
        Observable.interval(1000,TimeUnit.MILLISECONDS)
            .io_main()
            .autoDispose(this, Lifecycle.Event.ON_STOP)
            .doOnNext{
                Log.i("doOnNext","")
            }
            .subscribe {
                showToast(it.toString())
            }
    }

    override fun showView() {

    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

}
