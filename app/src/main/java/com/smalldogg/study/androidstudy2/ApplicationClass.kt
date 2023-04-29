package com.smalldogg.study.androidstudy2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.smalldogg.study.androidstudy2.databinding.ActivityApplicationClassBinding

class ApplicationClass : AppCompatActivity() {
    private lateinit var binding: ActivityApplicationClassBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityApplicationClassBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)

        binding.button4.setOnClickListener {

            val app = application as AppClass
            app.method1()

            val secondIntent = Intent(this, SecondActivity::class.java)
            startActivity(secondIntent)
        }
    }
}