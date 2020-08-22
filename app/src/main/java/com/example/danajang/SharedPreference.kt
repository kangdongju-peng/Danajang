package com.example.danajang

import android.content.Context
import org.json.JSONArray
import org.json.JSONException
import java.lang.reflect.Array.get
import java.nio.file.Paths.get

class SharedPreference(context : Context) {
    //SharedPreference 데이터 저장하는곳
    val SETTING_PLAYER = "setting player"
    val PREFS_FILENAME = "prefs"
    val PREF_KEY_MY_EDIT = "myEditText"
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
    fun setArrayList(context: Context,key: String, values : ArrayList<String>) {
        //리스트를 저장하는 함수, 단어장을 저장할때 쓰일듯
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
    fun getArrayList(context: Context,key: String) : ArrayList<String> {
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
}