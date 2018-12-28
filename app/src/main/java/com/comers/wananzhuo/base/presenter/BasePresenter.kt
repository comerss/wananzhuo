package com.comers.wananzhuo.base.presenter

import android.app.Activity
import android.content.Context
import com.comers.wananzhuo.base.RealApplication
import com.comers.wananzhuo.base.view.AbstractView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by 79653 on 2018/12/24.
 * 描述：
 */
open class BasePresenter<T : AbstractView> : AbstractPresenter<T> {
    var mView: T? = null
    private var compositeDisposable: CompositeDisposable = CompositeDisposable()
    var mContext: Context = RealApplication.context
    var activity:Activity
    constructor(activity: Activity,view: T) {
        this.activity=activity
        attachView(view)
    }

    override fun attachView(view: T) {
        mView = view
    }

    override fun detachView() {
        mView = null
        compositeDisposable.clear()
    }

    override fun addDisposable(disposable: Disposable) {
        disposable?.let {
            compositeDisposable.add(it)
        }
    }

}