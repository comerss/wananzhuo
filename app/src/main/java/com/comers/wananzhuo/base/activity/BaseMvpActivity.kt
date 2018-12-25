package com.comers.wananzhuo.base.activity

import android.os.Bundle
import com.comers.wananzhuo.base.presenter.BasePresenter

/**
 * Created by 79653 on 2018/12/21.
 * 描述：
 */
abstract class BaseMvpActivity<T : BasePresenter<*>> : BaseActivity() {
    lateinit var mPresenter: T
    override fun onCreate(savedInstanceState: Bundle?) {
        mPresenter = createPresenter()
        super.onCreate(savedInstanceState)
    }

    abstract fun createPresenter(): T

    override fun showDialog() {
    }

    override fun hideDialog() {
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }
}