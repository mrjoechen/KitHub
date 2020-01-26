package com.chenqiao.kithub.network.interceptors

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by chenqiao on 2020-01-26.
 * e-mail : mrjctech@gmail.com
 */
class AcceptInterceptor : Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {

        val originalRequest = chain.request()

        return chain.proceed(originalRequest.newBuilder()
            .apply {
                header("accept", "application/vnd.github.v3+json, ${originalRequest.header("accept")?: ""}")
            }
            .build()
        )

    }

}