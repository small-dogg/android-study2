package com.smalldogg.study.androidstudy2

import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Video
import com.smalldogg.study.androidstudy2.databinding.ActivityRawFileLoaderBinding
import java.io.BufferedReader
import java.io.InputStreamReader

class RawFileLoader : AppCompatActivity() {

    var mp:MediaPlayer? = null

    lateinit var binding : ActivityRawFileLoaderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRawFileLoaderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button12.setOnClickListener {
            val inputStream = resources.openRawResource(R.raw.data1)
            val isr = InputStreamReader(inputStream, "UTF-8")
            val br = BufferedReader(isr)

            var str: String? = null
            val sb = StringBuffer()
            do {
                str = br.readLine()
                if (str != null) {
                    sb.append("$str\n")
                }
            }while(str != null)

            br.close()

            binding.textView7.text = sb.toString()
        }

        binding.button13.setOnClickListener {
            if(mp == null) {
                mp = MediaPlayer.create(this, R.raw.sample)
                mp?.start()
            }
        }
        binding.button14.setOnClickListener {
            if (mp != null) {
                mp?.stop()
                mp = null
            }
        }
        binding.button15.setOnClickListener {
            if(!binding.videoView.isPlaying){
                val uri = Uri.parse("android.resource://${packageName}/raw/sample2")
                binding.videoView.setVideoURI(uri)
                binding.videoView.start()
            }
        }

        binding.button16.setOnClickListener {
            if(binding.videoView.isPlaying){
                binding.videoView.stopPlayback()
            }
        }
    }
}