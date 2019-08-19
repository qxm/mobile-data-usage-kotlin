package com.qxm.mobiledata.net

import com.google.gson.Gson
import com.qxm.mobiledata.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.nio.charset.Charset

object ApiProvider {
    private val mBaseUrl = "https://data.gov.sg/api/action/"
    private val mRetrofit: Retrofit by lazy {
        val okHttpBuilder = OkHttpClient.Builder()
            .addInterceptor(getCommonParamsInterceptor())

            //.sslSocketFactory(getSSLSocketFactory())
            //.hostnameVerifier(getHostnameVerifier())
        if (BuildConfig.DEBUG) {
            okHttpBuilder.addInterceptor(getHttpLoggingInterceptor())
        }


        Retrofit.Builder()
            .baseUrl(mBaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpBuilder.build())
            .build()
    }

    fun <T> create(clazz: Class<T>): T {
        return mRetrofit.create(clazz)
    }

    /**
     * 通用参数
     */
    private fun getCommonParamsInterceptor() = Interceptor {
        val originRequest = it.request()
        val newRequest = originRequest.newBuilder()
//                .header("aaa", "bbb")
            .build()
        it.proceed(newRequest)
    }

    /**
     * 日志
     */
    private fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }


}