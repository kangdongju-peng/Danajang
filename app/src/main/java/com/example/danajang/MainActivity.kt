package com.example.danajang

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        App.prefs.setCount()
        val example_list = ArrayList<String>()
        val sp = MySharedPreference(this )
        val WORLD_COUNT = "world count"
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        example_list.add(0,"https://post-phinf.pstatic.net/MjAxODA3MzBfMjQy/MDAxNTMyOTQ4MTE5OTc4.vQckKXEt98Iab9s2BT7bWgTEQgqIMbc_3k0J1oy81XQg.uleHZMiWAlNNeB6C_QV2RB40s5_2DNr1pseOqLnC6bgg.JPEG/%EB%8B%AD.jpg?type=w1200")
        example_list.add(1,"https://post-phinf.pstatic.net/MjAxODA3MzBfMjQy/MDAxNTMyOTQ4MTE5OTc4.vQckKXEt98Iab9s2BT7bWgTEQgqIMbc_3k0J1oy81XQg.uleHZMiWAlNNeB6C_QV2RB40s5_2DNr1pseOqLnC6bgg.JPEG/%EB%8B%AD.jpg?type=w1200")
        App.prefs.setArrayList(MySharedPreference.voca_name,example_list)
        textView2.text = sp.getString(WORLD_COUNT)
        button_studyactivity.setOnClickListener {
            val intent = Intent(this,StudyActivity::class.java)
            startActivity(intent)
        }
        button_addactivity.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }

    }
}
