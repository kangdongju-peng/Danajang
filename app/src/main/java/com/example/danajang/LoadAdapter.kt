package com.example.danajang

class LoadAdapter  {
    private var count = -1

    //프래그먼트에서 이미지를 불러올때 사용하는 카운트 가져오기
    public fun getCount(): Int {
        count ++
        return 5
    }
    //카운트 저장하기
    fun setCount(): Unit? {
        count = -1
        return null
    }
}