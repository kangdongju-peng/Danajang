package com.example.danajang

import android.content.Context
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




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_1, container, false)
        val world_list : ArrayList<String>
        world_list = (getActivity() as SharedPreference).getArrayList(context!!,SharedPreference.voca_name) //단어 리스트를 가져오ㅁ 에러남
        //image = world_list[(getActivity() as LoadAdapter).getCount()]    <-- 이미지를 월드리스트에서 가져옴
        var uri = Uri.parse("file:///" + Environment.getExternalStorageDirectory() + world_list[(getActivity() as LoadAdapter).getCount()])
        image_view.setImageURI(uri)
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