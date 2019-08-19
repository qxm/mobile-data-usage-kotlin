package com.qxm.mobiledata.net

import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

fun handleError(e: Throwable) =
    if (e is ConnectException || e is UnknownHostException) {
        "连接错误，请检查您的网络稍后重试"
    } else if (e is SocketTimeoutException) {
        "连接超时，请稍后重试"
    } else if (e is HttpException) { //http状态码错误
        val code = e.code()
        when (code) {
            401 -> "未授权的访问$code"
            in 500..599 -> {
                "服务器错误$code"
            }
            404 -> {
                "服务器找到不给定的接口资源$code"
            }
            in 400..499 -> {
                "网络错误$code"
            }
            else -> {
                "网络未知错误$code"
            }
        }
    } else {
        "未知错误" + e.message
    }