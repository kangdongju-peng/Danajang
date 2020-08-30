package com.example.danajang

class LoadAdapter  {
    private var count = -1

    fun getCount(): Int {
        count ++
        return count
    }
    fun setCount(): Unit? {
        count = -1
        return null
    }
}