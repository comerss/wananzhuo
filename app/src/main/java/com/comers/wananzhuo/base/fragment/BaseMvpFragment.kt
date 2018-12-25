package com.comers.wananzhuo.base.fragment

import android.os.Bundle
import com.comers.wananzhuo.base.presenter.BasePresenter

/**
 * Created by 79653 on 2018/12/25.
 * 描述：
 */
abstract class BaseMvpFragment<T:BasePresenter<*>>:BaseFragment() {
    lateinit var mPresenter: T
    override fun onCreate(savedInstanceState: Bundle?) {
        mPresenter=createPresenter()
        super.onCreate(savedInstanceState)
    }

    abstract fun createPresenter(): T
    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }
}