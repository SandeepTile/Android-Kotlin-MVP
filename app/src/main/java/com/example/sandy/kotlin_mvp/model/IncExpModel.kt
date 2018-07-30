package com.example.sandy.kotlin_mvp.model

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.sandy.kotlin_mvp.beans.IncExpBean
import com.example.sandy.kotlin_mvp.presenter.IncExpPresenterAPI
import com.example.sandy.kotlin_mvp.view.IncExpViewAPI
import com.example.sandy.kotlin_mvp.view.MainActivity

class IncExpModel:IncExpPresenterAPI {

    var api:IncExpViewAPI? = null
    var dBase : SQLiteDatabase? = null




    constructor(api:IncExpViewAPI){

        var mActivity=api as MainActivity

        this.api=api

        dBase = mActivity.openOrCreateDatabase(
                "incexp", Context.MODE_PRIVATE,
                null)

        dBase!!.execSQL("create table if not exists incexp(_id integer primary key autoincrement,date_ varchar(20),money number,desc_ varchar(500),type varchar(50))")
    }


    override fun addInput(bean: IncExpBean) {


        var cv = ContentValues( )
        cv.put("date_",bean.date);
        cv.put("money",bean.money)
        cv.put("desc_",bean.desc)
        cv.put("type",bean.type)

        var status =    dBase!!.insert("incexp",
                null,cv)
        if(status==-1.toLong()){
            api!!.addResponse("Insertion is Fail")
        }else{
            api!!.addResponse("Insertion is Success")
        }
    }

    override fun viewInput(type: String) {


        var c =   dBase!!.query("incexp",null,
                "type=?",
                arrayOf(type),null,null,null)
        api!!.viewResponse(c)
    }

    }


