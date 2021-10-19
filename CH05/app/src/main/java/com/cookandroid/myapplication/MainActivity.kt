package com.cookandroid.myapplication

import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )

        val baseLayout = LinearLayout(this)
        baseLayout.orientation = LinearLayout.VERTICAL
        baseLayout.setBackgroundColor(Color.WHITE)
        setContentView(baseLayout, params)

        var et = EditText(this)
        et.setText("IT Cookbook.Android")
        baseLayout.addView(et)

        var btn = Button(this)
        btn.text = "버튼입니다"
        btn.setBackgroundColor(Color.YELLOW)
        baseLayout.addView(btn)

        var tv = TextView(this)
        tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30.0f)
        tv.setTextColor(Color.RED)
        baseLayout.addView(tv)

        btn.setOnClickListener{
            var et_text: String = et.text.toString()
            tv.setText(et_text)
        }

    }
}