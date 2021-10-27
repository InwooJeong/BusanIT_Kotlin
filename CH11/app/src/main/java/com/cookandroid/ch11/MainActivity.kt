package com.cookandroid.ch11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //title = "리스트뷰 테스트"

        /*var mid = arrayOf("히어로즈", "24시", "로스트", "로스트룸", "스몰빌", "탐정몽크", "빅뱅이론",
                        "프렌즈", "덱스터", "글리", "가쉽걸", "테이큰", "슈퍼내추럴", "브이")

        var list = findViewById<View>(R.id.listView1) as ListView

        *//*var adapter : ArrayAdapter<String> = ArrayAdapter(this,
                        android.R.layout.simple_list_item_1, mid)*//*
        var adapter : ArrayAdapter<String> = ArrayAdapter(this,
                        android.R.layout.simple_list_item_multiple_choice, mid)
        list.choiceMode = ListView.CHOICE_MODE_MULTIPLE
        list.adapter = adapter

        list.setOnItemClickListener{ parent, view, position, id ->
            Toast.makeText(applicationContext, mid[position], Toast.LENGTH_SHORT).show()
        }*/

        /*var midList = ArrayList<String>()
        var list = findViewById<ListView>(R.id.listView1)

        var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, midList)
        list.adapter = adapter

        var edtItem = findViewById(R.id.edtItem) as EditText
        var btnAdd = findViewById(R.id.btnAdd) as Button

        btnAdd.setOnClickListener{
            midList.add(edtItem.text.toString())
            adapter.notifyDataSetChanged()
        }

        list.setOnItemLongClickListener{parent, view, position, id ->
            midList.removeAt(position)
            adapter.notifyDataSetChanged()
            false
        }*/
        
        title = "스피너 테스트"

        var movie = arrayOf("쿵푸팬더", "짱구는 못말려", "아저씨",
                "아바타", "대부", "국가대표", "토이스토리3",
                "마당을 나온 암탉", "죽은 시인의 사회", "서유기")

        var spinner = findViewById<Spinner>(R.id.spinner1)

        var adapter: ArrayAdapter<String>
        adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, movie)
        spinner.adapter = adapter
    }
}