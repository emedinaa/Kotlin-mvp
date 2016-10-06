package com.emedinaa.kotlinmvp

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.emedinaa.kotlinmvp.model.entity.User
import com.emedinaa.kotlinmvp.presenter.LogInPresenter
import com.emedinaa.kotlinmvp.view.LogInView
import kotlinx.android.synthetic.main.activity_log_in.*

class LogInActivity : AppCompatActivity(),LogInView {

    var btnLogIn: Button?=null
    var eteEmail:EditText?=null
    var etePassword: EditText?=null
    var vContainer:View?=null
    var vLoading:View?=null

    var loginPresenter:LogInPresenter?=null

    var username:String?=null
    var password:String?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        loginPresenter= LogInPresenter()
        loginPresenter!!.addView(this)

        ui()
    }


    private fun ui() {
        btnLogIn= findViewById(R.id.btnLogIn) as Button
        eteEmail= findViewById(R.id.eteEmail) as EditText
        etePassword = findViewById(R.id.etePassword) as EditText
        vContainer = findViewById(R.id.vContainer)
        vLoading = findViewById(R.id.llayLoading)

        btnLogIn!!.setOnClickListener{

            username= eteEmail!!.text.toString().trim()
            password=etePassword!!.text.toString().trim()

            Toast.makeText(this,"email "+username+"  password "+password,Toast.LENGTH_LONG).show()
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
        val intent = Intent(this, DashboardActivity::class.java)
        //intent.putExtras(bundle)
        startActivity(intent)
        finish()
    }

    override fun showMessageError(message: String) {
        showMessage(vContainer!!,message)
    }

    override fun getContext(): Context {
        return this
    }

    private fun logIn() {
        loginPresenter!!.logIn(username!!,password!!)
    }

    private fun showMessage(container: View, message: String) {

        val snackbar = Snackbar.make(container, message, Snackbar.LENGTH_LONG)
        snackbar.setActionTextColor(Color.RED)
        val sbView = snackbar.getView()
        val textView = sbView.findViewById(android.support.design.R.id.snackbar_text) as TextView
        textView.setTextColor(Color.WHITE)
        snackbar.show()
    }
}
