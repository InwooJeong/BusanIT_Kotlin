package com.cookandroid.ch13

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mPlayer : MediaPlayer
        mPlayer = MediaPlayer.create(this, R.raw.song1)


    }
}