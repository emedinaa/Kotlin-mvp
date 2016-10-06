package com.emedinaa.kotlinmvp.data.entity.response

/**
 * Created by eduardomedina on 6/10/16.
 */
open class BaseResponse {

    private val SUCCESS:Int= 0

    private var code:Int?=0
    private var message:String?=null

    fun isSuccess():Boolean{
        if(code==SUCCESS)return  true
        return false
    }

}