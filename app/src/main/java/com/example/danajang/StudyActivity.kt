package com.example.danajang

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import kotlinx.android.synthetic.main.activity_study.*

class StudyActivity: AppCompatActivity() {
    //단어 공부하는 프레그먼트 페이지

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_study)
        // 어댑터 생성 <어댑터는 여러 프래그먼트를 만들고 관리함>
        val Adapter = PageAdapter(supportFragmentManager)
        // 뷰 페이저에 어댑터 연결
        view_pager.adapter = Adapter
        view_pager.currentItem=0
        // 탭 레아아웃에 뷰페이저 연결



    }
}