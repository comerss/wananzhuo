package com.comers.wananzhuo.base.activity

import android.app.Activity
import android.util.Log
import com.comers.wananzhuo.base.constant.ActivityEvent
import java.util.*

/**
 * Activity的管理
 *
 * @author ll
 * @version 1.0.0
 */
object ActivityManager  {

    /**
     * 保存在栈里的所有Activity
     */
    /**
     * 获取所有的Activities
     *
     * @return Activities
     */
    private var activities: Deque<Activity> = ArrayDeque()
    /**
     * 当前显示的Activity
     */
    /**
     * 获取当前显示的Activity
     *
     * @return 当前显示的Activity，可能为空
     */
    private var currentActivity: Activity? = null
    /**
     * 栈顶Activity
     */
    /**
     * 获取栈顶的Activity
     *
     * @return 栈顶的Activity
     */
    private var lastActivity: Activity? = null

    /**
     * 当Activity执行onCreate时调用 - 保存启动的Activity
     *
     * @param activity 执行onCreate的Activity
     */
    fun onCreate(activity: Activity) {
        activities.add(activity)
    }

    /**
     * 当Activity执行onDestroy时调用 - 移除销毁的Activity
     *
     * @param activity 执行onDestroy时的Activity
     */
    fun onDestroy(activity: Activity) {
        if (lastActivity === activity) {
            lastActivity = null
        }

        activities.remove(activity)
        Log.i("autoDispose","-----------------ActivityManager------onDestroy------------")
    }

    /**
     * 关闭所有activity
     */
    fun finishActivities() {
        for (activity in activities) {
            activity.finish()
        }
        activities.clear()
        System.exit(0)
    }

    /**
     * 当Activity执行onResume时调用 - 保存当前显示的activity，更新栈顶Activity
     *
     * @param activity 执行onResume的Activity
     */
    fun onResume(activity: Activity) {
        currentActivity = activity
    }

    /**
     * 当Activity执行onPause时调用 - 清除当前显示的Activity
     *
     * @param activity 执行onPause的Activity
     */
    fun onPause(activity: Activity) {
        currentActivity = null
        lastActivity = activity
    }

    /**
     * 是否为当前的Activity
     *
     * @param activity activity
     * @return 是：true
     */
    fun isCurrentActivity(activity: Activity): Boolean {
        return currentActivity === activity
    }
    fun contains(activity: Activity):Boolean{
        return activities.contains(activity)
    }

    fun getEvent(activity: Activity): ActivityEvent {
        return ActivityEvent.onStop
    }
}
