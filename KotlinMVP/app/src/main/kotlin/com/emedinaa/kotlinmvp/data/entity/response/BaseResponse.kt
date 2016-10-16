package com.emedinaa.kotlinmvp.data.entity.response

/**
 * Created by eduardomedina on 6/10/16.
 */
open class BaseResponse {

    private val SUCCESS:Int= 200

    private var msg:String?=null
    private var status:Int?=0

    fun isSuccess():Boolean{
        if(status==SUCCESS)return  true
        return false
    }

}