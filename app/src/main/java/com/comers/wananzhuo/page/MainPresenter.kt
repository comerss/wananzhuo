package com.comers.wananzhuo.page

import android.content.Context
import com.comers.wananzhuo.base.presenter.BasePresenter
import io.reactivex.Observable

/**
 * Created by 79653 on 2018/12/24.
 * 描述：
 */
class MainPresenter(view: MainInterfaces.MainView, context: Context) :
    BasePresenter<MainInterfaces.MainView>(view, context) {
    
    fun getData() {
        addDisposable(Observable.just("").subscribe {

        })
    }
}