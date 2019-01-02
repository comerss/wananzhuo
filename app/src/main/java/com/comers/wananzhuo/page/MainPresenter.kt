package com.comers.wananzhuo.page

import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.comers.wananzhuo.base.presenter.BasePresenter
import com.comers.wananzhuo.extra.io_main
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

/**
 * Created by 79653 on 2018/12/24.
 * 描述：
 */
class MainPresenter(activity: AppCompatActivity, view: MainInterfaces.MainView) : BasePresenter<MainInterfaces.MainView>(activity,view) {

    fun getData() {
        Observable.interval(1000, TimeUnit.MILLISECONDS)
            .io_main()
            .takeUntil{
                mView==null
            }
            .subscribe {
                Log.i("autoDispose", "-----------3333333333333333333333333333--------$it")
            }
    }
}