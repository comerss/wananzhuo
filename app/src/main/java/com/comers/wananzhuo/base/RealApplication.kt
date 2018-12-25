package com.comers.wananzhuo.base

import android.app.Application
import com.comers.wananzhuo.base.activity.ActivityLifecycleCallbacksImpl

/**
 * Created by 79653 on 2018/12/25.
 * 描述：
 */
class RealApplication :Application() {
    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(ActivityLifecycleCallbacksImpl())
    }
}