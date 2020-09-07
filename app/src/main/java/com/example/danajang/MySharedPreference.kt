package com.example.danajang

import android.content.Context
import org.json.JSONArray
import org.json.JSONException
import java.lang.reflect.Array.get
import java.nio.file.Paths.get

class MySharedPreference(context : Context) {
    //SharedPreference 데이터 저장하는곳
    val SETTING_PLAYER = "setting player"
    val PREFS_FILENAME = "prefs"
    val PREF_KEY_MY_EDIT = "myEditText"
    private var count = 0

    //프래그먼트에서 이미지를 불러올때 사용하는 카운트 가져오기
    fun getCount(): Int {
        return count
    }
    //카운트 저장하기
    fun setCount(): Unit? {
        count = 0
        return null
    }
    fun plusCount() : Unit?{
        count += 2
        return null
    }
    companion object{
        var voca_name : String = ""
    }
    val context = context
    fun setString(key: String, value: String){
        //값 저장하는 함수
        val editor = context.getSharedPreferences(PREFS_FILENAME, Context.MODE_PRIVATE).edit()
        editor.putString(key, value)
        editor.apply()
    }
    fun getString(key: String) : String?{
        //값 가져오는 함수
        val prefs = context.getSharedPreferences(PREFS_FILENAME, Context.MODE_PRIVATE)
        return prefs.getString(key, "")
    }
    fun deleteArrayList(key: String){
        val editor = context.getSharedPreferences(PREFS_FILENAME, Context.MODE_PRIVATE).edit()

        editor.remove(key)

        editor.commit()
    }
    fun setArrayList(key: String, values : ArrayList<String>) {
        //리스트를 저장하는 함수, 단어장을 저장할때 쓰일듯
        //저장할때 단어 사진 먼저 넣고, 정답 사진 두번째로 넣기
        val editor = context.getSharedPreferences(PREFS_FILENAME, Context.MODE_PRIVATE).edit()
        val a =  JSONArray()

        for(i in 0 until values.size step 1)
            a.put(values[i])
        if(values.isNotEmpty())
            editor.putString(key, a.toString())
         else
            editor.putString(key, null)

        editor.apply()
    }
    fun addArratList(key: String,value: String){
        val editor = context.getSharedPreferences(PREFS_FILENAME, Context.MODE_PRIVATE).edit()
        var a = ArrayList<String>()
        a = getArrayList(key)

        a.add(value)

        deleteArrayList(key)
        setArrayList(key,a)
    }
    fun getArrayList(key: String) : ArrayList<String> {
        ////리스트를 불러오는 함수, 단어장을 저장할때 쓰일듯
        val prefs = context.getSharedPreferences(PREFS_FILENAME, Context.MODE_PRIVATE)
        val json = prefs.getString(key,null)
        var urls = ArrayList<String>()
        if(json != null){
            try{
                val a = JSONArray(json)
                for(i in 0 until a.length() step 1){
                    var url = a.optString(i)
                    urls.add(url)
                }
            } catch (e: JSONException){
                e.printStackTrace()
            }
        }
        return urls
    }
    //틀린걸 저장하는 메서드를 만들기




}