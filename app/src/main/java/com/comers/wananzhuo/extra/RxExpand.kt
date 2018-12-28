package com.comers.wananzhuo.extra

import android.app.Activity
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by 79653 on 2018/12/26.
 * 描述：
 */
fun <T> Observable<T>.io_main(): Observable<T> {
    return this.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}

fun <T> Single<T>.io_main(): Single<T> {
    return this.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}

fun <T> Maybe<T>.io_main(): Maybe<T> {
    return this.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}
//只能在Activity 中使用当Activity退出时自动取消订阅
fun <T> Observable<T>.autoDispose(activity: Activity): Observable<T> {
    var dispose: Disposable? = null
    return this.doOnLifecycle({
        dispose = it
    }, {

    }).doOnNext {
        if (activity == null || activity.isFinishing) {
            dispose?.dispose()
        }
    }.filter {
        if (activity == null || activity.isFinishing) {
            dispose?.dispose()
        }
        activity != null && !activity.isFinishing
    }
}
