package com.comers.wananzhuo.base

import android.app.Activity
import android.app.Application
import android.os.Bundle

/**
 * Created by 79653 on 2018/12/25.
 * 描述：用来监听Activity生命周期的类，需要在Application里面进行初始化，
 */
class ActivityLifecycleCallbacksImpl : Application.ActivityLifecycleCallbacks {
    override fun onActivityPaused(activity: Activity) {
        ActivityManager.onPause(activity)
    }

    override fun onActivityResumed(activity: Activity) {
        ActivityManager.onResume(activity)
    }

    override fun onActivityStarted(activity: Activity) {
    }

    override fun onActivityDestroyed(activity: Activity) {
        ActivityManager.onDestroy(activity)
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle?) {
    }

    override fun onActivityStopped(activity: Activity) {
    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        ActivityManager.onCreate(activity)
    }
}