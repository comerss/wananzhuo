package com.comers.wananzhuo.base.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by 79653 on 2018/12/25.
 * 描述：
 */
abstract class AbstracFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(getLayoutId(), container, false)
        initListener()
        initData()
        return view
    }

    abstract fun getLayoutId(): Int

    abstract fun initListener()

    abstract fun initData()

}