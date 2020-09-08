package com.example.danajang

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.noButton
import org.jetbrains.anko.toast
import org.jetbrains.anko.yesButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        App.prefs.setCount()
        val example_list = ArrayList<String>()
        val sp = MySharedPreference(this )
        val WORLD_COUNT = "world count"

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        example_list.add(0,"yoyo")
        App.prefs.setArrayList(MySharedPreference.voca_name,example_list)
        textView2.text = sp.getString(WORLD_COUNT)
        button_studyactivity.setOnClickListener {
            val intent = Intent(this,StudyActivity::class.java)
            startActivity(intent)
    }
        button_addactivity.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }
        //핸드폰 사진 사용권한이 있는지 체
        /*if(ContextCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            // 권한이 없다면
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.READ_EXTERNAL_STORAGE)){
                //권한이 거부되었을때
                alert("사진 정보를 얻으려면 이걸해야해요.. 알겠지요? 좀 하세요"){
                    yesButton {
                        ActivityCompat.requestPermissions(this@MainActivity, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),REQUEST_READ_EXTERNAL_STORAGE)
                    }
                    noButton {  }

                }.show()

            }else{
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE))
            }
        }else{
            getAllPhotos()
        }


    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            REQUEST_READ_EXTERNAL_STORAGE -> {
                if((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)){
                    getAllPhotos()
                } else{
                    toast("권한 거부됨")
                }
                return
            }
        }*/
    }





    private fun getAllPhotos(){
        val cursor = contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,null,null,null,MediaStore.Images.ImageColumns.DATE_TAKEN + "DESC")
    }

}
