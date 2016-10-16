package com.emedinaa.kotlinmvp.data.entity.response

import com.emedinaa.kotlinmvp.data.entity.UserEntity

/**
 * Created by eduardomedina on 6/10/16.
 */
class LogInResponse : BaseResponse() {
    /*
        {
          "msg": "success",
          "status": 200,
          "data": {
            "_id": "5801bc3f3b54e30300b8bc45",
            "id": "5801bc3f3b54e30300b8bc45",
            "username": "emedinaa@gmail.com",
            "password": "123456",
            "firstname": "Eduardo",
            "lastname": "Medina",
            "__v": 0
          }
        }
     */
    var data:UserEntity?=null

}