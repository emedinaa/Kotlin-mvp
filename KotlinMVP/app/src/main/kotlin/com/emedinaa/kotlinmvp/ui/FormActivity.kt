package com.emedinaa.kotlinmvp

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.TextView
import butterknife.ButterKnife

open class FormActivity : AppCompatActivity() {

   protected fun injectView()
   {
       ButterKnife.bind(this)
   }

   protected fun next(bundle: Bundle,activity:Class<*>, destroy: Boolean){
       val intent = Intent(this, activity)
       if(bundle!=null)intent.putExtras(bundle)
       startActivity(intent)
       if(destroy)finish()
   }

   protected fun showMessage(container: View, message: String) {

        val snackbar = Snackbar.make(container, message, Snackbar.LENGTH_LONG)
        snackbar.setActionTextColor(Color.RED)
        val sbView = snackbar.getView()
        val textView = sbView.findViewById(android.support.design.R.id.snackbar_text) as TextView
        textView.setTextColor(Color.WHITE)
        snackbar.show()
    }
}
