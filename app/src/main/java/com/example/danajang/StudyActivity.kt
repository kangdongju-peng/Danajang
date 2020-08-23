package com.example.danajang

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.PagerAdapter
import kotlinx.android.synthetic.main.activity_study.*

class StudyActivity: AppCompatActivity() {
    //단어 공부하는 프레그먼트 페이지

    val FRAGMENT_TAG = "FRAGMENT_TAG"
    val KEY_NUMBER = "KEY_NUMBER"
    var mNumber = 0
    val mListener = object: FragmentManager.OnBackStackChangedListener {
        override fun onBackStackChanged() {
            var fragmentManager = getSupportFragmentManager()
            var count = 0
            for (f in fragmentManager.getFragments()){
                if (f != null)
                    count++
            }
            mNumber = count
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_study)
        val sp = SharedPreference(this )
        val WORLD_COUNT = "world count"
        // 어댑터 생성 <어댑터는 여러 프래그먼트를 만들고 관리함>
        //val Adapter = PageAdapter(supportFragmentManager)
        // 뷰 페이저에 어댑터 연결
        //view_pager.adapter = Adapter
        //view_pager.currentItem=0
        // 탭 레아아웃에 뷰페이저 연결
        for(i in 1 until sp.getString(WORLD_COUNT)!!.toInt() step 1){
            var fragmentManager = getSupportFragmentManager()
            //fragmentManager.beginTransaction()
              //  .add(R.id.)
        }




    }
}