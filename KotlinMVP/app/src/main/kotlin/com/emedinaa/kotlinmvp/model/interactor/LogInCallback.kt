package com.emedinaa.kotlinmvp.model.interactor

/**
 * Created by eduardomedina on 6/10/16.
 */
interface LogInCallback {

    fun onLogInSuccess(obj:Any)
    fun onLogInError(obj:Any)

}