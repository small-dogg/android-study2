package com.smalldogg.study.androidstudy2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.smalldogg.study.androidstudy2.databinding.ActivityPreferencesBinding

class Preferences : AppCompatActivity() {
    lateinit var b : ActivityPreferencesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        b = ActivityPreferencesBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(b.root)

        b.button32.setOnClickListener {
            val pref = getSharedPreferences("data", Context.MODE_PRIVATE)

            //데이터 저장을 위한 객체를 추출한다.
            val editor = pref.edit()

            editor.putBoolean("data1", true)
            editor.putFloat("data2", 11.11f)
            editor.putInt("data3", 1)
            editor.putLong("data4", 10000L)
            editor.putString("data5", "문자열 데이터")

            val set = HashSet<String>()
            set.add("문자열1")
            set.add("문자열2")
            set.add("문자열3")

            editor.putStringSet("data6",set)

            editor.commit()

            b.textView12.text = "저장완료"
        }

        b.button33.setOnClickListener {
            val pref = getSharedPreferences("data", Context.MODE_PRIVATE)

            //저장된 데이터를 가져온다.
            val data1 = pref.getBoolean("data1", false)
            val data2 = pref.getFloat("data2",0.0f)
            val data3 = pref.getInt("data3", 0)
            val data4 = pref.getLong("data4",0L)
            val data5 = pref.getString("data5", "초기값")
            val data6 = pref.getStringSet("data6", null)

            b.textView12.text = "data1 : $data1\n"
            b.textView12.append("data2 : $data2\n")
            b.textView12.append("data3 : $data3\n")
            b.textView12.append("data4 : $data4\n")
            b.textView12.append("data5 : $data5\n")

            for (str in data6!!) {
                b.textView12.append("data6  :$str\n")
            }
        }
    }
}