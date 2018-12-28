package com.comers.wananzhuo.http

/**
 * Created by 79653 on 2018/12/26.
 * 描述：
 */
class ApiException :Exception{
     var code: Int? = null

    constructor(throwable: Throwable, code: Int) : super(throwable) {
        this.code = code
    }

    constructor(message: String) : super(Throwable(message))
}