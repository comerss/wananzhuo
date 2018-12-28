package com.comers.wananzhuo.http

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class LoggingInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        //这个chain里面包含了request和response，所以你要什么都可以从这里拿
        val request = chain.request()

        val reqBuffer = StringBuffer()
        reqBuffer.append("-----------------------------------------------------------------------------")
            .append("\n")
            .append("请求方式：" + request.method())
            .append("\n")
            .append(request.url())
            .append(request.body()?.toString())

        val response = chain.proceed(request)

        val responseBody = response.peekBody((1024 * 1024).toLong())
        val resBuffer = StringBuffer()
        resBuffer.append("请求返回：")
            .append("\n")
            .append(responseBody?.string())
            .append("\n")
            .append("-----------------------------------------------------------------------------------")
        Log.i("HttpInfo", reqBuffer.toString())
        Log.i("HttpInfo", resBuffer.toString())
        return response
    }

}
