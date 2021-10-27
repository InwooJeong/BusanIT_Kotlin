package com.cookandroid.project11_2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.BaseAdapter
import android.widget.Gallery

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title="갤러리 영화 포스터"

        var gallery = findViewById<Gallery>(R.id.gallery1)
        var galAdapter = MyGalleryAdapter(this)
        gallery.adapter = galAdapter
    }

    inner class MyGalleryAdapter(var context: Context) : BaseAdapter(){
        var PosterID = arrayOf(
            
        )
    }
}