package com.smalldogg.study.androidstudy2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.smalldogg.study.androidstudy2.databinding.ActivityXmlViewBinding
import com.smalldogg.study.androidstudy2.databinding.LayoutSub1Binding

class XmlViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityXmlViewBinding
    private lateinit var binding2: LayoutSub1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityXmlViewBinding.inflate(layoutInflater)
        binding2 = LayoutSub1Binding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)


        //View 객체를 생성한다.
        val sub1 = layoutInflater.inflate(R.layout.layout_sub1, null)

        sub1.run{
            binding.textView2.text = "sub1의 버튼을 눌렀습니다."
            binding2.sub1Text.text = "sub1의 버튼을 눌렀습니다."
        }

        binding.button1.setOnClickListener {
            binding.container1.addView(sub1)
        }

        binding.button2.setOnClickListener {
            binding.container1.removeView(sub1)
        }
    }
}