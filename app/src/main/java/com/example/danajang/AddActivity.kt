package com.example.danajang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {
//사진으로 추가하는 엑티비티
    val WORLD_COUNT = "world count"
    //단어수
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        val sp = SharedPreference( this )
        finishbtn.setOnClickListener {
            sp.setString(WORLD_COUNT,editText_num.text.toString())
            //단어수를 저장
        }
    }
}
