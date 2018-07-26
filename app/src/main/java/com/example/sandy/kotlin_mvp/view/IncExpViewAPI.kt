package com.example.sandy.kotlin_mvp.view

import android.database.Cursor

interface IncExpViewAPI {
    fun addResponse(msg: String)
    fun viewResponse(c: Cursor)
}