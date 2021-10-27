package com.cookandroid.ch10

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button

class SecondActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second)
        title = "Second 액티비티"
        //var calc = intent.getStringExtra("Calc")

        var inIntent = intent
        //var hapValue = inIntent.getIntExtra("Num1", 0) + inIntent.getIntExtra("Num2",0)
        var calc = inIntent.getStringExtra("Calc")
        var num1 = inIntent.getIntExtra("Num1",0)
        var num2 = inIntent.getIntExtra("Num2",0)

        var hapValue : Int? = null

        if(calc == "+"){
            hapValue = num1 + num2
        }else if(calc == "-"){
            hapValue = num1 - num2
        }else if(calc == "*"){
            hapValue = num1 * num2
        }else{
            hapValue = num1 / num2
        }

        var btnReturn = findViewById<Button>(R.id.btnReturn)
        btnReturn.setOnClickListener{
            var outIntent = Intent(applicationContext, MainActivity::class.java)
            outIntent.putExtra("Hap", hapValue)
            setResult(Activity.RESULT_OK, outIntent)
            finish()
        }
    }
}