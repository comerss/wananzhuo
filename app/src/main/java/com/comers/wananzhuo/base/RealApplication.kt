package com.comers.wananzhuo.base

import android.content.Context
import android.support.multidex.MultiDexApplication
import com.comers.wananzhuo.base.activity.ActivityLifecycleCallbacksImpl
import kotlin.properties.Delegates

/**
 * Created by 79653 on 2018/12/25.
 * 描述：
 */
class RealApplication : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        context = this
        registerActivityLifecycleCallbacks(ActivityLifecycleCallbacksImpl())
    }
    companion object {
        var context:Context by Delegates.notNull()
    }
}