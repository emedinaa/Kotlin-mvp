package com.emedinaa.kotlinmvp.view

import com.emedinaa.kotlinmvp.model.entity.User

/**
 * Created by eduardomedina on 6/10/16.
 */
interface LogInView :BaseView{

    fun showLoading()
    fun hideLoading()
    fun gotoMain(user:User)
    fun showMessageError(message:String)
}