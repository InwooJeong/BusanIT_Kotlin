package com.cookandroid.ch10

import android.app.Activity
import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
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

       /* title="메인 액티비티"

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
        }*/

        title = "암시적 인텐트 예제"

        var btnDial = findViewById<Button>(R.id.btnDial)
        var btnWeb = findViewById<Button>(R.id.btnWeb)
        var btnGoogle = findViewById<Button>(R.id.btnGoogle)
        var btnSearch = findViewById<Button>(R.id.btnSearch)
        var btnSms = findViewById<Button>(R.id.btnSms)
        var btnPhoto = findViewById<Button>(R.id.btnPhoto)

        btnDial.setOnClickListener{
            var uri = Uri.parse("tel:010-1234-5678")
            var intent = Intent(Intent.ACTION_DIAL, uri)
            startActivity(intent)
        }

        btnWeb.setOnClickListener{
            var uri = Uri.parse("https://www.instagram.com/musikvonlotte/")
            var intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        btnGoogle.setOnClickListener{
            var uri = Uri.parse("https://maps.google.com/maps?q="+37.559133+","+126.927824)
            var intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        btnSearch.setOnClickListener{
            var intent = Intent(Intent.ACTION_WEB_SEARCH)
            intent.putExtra(SearchManager.QUERY, "Mehr davon")
            startActivity(intent)
        }

        btnSms.setOnClickListener{
            var intent = Intent(Intent.ACTION_SENDTO)
            intent.putExtra("sms_body", "안녕하세요?")
            intent.data = Uri.parse("smsto:"+Uri.encode("010-1234-5678"))
            startActivity(intent)
        }

        btnPhoto.setOnClickListener{
            var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }

    }

    /*override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK){
            var hap = data!!.getIntExtra("Hap",0)
            Toast.makeText(applicationContext, "결과 : $hap", Toast.LENGTH_SHORT).show()
        }
    }*/
}