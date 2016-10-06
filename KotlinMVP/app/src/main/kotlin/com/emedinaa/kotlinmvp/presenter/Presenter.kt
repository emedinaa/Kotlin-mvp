package com.emedinaa.kotlinmvp.presenter

/**
 * Created by eduardomedina on 6/10/16.
 */
interface Presenter<T> {

    fun addView(view:T)
    fun removeView()
}