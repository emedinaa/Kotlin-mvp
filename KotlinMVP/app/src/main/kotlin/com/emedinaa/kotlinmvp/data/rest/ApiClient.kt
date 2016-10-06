package com.emedinaa.kotlinmvp.data.rest

import com.emedinaa.kotlinmvp.data.entity.request.LogInRaw
import com.emedinaa.kotlinmvp.data.entity.response.LogInResponse
import retrofit.http.Body
import retrofit.http.Headers
import retrofit.http.POST
import retrofit.Callback;
import retrofit.RestAdapter

/**
 * Created by eduardomedina on 6/10/16.
 */
class ApiClient {

    val TAG:String= "ApiClient"


    companion object {

        private var servicesApiInterface:ServicesApiInterface?=null
        fun  getMyApiClient():ServicesApiInterface{

            val retrofit: RestAdapter = RestAdapter.Builder()
                    .setEndpoint("http://api.backendless.com")
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .build()

            servicesApiInterface= retrofit.create(
                    ServicesApiInterface::class.java)

            return  servicesApiInterface as ServicesApiInterface

        }
    }


    interface ServicesApiInterface{
        @Headers(
                "Content-Type: application/json",
                "application-id: 263C86F0-8FDA-9E91-FF97-C825AEAB0B00",
                "secret-key: FBD7D8FE-B077-08C6-FF8A-A017E0F18400",
                "application-type: REST")

        @POST("/v1/users/login")
        fun logIn(@Body raw:LogInRaw, callback:Callback<LogInResponse>)
    }
}