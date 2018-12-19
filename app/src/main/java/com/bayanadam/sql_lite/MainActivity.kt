package com.bayanadam.sql_lite

import android.content.Intent
import android.database.Cursor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    lateinit var lists :ArrayList<Subject>
    lateinit var DB:SQHelper
    lateinit var data:Cursor



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val go = findViewById<Button>(R.id.go_subject)


        go.setOnClickListener {

            startActivity(Intent(this@MainActivity,add_subject::class.java))
        }


        lists = ArrayList<Subject>()
        DB = SQHelper(applicationContext)
        data = DB.data_geter

        val adapter = Adapter(applicationContext,lists)
        val recycler = findViewById<RecyclerView>(R.id.list)


        ShowData()


        list.layoutManager = GridLayoutManager(applicationContext,2)
        list.adapter = adapter



    }



    fun ShowData() {


        if (data.count == 0) {

            Toast.makeText(applicationContext,"There is no items",Toast.LENGTH_SHORT).show()
        }

        while (data.moveToNext()) {


            lists.add(Subject(data.getString(0),
                    data.getString(1),
                    data.getString(2)
            ))

        }




    }


    override fun onStart() {
        super.onStart()
        ShowData()
    }



}
