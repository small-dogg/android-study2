package com.smalldogg.study.androidstudy2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.smalldogg.study.androidstudy2.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button5.setOnClickListener {
            finish()
        }
    }
}