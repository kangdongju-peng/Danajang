package com.example.danajang

import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_1.*
import kotlinx.android.synthetic.main.fragment_1.view.*

class Page1Fragment : Fragment() {
    //프레그먼트1
    //val sp = SharedPreference( requireContext())
    val WORLD_COUNT = "world count"
    val FAULT_WORD = "faultwords"




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //good.visibility(View.INVISIBLE)

        val root = inflater.inflate(R.layout.fragment_1, container, false)
        val world_list : ArrayList<String>
        world_list =  App.prefs.getArrayList(context!!,MySharedPreference.voca_name) //단어 리스트를 가져오ㅁ
        //image = world_list[(getActivity() as LoadAdapter).getCount()]    <-- 이미지를 월드리스트에서 가져옴
        var uri = Uri.parse("file:///" + Environment.getExternalStorageDirectory() + world_list[App.prefs.getCount()])
        image_view.setImageURI(uri)
        done_btn.setOnClickListener {
            //done버튼이
            //good.setVisibility(View.VISIBLE)

        }
        delete_btn.setOnClickListener {
            //delete버튼이 눌렸을때 틀린걸 저장하기
            App.prefs.addArratList(context!!,FAULT_WORD,world_list[App.prefs.getCount()])

        }





        App.prefs.plusCount()
        return root
    }
    // 뷰 생성이 완료되면 호출되는 메소드
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


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