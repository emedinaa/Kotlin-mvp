package com.emedinaa.kotlinmvp.model.entity

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by eduardomedina on 6/10/16.
 */
data class User(val id:String ,val username:String,
                val firstname:String,val lastname:String): Parcelable {

    constructor(source:Parcel): this(source.readString(),source.readString(),
            source.readString(),source.readString())

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        //throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
        dest?.writeString(this.id)
        dest?.writeString(this.username)
        dest?.writeString(this.firstname)
        dest?.writeString(this.lastname)
    }

    override fun describeContents(): Int {
        //throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
        return 0
    }


    companion object {
        @JvmField final val CREATOR: Parcelable.Creator<User> = object : Parcelable.Creator<User> {
            override fun createFromParcel(source: Parcel): User{
                return User(source)
            }

            override fun newArray(size: Int): Array<User?> {
                return arrayOfNulls(size)
            }
        }
    }



}