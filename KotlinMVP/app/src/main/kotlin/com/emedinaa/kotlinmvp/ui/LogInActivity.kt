package com.emedinaa.kotlinmvp.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import butterknife.BindView
import com.emedinaa.kotlinmvp.FormActivity
import com.emedinaa.kotlinmvp.R
import com.emedinaa.kotlinmvp.model.entity.User
import com.emedinaa.kotlinmvp.presenter.LogInPresenter
import com.emedinaa.kotlinmvp.view.LogInView
import kotlinx.android.synthetic.main.activity_log_in.*

class LogInActivity: FormActivity(), LogInView {

    @BindView(R.id.btnLogIn)
    lateinit  var btnLogIn: Button

    @BindView(R.id.eteEmail)
    lateinit var eteEmail: EditText

    @BindView(R.id.etePassword)
    lateinit var etePassword: EditText

    @BindView(R.id.vContainer)
    lateinit var vContainer: View

    @BindView(R.id.llayLoading)
    lateinit var vLoading: View

    var loginPresenter: LogInPresenter?=null
    var username:String?=null
    var password:String?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        injectView()
        loginPresenter= LogInPresenter()
        loginPresenter!!.addView(this)

        ui()
    }


    private fun ui() {
        btnLogIn!!.setOnClickListener{
            //Toast.makeText(this,"email "+username+"  password "+password,Toast.LENGTH_LONG).show()
            logIn()
        }
    }

    override fun showLoading() {
        vLoading!!.setVisibility(View.VISIBLE)
    }

    override fun hideLoading() {
        vLoading!!.setVisibility(View.GONE)
    }

    override fun gotoMain(user: User) {
        val bundle: Bundle = Bundle()
        bundle.putParcelable("ENTITY",user)
        next(bundle, DashboardActivity::class.java,false)
    }

    override fun showMessageError(message: String) {
        showMessage(vContainer!!,message)
    }

    private fun logIn() {
        loginPresenter!!.logIn()
    }

    override fun validate(): Boolean {
        username= eteEmail!!.text.toString().trim()
        password=etePassword!!.text.toString().trim()
        eteEmail!!.setError(null)
        etePassword!!.setError(null)

        if(username!!.isEmpty()){
            eteEmail!!.setError(getString(R.string.msg_ingresar));
            return false
        }

        return true
    }

    override fun getUsernameField(): String {
        return this.username!!
    }

    override fun getPasswordField(): String {
        return this.password!!
    }

    override fun getContext(): Context {
        return this
    }

}
