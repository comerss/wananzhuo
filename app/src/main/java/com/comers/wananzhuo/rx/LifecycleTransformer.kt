package com.comers.wananzhuo.rx

import io.reactivex.*
import org.reactivestreams.Publisher

/**
 * Created by 79653 on 2018/12/27.
 * 描述：
 */

class LifecycleTransformer<T> internal constructor(internal val observable: Observable<*>) :
    ObservableTransformer<T, T>, FlowableTransformer<T, T>, SingleTransformer<T, T>, MaybeTransformer<T, T> {


    override fun apply(upstream: Observable<T>): ObservableSource<T> {
        return upstream.takeUntil(observable)
    }

    override fun apply(upstream: Flowable<T>): Publisher<T> {
        return upstream.takeUntil(observable.toFlowable(BackpressureStrategy.LATEST))
    }

    override fun apply(upstream: Single<T>): SingleSource<T> {
        return upstream.takeUntil(observable.firstOrError())
    }

    override fun apply(upstream: Maybe<T>): MaybeSource<T> {
        return upstream.takeUntil(observable.firstElement())
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }

        val that = o as LifecycleTransformer<*>?

        return observable == that!!.observable
    }

    override fun hashCode(): Int {
        return observable.hashCode()
    }

    override fun toString(): String {
        return "LifecycleTransformer{" +
                "observable=" + observable +
                '}'.toString()
    }
}