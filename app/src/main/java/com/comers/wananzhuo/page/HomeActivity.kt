package com.comers.wananzhuo.page

import android.support.design.widget.BottomNavigationView
import com.comers.wananzhuo.R
import com.comers.wananzhuo.base.activity.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_home.*
/*
Home界面
* */
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
        mPresenter.getData()
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
