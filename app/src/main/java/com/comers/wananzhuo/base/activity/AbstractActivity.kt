package com.comers.wananzhuo.base.activity

import android.arch.lifecycle.LifecycleObserver
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by 79653 on 2018/12/21.
 * 描述：
 */
abstract class AbstractActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initToolbar()
        initListener()
        initData()
        lifecycle.addObserver(object :LifecycleObserver{
        })
    }

    abstract fun getLayoutId(): Int

    abstract fun initToolbar()

    abstract fun initListener()

    abstract fun initData()

    abstract fun showDialog()

    abstract fun hideDialog()

}
