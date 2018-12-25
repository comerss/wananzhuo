package com.comers.wananzhuo.base.activity

import android.os.Bundle
import com.comers.wananzhuo.base.view.AbstractView

/**
 * Created by 79653 on 2018/12/21.
 * 描述：
 */
abstract class BaseActivity : AbstractActivity(),
    AbstractView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun showDialog() {

    }

    override fun hideDialog() {
    }

    override fun showError(str: String?) {

    }

    override fun showToast(str: String?) {

    }
}