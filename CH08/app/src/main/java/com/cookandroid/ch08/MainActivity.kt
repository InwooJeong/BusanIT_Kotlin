package com.cookandroid.ch08

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnRead : Button = findViewById<Button>(R.id.btnRead)
        var btnWrite : Button = findViewById<Button>(R.id.btnWrite)

        btnWrite.setOnClickListener{
            var outFs : FileOutputStream =
                openFileOutput("file.text", Context.MODE_PRIVATE)
            var str = "쿡북 안드로이드"
            outFs.write(str.toByteArray())
            outFs.close()
            Toast.makeText(applicationContext,
                    "file.text가 생성됨", Toast.LENGTH_SHORT).show()
        }

        btnRead.setOnClickListener{
            try{
                var inFs : FileInputStream = openFileInput("file.text")
                var txt = ByteArray(30)
                inFs.read(txt)
                var str = txt.toString(Charsets.UTF_8)
                Toast.makeText(applicationContext, str, Toast.LENGTH_SHORT).show()
                inFs.close()
            }catch (e:IOException){
                Toast.makeText(applicationContext,
                    "파일 없음", Toast.LENGTH_SHORT).show()
            }
        }

    }
}