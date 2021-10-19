package com.cookandroid.project4_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    /*lateinit var text1 : TextView
    lateinit var text2 : TextView
    lateinit var chkAgree : CheckBox
    lateinit var rGroup1 : RadioGroup
    lateinit var rdoDog : RadioButton
    lateinit var rdoCat : RadioButton
    lateinit var rdoRabbit : RadioButton
    lateinit var btnOK : Button
    lateinit var imgPet : ImageView*/

    lateinit var text1 : TextView
    lateinit var swcAgr : Switch
    lateinit var text2 : TextView
    lateinit var rGroup : RadioGroup
    lateinit var api80 : RadioButton
    lateinit var api90 : RadioButton
    lateinit var q10 : RadioButton
    lateinit var imgAnd : ImageView
    lateinit var btnExit : Button
    lateinit var btnReset : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*title = "애완동물 사진 보기"

        text1 = findViewById<TextView>(R.id.Text1)
        chkAgree = findViewById<CheckBox>(R.id.ChkAgree)

        text2 = findViewById<TextView>(R.id.Text2)
        rGroup1 = findViewById<RadioGroup>(R.id.Rgroup1)
        rdoDog = findViewById<RadioButton>(R.id.RdoDog)
        rdoCat = findViewById<RadioButton>(R.id.RdoCat)
        rdoRabbit = findViewById<RadioButton>(R.id.RdoRabbit)

        btnOK = findViewById<Button>(R.id.BtnOK)
        imgPet = findViewById<ImageView>(R.id.ImgPet)

        chkAgree.setOnCheckedChangeListener{ compoundButton, b->

            if(chkAgree.isChecked == true){
                text2.visibility = android.view.View.VISIBLE
                rGroup1.visibility = android.view.View.VISIBLE
                btnOK.visibility = android.view.View.VISIBLE
                imgPet.visibility = android.view.View.VISIBLE
            }else{
                text2.visibility = android.view.View.INVISIBLE
                rGroup1.visibility = android.view.View.INVISIBLE
                btnOK.visibility = android.view.View.INVISIBLE
                imgPet.visibility = android.view.View.INVISIBLE
            }
        }

        btnOK.setOnClickListener{
            when(rGroup1.checkedRadioButtonId){
                R.id.RdoDog -> imgPet.setImageResource(R.drawable.dog2)
                R.id.RdoCat -> imgPet.setImageResource(R.drawable.cat)
                R.id.RdoRabbit -> imgPet.setImageResource(R.drawable.rabbit)
                else -> Toast.makeText(applicationContext,
                    "동물을 먼저 선택하세요", Toast.LENGTH_SHORT).show()
            }
        }*/

        title = "안드로이드 사진 소기"

        text1 = findViewById<TextView>(R.id.Text1)
        swcAgr = findViewById<Switch>(R.id.SwcAgr)
        text2 = findViewById<TextView>(R.id.Text2)
        rGroup = findViewById<RadioGroup>(R.id.Rgroup)
        api80 = findViewById<RadioButton>(R.id.Api80)
        api90 = findViewById<RadioButton>(R.id.Api90)
        q10 = findViewById<RadioButton>(R.id.Q10)
        imgAnd = findViewById<ImageView>(R.id.ImgAnd)
        btnExit = findViewById<Button>(R.id.BtnExit)
        btnReset = findViewById<Button>(R.id.BtnReset)

        swcAgr.setOnCheckedChangeListener{CompoundButton, onSwitch ->
            if(onSwitch){
                text2.visibility = android.view.View.VISIBLE
                rGroup.visibility = android.view.View.VISIBLE
                imgAnd.visibility = android.view.View.VISIBLE
                btnExit.visibility = android.view.View.VISIBLE
                btnReset.visibility = android.view.View.VISIBLE
            }else{
                text2.visibility = android.view.View.INVISIBLE
                rGroup.visibility = android.view.View.INVISIBLE
                imgAnd.visibility = android.view.View.INVISIBLE
                btnExit.visibility = android.view.View.INVISIBLE
                btnReset.visibility = android.view.View.INVISIBLE
            }
        }

        rGroup.setOnCheckedChangeListener{group, checkedId ->
            when(checkedId){
                R.id.Api80 -> imgAnd.setImageResource(R.drawable.api80)
                R.id.Api90 -> imgAnd.setImageResource(R.drawable.api90)
                R.id.Q10 -> imgAnd.setImageResource(R.drawable.q10)
                else -> imgAnd.setImageResource(0)
            }
        }

        btnExit.setOnClickListener{
            ActivityCompat.finishAffinity(this) //액티비티 종료
            System.exit(0) //프로세스 종료
        }

        btnReset.setOnClickListener{
            swcAgr.toggle()
            rGroup.clearCheck()
            //imgAnd.setImageResource(0)
        }

    }
}