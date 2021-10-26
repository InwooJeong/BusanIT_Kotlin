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

           /* var btn1 = findViewById<Button>(R.id.btnNewActivity)
            var rdo2 = findViewById<RadioButton>(R.id.rdoSecond)
            var rdo3 = findViewById<RadioButton>(R.id.rdoThird)

            btn1.setOnClickListener {

                var in1: Intent? = null
                if(rdo2.isChecked)
                    in1 = Intent(applicationContext, SecondActivity::class.java)
                else if(rdo3.isChecked)
                    in1 = Intent(applicationContext, ThirdActivity::class.java)
                else
                    Toast.makeText(applicationContext, "선택하숑~",  Toast.LENGTH_SHORT).show()

                startActivity(in1)*/
        }
    }
}