package com.chenqiao.kithub.network

import com.chenqiao.common.ext.ensureDir
import com.chenqiao.kithub.AppContext
import com.chenqiao.kithub.network.interceptors.AcceptInterceptor
import com.chenqiao.kithub.network.interceptors.AuthInterceptor
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory2
import retrofit2.converter.gson.GsonConverterFactory
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * Created by chenqiao on 2020-01-25.
 * e-mail : mrjctech@gmail.com
 */


private const val BASE_URL = "https://api.github.com"

//通过一个 QueryParameter 让 CacheInterceptor 添加 no-cache
const val FORCE_NETWORK = "forceNetwork"

private val cacheFile by lazy {
    File(AppContext.cacheDir, "WebServiceApi").apply {
        ensureDir()
    }
}

val retrofit by lazy {
    Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJavaCallAdapterFactory2.createWithSchedulers(Schedulers.io(), AndroidSchedulers.mainThread()))
        .client(OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .cache(Cache(cacheFile, 1024 * 1024 *1024))
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addInterceptor(AuthInterceptor())
            .addInterceptor(AcceptInterceptor())
            .build())
        .baseUrl(BASE_URL)
        .build()


}