package com.comers.wananzhuo.extra

import android.content.Context
import android.widget.Toast
import com.comers.wananzhuo.base.RealApplication

/**
 * Created by 79653 on 2018/12/25.
 * 描述：拓展函数
 */
fun Context.showToast(str: String?) {
   Toast.makeText(RealApplication.context,str,Toast.LENGTH_SHORT).show()
}

