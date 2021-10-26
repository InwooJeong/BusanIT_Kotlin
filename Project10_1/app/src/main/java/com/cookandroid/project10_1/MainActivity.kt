package com.cookandroid.project10_1

import android.content.Intent
import android.icu.text.CaseMap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title="3 Activities"

        var r2nd = findViewById<RadioButton>(R.id.r2nd)
        var btnNewActivity = findViewById<Button>(R.id.btnNewActivity)

        btnNewActivity.setOnClickListener{
            var secondIntent = Intent(applicationContext, SecondActivity::class.java)
            var thirdIntent = Intent(applicationContext, ThirdActivity::class.java)

            if(r2nd.isChecked){
                startActivity(secondIntent)
            }else{
                startActivity(thirdIntent)
            }
        }
    }
}