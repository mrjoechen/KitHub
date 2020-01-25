package com.chenqiao.kithub.network

import com.chenqiao.common.ext.ensureDir
import com.chenqiao.kithub.AppContext
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * Created by chenqiao on 2020-01-25.
 * e-mail : mrjctech@gmail.com
 */


private const val BASE_URL = "https://api.github.com"

private val cacheFile by lazy {
    File(AppContext.cacheDir, "WebServiceApi").apply {
        ensureDir()
    }
}

val retrofit by lazy {
    Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .client(OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .cache(Cache(cacheFile, 1024 * 1024 *1024))
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build())
        .baseUrl(BASE_URL)
        .build()


}