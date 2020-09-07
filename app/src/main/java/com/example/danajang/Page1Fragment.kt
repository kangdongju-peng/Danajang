package com.example.danajang

import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_1.*
import kotlinx.android.synthetic.main.fragment_1.view.*
import java.net.URL

class Page1Fragment : Fragment() {
    //프레그먼트1
    //val sp = SharedPreference( requireContext())
    val WORLD_COUNT = "world count"
    val FAULT_WORD = "faultwords"




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_1, container, false)
        root.good.visibility= View.INVISIBLE
        val world_list : ArrayList<String>
        world_list =  App.prefs.getArrayList(MySharedPreference.voca_name) //단어 리스트를 가져오ㅁ
        //image = world_list[(getActivity() as LoadAdapter).getCount()]    <-- 이미지를 월드리스트에서 가져옴
        var uri = Uri.parse(/*"file:///" + Environment.getExternalStorageDirectory() +*/ world_list[App.prefs.getCount()])
        root.image_view.setImageURI(uri)

        root.done_btn.setOnClickListener {
            //done버튼이
            root.good.visibility = View.VISIBLE
        }
        root.delete_btn.setOnClickListener {
            //delete버튼이 눌렸을때 틀린걸 저장하기
            App.prefs.addArratList(FAULT_WORD,world_list[App.prefs.getCount()])
        }
        root.image_view.setOnClickListener {
            var uri = Uri.parse(/*"file:///" + Environment.getExternalStorageDirectory() +*/ world_list[App.prefs.getCount() + 1])
            root.image_view.setImageURI(uri)
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
        fun newInstance(Number: Int): Page1Fragment {
            return Page1Fragment().apply {
                arguments = Bundle().apply {
                    putInt(num, Number)
                }
            }
        }
    }
}