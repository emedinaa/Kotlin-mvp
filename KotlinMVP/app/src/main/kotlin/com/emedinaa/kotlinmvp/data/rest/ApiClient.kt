package com.emedinaa.kotlinmvp.data.rest

import com.emedinaa.kotlinmvp.BuildConfig
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

    companion object {
        private var servicesApiInterface:ServicesApiInterface?=null
        fun  getMyApiClient():ServicesApiInterface{

            val retrofit: RestAdapter = RestAdapter.Builder()
                    .setEndpoint(BuildConfig.HOST)
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .build()

            servicesApiInterface= retrofit.create(
                    ServicesApiInterface::class.java)

            return  servicesApiInterface as ServicesApiInterface
        }
    }

    interface ServicesApiInterface{
        @Headers("Content-Type: application/json")
        @POST("/api/login")
        fun logIn(@Body raw:LogInRaw, callback:Callback<LogInResponse>)
    }
}