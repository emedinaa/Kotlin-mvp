package com.emedinaa.kotlinmvp.ui

import android.os.Bundle
import android.widget.TextView
import butterknife.BindView
import com.emedinaa.kotlinmvp.FormActivity
import com.emedinaa.kotlinmvp.R
import com.emedinaa.kotlinmvp.model.entity.User

class DashboardActivity : FormActivity() {

    @BindView(R.id.tviUsername)
    lateinit var tviUsername:TextView

    var user:User?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        injectView()
        extras()
        populate()
    }

    private fun populate() {
        tviUsername.setText("Welcome "+user!!.firstname+" "+user!!.lastname)
    }

    private fun extras() {
        if(intent!=null){
            var bundle:Bundle= intent.extras
            if(bundle!=null){
                user= bundle.getParcelable(ENTITY)
            }
        }
    }

    companion object {
        const val ENTITY = "ENTITY"
    }
}
