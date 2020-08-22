package com.example.danajang

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val sp = SharedPreference(this )
        val WORLD_COUNT = "world count"
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
