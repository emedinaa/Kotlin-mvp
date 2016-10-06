package com.emedinaa.kotlinmvp.model.interactor

import com.emedinaa.kotlinmvp.data.entity.UserEntity
import com.emedinaa.kotlinmvp.data.entity.request.LogInRaw
import com.emedinaa.kotlinmvp.data.entity.response.LogInResponse
import com.emedinaa.kotlinmvp.data.mapper.UserDataMapper
import com.emedinaa.kotlinmvp.data.rest.ApiClient
import com.emedinaa.kotlinmvp.model.entity.User
import retrofit.Callback;
import retrofit.RetrofitError
import retrofit.client.Response

/**
 * Created by eduardomedina on 6/10/16.
 */
class LogInInteractor {

    var userDataMapper:UserDataMapper?=null

    constructor(mapper: UserDataMapper){
        this.userDataMapper= mapper
    }

    fun logIn(email:String,password:String, logInCallback: LogInCallback){

        var logInRaw:LogInRaw= LogInRaw()
        logInRaw.login= email
        logInRaw.password= password

        ApiClient.getMyApiClient().logIn(logInRaw,object:Callback<LogInResponse>{
            override fun success(logInResponse: LogInResponse?, response: Response?) {

                if(logInResponse!!.isSuccess()){
                    //Log.v("KT","email "+logInResponse!!.email)
                    var user:User= userDataMapper!!.transformResponse(logInResponse)
                    logInCallback.onLogInSuccess(user)
                }else{
                    logInCallback.onLogInError("Error")
                }

            }

            override fun failure(error: RetrofitError?) {

                var message:Any= error!!.message as Any
                logInCallback.onLogInError(message)
            }
        })

    }
}