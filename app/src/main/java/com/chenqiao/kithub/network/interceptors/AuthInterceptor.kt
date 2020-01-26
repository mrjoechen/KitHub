package com.chenqiao.kithub.network.interceptors

import android.util.Base64
import com.chenqiao.kithub.model.account.AccountManager
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by chenqiao on 2020-01-26.
 * e-mail : mrjctech@gmail.com
 */

class AuthInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val originalRequest = chain.request()
        return chain.proceed(originalRequest.newBuilder()
            .apply {
                when{
                    originalRequest.url().pathSegments().contains("authorizations") -> {
                        val userCredentials = AccountManager.username + ":" + AccountManager.passwd
                        val auth = "Basic " + String(
                            Base64.encode(
                                userCredentials.toByteArray(),
                                Base64.DEFAULT
                            )
                        )

                        header("Authorization", auth)
                    }

                    AccountManager.isLoggedIn() -> {
                        val auth = "Token " + AccountManager.token
                        header("Authorization", auth)
                    }

                    else -> removeHeader("Authorization")

                }
            }
            .build()
        )
    }

}