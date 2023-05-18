package com.smalldogg.study.androidstudy2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.smalldogg.study.androidstudy2.databinding.ActivityRotationBinding

class Rotation : AppCompatActivity() {
    lateinit var b : ActivityRotationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        b = ActivityRotationBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(b.root)

        if (savedInstanceState == null) {
            Log.d("test", "Activity가 처음 등장함.")
        } else {
            Log.d("test", "화면 회전이 발생함.")
            b.textView43.text = savedInstanceState.getString("data1")
        }

        b.button42.setOnClickListener {
            b.textView43.text = b.editTextTextPersonName.text
        }

        //화면 회전 발생시 호출되는 메서드

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString("data1",b.textView43.text.toString())
    }
}