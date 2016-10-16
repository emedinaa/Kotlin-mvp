package com.emedinaa.kotlinmvp.presenter

import com.emedinaa.kotlinmvp.data.mapper.UserDataMapper
import com.emedinaa.kotlinmvp.model.entity.User
import com.emedinaa.kotlinmvp.model.interactor.LogInCallback
import com.emedinaa.kotlinmvp.model.interactor.LogInInteractor
import com.emedinaa.kotlinmvp.view.LogInView

/**
 * Created by eduardomedina on 6/10/16.
 */
class LogInPresenter:Presenter<LogInView>,LogInCallback {

    private var logInView:LogInView?=null
    private var logInInteractor:LogInInteractor?=null


    fun logIn(){
        if(logInView!!.validate())
        {
            logInView!!.showLoading()
            logInInteractor!!.logIn(logInView!!.getUsernameField(),logInView!!.getPasswordField(),this)
        }
    }

    override fun onLogInSuccess(obj: Any) {
        logInView!!.hideLoading()
        var user:User = obj as User
        logInView!!.gotoMain(user)

    }

    override fun onLogInError(obj: Any) {
        logInView!!.hideLoading()
        logInView!!.showMessageError(obj as String)
    }


    override fun addView(view: LogInView) {
        logInView= view
        logInInteractor= LogInInteractor(UserDataMapper())
    }

    override fun removeView() {
        logInView=null
    }
}