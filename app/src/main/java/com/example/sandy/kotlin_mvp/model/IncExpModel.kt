package com.example.sandy.kotlin_mvp.model

import com.example.sandy.kotlin_mvp.beans.IncExpBean
import com.example.sandy.kotlin_mvp.presenter.IncExpPresenterAPI
import com.example.sandy.kotlin_mvp.view.IncExpViewAPI

class IncExpModel:IncExpPresenterAPI {
    override fun addInput(bean: IncExpBean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun viewInput(type: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    constructor(api:IncExpViewAPI)
}