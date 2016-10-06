package com.emedinaa.kotlinmvp.data.mapper

import com.emedinaa.kotlinmvp.data.entity.UserEntity
import com.emedinaa.kotlinmvp.data.entity.response.LogInResponse
import com.emedinaa.kotlinmvp.model.entity.User

/**
 * Created by eduardomedina on 6/10/16.
 */
class UserDataMapper {

    fun transform(userEntity: UserEntity):User{
        var user:User = User()

        return user
    }

    fun transformResponse(loginResponse:LogInResponse):User{

        var user:User = User()
        if(loginResponse!=null){
            user.email =loginResponse.email
            user.name= loginResponse.name
            user.objectId= loginResponse.objectId
            user.token= loginResponse.token
        }
        return user
    }
}