package com.example.sandy.kotlin_mvp.view

import android.database.Cursor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleCursorAdapter
import android.widget.Toast
import com.example.sandy.kotlin_mvp.R
import com.example.sandy.kotlin_mvp.R.id.et1
import com.example.sandy.kotlin_mvp.R.id.et2
import com.example.sandy.kotlin_mvp.beans.IncExpBean
import com.example.sandy.kotlin_mvp.model.IncExpModel
import com.example.sandy.kotlin_mvp.presenter.IncExpPresenterAPI
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),IncExpViewAPI {
    override fun addResponse(msg: String) {
        Toast.makeText(this,msg,
                Toast.LENGTH_LONG).show()
    }

    override fun viewResponse(c: Cursor) {

        var myadapter = SimpleCursorAdapter(this,
                R.layout.indiview,c,
                arrayOf("date_","money","desc_","type"),
                intArrayOf(R.id.date,R.id.money,R.id.desc,R.id.type),
                0)
        lview.adapter = myadapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        add.setOnClickListener({
            var bean = IncExpBean(et1.text.toString(),
                    et2.text.toString().toInt(),et3.text.toString(),
                    sp1.selectedItem.toString())

            var api: IncExpPresenterAPI =
                    IncExpModel(this@MainActivity )

            api.addInput(bean)
        })
        view.setOnClickListener({
            var api:IncExpPresenterAPI =
                    IncExpModel(this@MainActivity )
            api.viewInput(sp1.selectedItem.toString())
        })
    }
}
