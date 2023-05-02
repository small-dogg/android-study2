package com.smalldogg.study.androidstudy2

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.smalldogg.study.androidstudy2.databinding.ActivityAssetsBinding
import java.io.BufferedReader
import java.io.InputStreamReader

class Assets : AppCompatActivity() {
    lateinit var binding : ActivityAssetsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAssetsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button17.setOnClickListener {
            val inputStream = assets.open("text/data1.txt")
            val isr = InputStreamReader(inputStream, "UTF-8")
            val br = BufferedReader(isr)
            var str: String? = null
            val sb = StringBuffer()
            do{
                str = br.readLine()
                if (str != null) {
                    sb.append("$str\n")
                }
            }while(str!=null)

            br.close()
            binding.textView8.text = sb.toString()
        }
        binding.button18.setOnClickListener {
            val inputStream = assets.open("text/data2.txt")
            val isr = InputStreamReader(inputStream, "UTF-8")
            val br = BufferedReader(isr)
            var str: String? = null
            val sb = StringBuffer()
            do{
                str = br.readLine()
                if (str != null) {
                    sb.append("$str\n")
                }
            }while(str!=null)

            br.close()
            binding.textView8.text = sb.toString()
        }

        binding.button19.setOnClickListener {
            val face = Typeface.createFromAsset(assets, "font/NanumGothic-Bold.ttf")
            binding.textView8.typeface = face
        }
    }
}