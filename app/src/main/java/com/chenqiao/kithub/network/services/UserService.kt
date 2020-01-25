package com.chenqiao.kithub.network.services

import com.chenqiao.kithub.network.entities.User
import com.chenqiao.kithub.network.retrofit
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import rx.Observable

/**
 * Created by chenqiao on 2020-01-25.
 * e-mail : mrjctech@gmail.com
 */


interface UserApi {

    @GET("/user")
    fun getAuthenticatedUser(): Observable<User>

//    @GET("/users")
//    fun allUsers(@Query("since") since: Int, @Query("per_page") per_page: Int = 20): Observable<GitHubPaging<User>>
//
//    @GET("/users/{login}/following")
//    fun following(@Path("login") login: String, @Query("page") page: Int = 1, @Query("per_page") per_page: Int = 20): Observable<GitHubPaging<User>>
//
//    @GET("/users/{login}/followers")
//    fun followers(@Path("login") login: String, @Query("page") page: Int = 1): Observable<GitHubPaging<User>>

}

object UserService: UserApi by retrofit.create(UserApi::class.java)