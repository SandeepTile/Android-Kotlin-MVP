package com.example.sandy.kotlin_mvp.presenter

import com.example.sandy.kotlin_mvp.beans.IncExpBean

interface IncExpPresenterAPI {

    fun addInput(bean: IncExpBean)
    fun viewInput(type:String)

}
