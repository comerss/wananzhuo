package com.comers.wananzhuo.base.presenter

import com.comers.wananzhuo.base.view.AbstractView
import io.reactivex.disposables.Disposable

/**
 * Created by 79653 on 2018/12/24.
 * 描述：
 */
interface AbstractPresenter<T : AbstractView> {
    fun attachView(view: T)
    fun detachView()
    fun addDisposable(disposable: Disposable)
}