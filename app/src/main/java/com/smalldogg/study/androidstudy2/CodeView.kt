package com.smalldogg.study.androidstudy2

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.smalldogg.study.androidstudy2.databinding.ActivityCodeViewBinding

class CodeView : AppCompatActivity() {

    private lateinit var binding: ActivityCodeViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCodeViewBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)

        val param1 = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.MATCH_PARENT,

            )

        val btn1 = Button(this)
        btn1.text = "추가된 버튼입니다."
        btn1.layoutParams = param1

        btn1.setOnClickListener {
            binding.textView3.text = "추가된 버튼을 눌렀습니다."
        }

        binding.button.setOnClickListener {
            binding.container2.addView(btn1)
        }

        binding.button3.setOnClickListener {
            binding.container2.removeView(btn1)
        }
    }
}