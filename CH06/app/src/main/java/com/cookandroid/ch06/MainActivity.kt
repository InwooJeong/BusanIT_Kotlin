package com.cookandroid.ch06

import androidx.appcompat.app.ActionBar
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

@Suppress("deprecation")
class MainActivity : AppCompatActivity(), ActionBar.TabListener {
//class MainActivity : AppCompatActivity() {
//class MainActivity : TabActivity() {

    lateinit var tabSong : ActionBar.Tab
    lateinit var tabArtist : ActionBar.Tab
    lateinit var tabAlbum : ActionBar.Tab

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*setContentView(R.layout.activity_main)
        title="자동완성"
        var items = arrayOf("CSI-뉴욕", "CSI-라스베가스", "CSI-마이애미",
                            "Friends", "Fringe", "Lost")

        var auto = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView1)
        var adapter = ArrayAdapter(this,
                    android.R.layout.simple_dropdown_item_1line, items)
        auto.setAdapter(adapter)

        var multi = findViewById<MultiAutoCompleteTextView>(R.id.multiAutoCompleteTextView1)
        var token = MultiAutoCompleteTextView.CommaTokenizer()
        multi.setTokenizer(token)
        multi.setAdapter(adapter)*/

        /*setContentView(R.layout.ch06_15)
        title="뷰 플리퍼"
        var btnPrev : Button
        var btnNext : Button
        var vFlipper : ViewFlipper

        btnPrev = findViewById<Button>(R.id.btnPrev)
        btnNext = findViewById<Button>(R.id.btnNext)
        vFlipper = findViewById<ViewFlipper>(R.id.viewFlipper1)

        btnPrev.setOnClickListener{
            vFlipper.showPrevious()
        }

        btnNext.setOnClickListener{
            vFlipper.showNext()
        }*/
        
        /*setContentView(R.layout.ch06_17)
        title="탭 호스트"

        var tabHost = this.tabHost

        var tabSpecSong = tabHost.newTabSpec("SONG").setIndicator("음악별")
        tabSpecSong.setContent(R.id.tabSong)
        tabHost.addTab(tabSpecSong)

        var tabSpecArtist = tabHost.newTabSpec("ARTIST").setIndicator("가수별")
        tabSpecArtist.setContent(R.id.tabArtist)
        tabHost.addTab(tabSpecArtist)

        var tabSpecAlbum = tabHost.newTabSpec("ALBUM").setIndicator("앨범별")
        tabSpecAlbum.setContent(R.id.tabAlbum)
        tabHost.addTab(tabSpecAlbum)

        tabHost.currentTab = 0*/

        //setContentView(R.layout.ch06_14)

        title = "액션바와 프레그먼트"
        var bar = this.supportActionBar
        bar!!.navigationMode = ActionBar.NAVIGATION_MODE_TABS

        tabSong = bar.newTab()
        tabSong.text = "음악별"
        tabSong.setTabListener(this)
        bar.addTab(tabSong)

        tabArtist = bar.newTab()
        tabArtist.text = "가수별"
        tabSong.setTabListener(this)
        bar.addTab(tabArtist)

        tabAlbum = bar.newTab()
        tabAlbum.text = "앨범별"
        tabAlbum.setTabListener(this)
        bar.addTab(tabAlbum)

    }

    class MyTabFragment : Fragment(){
        var tabName : String? = null
        override fun onCreate(savedInstanceState: Bundle?){
            super.onCreate(savedInstanceState)
            var data = arguments
            tabName = data!!.getString("tabName")
        }

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            var params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT)

            var baseLayout = LinearLayout(super.getActivity())
            baseLayout.orientation = LinearLayout.VERTICAL
            baseLayout.layoutParams = params

            if(tabName === "음악별") baseLayout.setBackgroundColor(Color.RED)
            if(tabName === "가수별") baseLayout.setBackgroundColor(Color.GREEN)
            if(tabName === "앨범별") baseLayout.setBackgroundColor(Color.BLUE)

            return baseLayout
        }
    }

    var myFrags = arrayOfNulls<MyTabFragment>(3)

    override fun onTabSelected(tab: ActionBar.Tab, ft: FragmentTransaction) {
        var myTabFrag : MyTabFragment? = null

        if(myFrags[tab.position]==null){
            myTabFrag = MyTabFragment()
            val data = Bundle()
            data.putString("tabName", tab.text.toString())
            myTabFrag.arguments = data
            myFrags[tab.position] = myTabFrag
        }else{
            myTabFrag = myFrags[tab.position]
        }
        ft.replace(android.R.id.content, myTabFrag!!)
    }

    override fun onTabUnselected(tab: ActionBar.Tab, ft: FragmentTransaction) {  }

    override fun onTabReselected(tab: ActionBar.Tab, ft: FragmentTransaction) {  }
}
