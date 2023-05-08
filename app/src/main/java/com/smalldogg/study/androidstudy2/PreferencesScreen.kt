package com.smalldogg.study.androidstudy2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.smalldogg.study.androidstudy2.databinding.ActivityPreferencesScreenBinding

class PreferencesScreen : AppCompatActivity() {

    val settingFragment = SettingFragment()
    val resultFragment = ResultFragment()

    lateinit var b : ActivityPreferencesScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        b = ActivityPreferencesScreenBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(b.root)

        b.button30.setOnClickListener {
            val tran = supportFragmentManager.beginTransaction()
            tran.replace(R.id.container, settingFragment)
            tran.commit()
        }
        b.button31.setOnClickListener {
            val tran = supportFragmentManager.beginTransaction()
            tran.replace(R.id.container, resultFragment)
            tran.commit()
        }


    }
}