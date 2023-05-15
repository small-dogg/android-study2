package com.smalldogg.study.androidstudy2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.smalldogg.study.androidstudy2.databinding.ActivityLocalizationBinding

class Localization : AppCompatActivity() {
    lateinit var b: ActivityLocalizationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        b = ActivityLocalizationBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(b.root)

        b.textView86.text = getString(R.string.str4)

    }
}