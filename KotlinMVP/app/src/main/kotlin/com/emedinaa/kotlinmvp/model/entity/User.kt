package com.emedinaa.kotlinmvp.model.entity

import java.io.Serializable

/**
 * Created by eduardomedina on 6/10/16.
 */
class User: Serializable {

    var username:String?=null
    var name:String?=null
    var lastname:String?=null
    var email:String?=null
    var password: String?=null
    var objectId: String? = null
    var createdAt: String? = null
    var token: String? = null


}