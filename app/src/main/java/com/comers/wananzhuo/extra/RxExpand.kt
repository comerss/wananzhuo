package com.comers.wananzhuo.extra

import android.app.Activity
import android.arch.lifecycle.Lifecycle
import android.support.v7.app.AppCompatActivity
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
//可以根据Activity的生命周期来取消订阅，但是Activity前提是AppCompatActivity，他为我们提供了生命周期的方法，如果不用这个自己弄一个也是可以的
//为了方便就用现成 的了
fun <T> Observable<T>.autoDispose(activity: AppCompatActivity,event: Lifecycle.Event): Observable<T> {
    var dispose: Disposable? = null
    return this.doOnLifecycle({
        dispose = it
    }, {

    }).doOnNext {
        if (activity == null || activity.lifecycle.currentState==event) {
            dispose?.dispose()
        }
    }.filter {
        if (activity == null ||activity.lifecycle.currentState==event) {
            dispose?.dispose()
        }
        activity != null && !activity.isFinishing
    }
}
