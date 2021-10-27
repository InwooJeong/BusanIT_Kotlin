package com.cookandroid.ch10

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*title="레이팅바"

        var rating1 : RatingBar
        var rating2 : RatingBar
        var rating3 : RatingBar
        var btnInc : Button
        var btnDec : Button

        rating1 = findViewById<RatingBar>(R.id.ratingBar1)
        rating2 = findViewById<RatingBar>(R.id.ratingBar2)
        rating3 = findViewById<RatingBar>(R.id.ratingBar3)
        btnInc = findViewById<Button>(R.id.btnInc)
        btnDec = findViewById<Button>(R.id.btnDec)

        btnInc.setOnClickListener{
            rating1.rating = rating1.rating + rating1.stepSize
            rating2.rating = rating2.rating + rating2.stepSize
            rating3.rating = rating3.rating + rating3.stepSize
        }

        btnDec.setOnClickListener{
            rating1.rating = rating1.rating - rating1.stepSize
            rating2.rating = rating2.rating - rating2.stepSize
            rating3.rating = rating3.rating - rating3.stepSize
        }*/

        title="메인 액티비티"

        var btnNewActivity = findViewById<Button>(R.id.btnNewActivity)
        var rGroup = findViewById<RadioGroup>(R.id.rGroup)

        btnNewActivity.setOnClickListener{
            var edtNum1 = findViewById<EditText>(R.id.edtNum1)
            var edtNum2 = findViewById<EditText>(R.id.edtNum2)
            var intent = Intent(applicationContext, SecondActivity::class.java)

            when(rGroup.checkedRadioButtonId){
                R.id.rAdd -> intent.putExtra("Calc","+")
                R.id.rSub -> intent.putExtra("Calc", "-")
                R.id.rMul -> intent.putExtra("Calc", "*")
                R.id.rDiv -> intent.putExtra("Calc", "/")
            }

            intent.putExtra("Num1", Integer.parseInt(edtNum1.text.toString()))
            intent.putExtra("Num2", Integer.parseInt(edtNum2.text.toString()))

            startActivityForResult(intent, 0)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK){
            var hap = data!!.getIntExtra("Hap",0)
            Toast.makeText(applicationContext, "결과 : $hap", Toast.LENGTH_SHORT).show()
        }
    }
}