package com.emedinaa.kotlinmvp.data.mapper

import com.emedinaa.kotlinmvp.data.entity.UserEntity
import com.emedinaa.kotlinmvp.data.entity.response.LogInResponse
import com.emedinaa.kotlinmvp.model.entity.User

/**
 * Created by eduardomedina on 6/10/16.
 */
class UserDataMapper {

    fun transform(userEntity: UserEntity):User{
        var user:User = User("","","","")
        if(userEntity==null)return user

        user= User(userEntity.id,userEntity.username,userEntity.firstname,
                userEntity.lastname)
        return user
    }

    fun transformResponse(loginResponse:LogInResponse):User{
        var user:User = User("","","","")
        if(loginResponse==null) return  user

        user= transform(loginResponse.data!!)
        return user
    }
}