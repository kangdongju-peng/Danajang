package com.example.danajang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {
//사진으로 추가하는 엑티비티
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        finishbtn.setOnClickListener {
            val intent = Intent(this,PageAdapter::class.java)
            intent.putExtra("wordcount",editText_num.text.toString())
        }
    }
}
