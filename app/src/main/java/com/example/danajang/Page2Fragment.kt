package com.example.danajang

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_1.*
import kotlinx.android.synthetic.main.fragment_1.view.*

class Page2Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_2, container, false)
        val world_list : ArrayList<String>
        world_list =  App.prefs.getArrayList(MySharedPreference.voca_name) //단어 리스트를 가져오ㅁ


        Log.d("**",App.prefs.getCount().toString())

        if(App.prefs.getCount() /2  <= world_list.size){
            var uri = Uri.parse(/*"file:///" + Environment.getExternalStorageDirectory() +*/ world_list[App.prefs.getCount()])
            root.image_view.setImageURI(uri)

        } else{
            Toast.makeText(activity,"단어장이 끝났습니다", Toast.LENGTH_SHORT).show()
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)

        }
        return root
    }
    // 뷰 생성이 완료되면 호출되는 메소드
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        App.prefs.plusCount()

    }
    companion object {
        private const val num = "num"
        @JvmStatic
        fun newInstance(Number: Int): Page2Fragment {
            return Page2Fragment().apply {
                arguments = Bundle().apply {
                    putInt(num, Number)
                }
            }
        }
    }
}