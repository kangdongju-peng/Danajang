package com.example.danajang

import android.content.Context

class SharedPreference(context : Context) {
    //SharedPreference 데이터 저장하는곳
    val SETTING_PLAYER = "setting player"
    val PREFS_FILENAME = "prefs"
    val PREF_KEY_MY_EDIT = "myEditText"
    val context = context
    fun setString(key: String, value: String){
        val editor = context.getSharedPreferences(PREFS_FILENAME, Context.MODE_PRIVATE).edit()
        editor.putString(key, value)
        editor.apply()
    }
    fun getString(key: String) : String?{
        val prefs = context.getSharedPreferences(PREFS_FILENAME, Context.MODE_PRIVATE)
        return prefs.getString(key, "")
    }
}