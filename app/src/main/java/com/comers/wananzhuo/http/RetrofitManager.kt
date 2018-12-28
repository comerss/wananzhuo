package com.comers.wananzhuo.http

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by 79653 on 2018/12/25.
 * 描述：
 */
object RetrofitManager {
    private lateinit var mOkHttpClient: OkHttpClient
    private lateinit var mRetrofit: Retrofit

    //进行数据的初始化，可以添加公共头部，公共参数等等
    init {
        initClient()
        initRetrofit()
    }

    //初始化Okhttp
    private fun initClient() {
        mOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(15000, TimeUnit.MILLISECONDS)
            .readTimeout(15000, TimeUnit.MILLISECONDS)
            .writeTimeout(15000, TimeUnit.MILLISECONDS)
            .addInterceptor(LoggingInterceptor())
            .addInterceptor(CacheInterceptor())
            .build()
    }

    private fun initRetrofit() {
        mRetrofit = Retrofit.Builder()
            .client(mOkHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    fun create(): ApiService {
        return mRetrofit.create(ApiService::class.java)
    }

    fun <T> create(service: Class<T>): T {
        return mRetrofit.create(service)
    }
}