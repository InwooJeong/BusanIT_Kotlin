package com.cookandroid.project11_2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*

class MainActivity : AppCompatActivity() {
    lateinit var toastText : TextView
    lateinit var toastView : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title="갤러리 영화 포스터"

        var gallery = findViewById<Gallery>(R.id.gallery1)
        var galAdapter = MyGalleryAdapter(this)
        gallery.adapter = galAdapter
    }

    inner class MyGalleryAdapter(var context: Context) : BaseAdapter(){
        var posterID = arrayOf(
            R.drawable.mov11, R.drawable.mov12, R.drawable.mov13, R.drawable.mov14,
            R.drawable.mov15, R.drawable.mov16, R.drawable.mov17, R.drawable.mov18,
            R.drawable.mov19, R.drawable.mov20
        )

        var movieName = arrayOf(
            "여인의 향기", "쥬리기 공원", "포레스트 검프", "사랑의 블랙홀", "혹성탈출 : 진화의 시작",
            "아름다운 비행", "내 이름은 칸", "해리포터 : 죽음의 성물2", "마더", "킹콩을 들다"
        )

        override fun getCount(): Int {
            return posterID.size
        }

        override fun getItem(position: Int): Any {
            return 0
        }

        override fun getItemId(position: Int): Long {
            return 0
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var imageview = ImageView(context)
            imageview.layoutParams = Gallery.LayoutParams(200,300)
            imageview.scaleType = ImageView.ScaleType.FIT_CENTER
            imageview.setPadding(5, 5, 5, 5)
            imageview.setImageResource(posterID[position])

            imageview.setOnTouchListener{ v, event ->
                var ivPoster = findViewById<ImageView>(R.id.ivPoster)
                ivPoster.scaleType = ImageView.ScaleType.FIT_CENTER
                ivPoster.setImageResource(posterID[position])
                //Toast.makeText(applicationContext, "토스트", Toast.LENGTH_SHORT).show()

                var toast = Toast(this@MainActivity)
                toastView = View.inflate(this@MainActivity, R.layout.toast1,null)
                toastText = toastView.findViewById<TextView>(R.id.toastText1)
                toastText.text = movieName[position]
                toast.view = toastView
                toast.show()

                false
            }

            return imageview
        }

    }
}