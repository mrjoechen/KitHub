package com.chenqiao.kithub.network.services

import com.chenqiao.kithub.network.entities.AuthorizationReq
import com.chenqiao.kithub.network.entities.AuthorizationRsp
import com.chenqiao.kithub.network.retrofit
import com.chenqiao.kithub.settings.Configs
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.PUT
import retrofit2.http.Path
import rx.Observable

/**
 * Created by chenqiao on 2020-01-25.
 * e-mail : mrjctech@gmail.com
 *
 * https://developer.github.com/v3/oauth_authorizations/
 *
 */

interface AuthApi{

    @PUT("/authorizations/clients/${Configs.Account.clientId}/{fingerPrint}")
    fun createAuthorization(@Body req: AuthorizationReq, @Path("fingerPrint") fingerPrint: String = Configs.Account.fingerPrint)
            : Observable<AuthorizationRsp>

    @DELETE("/authorizations/{id}")
    fun deleteAuthorization(@Path("id") id: Int): Observable<Response<Any>>

}

object AuthService: AuthApi by retrofit.create(AuthApi::class.java)