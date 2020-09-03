package com.example.danajang

import android.os.Bundle
import android.os.Debug
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import kotlinx.android.synthetic.main.activity_study.*

class StudyActivity: AppCompatActivity() {
    //단어 공부하는 프레그먼트 페이지

    val FRAGMENT_TAG = "FRAGMENT_TAG"
    val KEY_NUMBER = "KEY_NUMBER"
    var mNumber = 0
    val COUNT = 3
    val mListener = object: FragmentManager.OnBackStackChangedListener {
        override fun onBackStackChanged() {
            Log.d("*****","OM")
            var fragmentManager = getSupportFragmentManager()
            var count = 0
            for (f in fragmentManager.getFragments()){
                Log.d("*****",count.toString())
                Log.d("*****",f.toString())
                if (f != null)
                    count++
            }
            mNumber = count
        }
    }
    val Adapter = PageAdapter(supportFragmentManager)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_study)
        val sp = SharedPreference(this )
        val WORLD_COUNT = "world count"
        // 어댑터 생성 <어댑터는 여러 프래그먼트를 만들고 관리함>
        val Adapter = PageAdapter(supportFragmentManager)
        // 뷰 페이저에 어댑터 연결
        view_pager.adapter = Adapter
        view_pager.currentItem = 1

        view_pager.addOnPageChangeListener(  object : ViewPager.SimpleOnPageChangeListener() {

            //override only methods you need, not all of them

            override fun onPageSelected(position: Int) {

                Log.d("******",position.toString() + "2222222")
                //무한스크롤
                if(position >= 4 ) {
                    view_pager.setCurrentItem(1,false)
                }
                if(position < 1){
                    view_pager.setCurrentItem(3,false)
                }
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
            }
        })

        }


    fun fragmentmethod(): Int{

        return 5
    }



    }
