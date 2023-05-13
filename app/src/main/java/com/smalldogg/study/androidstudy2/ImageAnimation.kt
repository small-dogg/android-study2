package com.smalldogg.study.androidstudy2

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.smalldogg.study.androidstudy2.databinding.ActivityImageAnimationBinding

class ImageAnimation : AppCompatActivity() {
    lateinit var b : ActivityImageAnimationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        b = ActivityImageAnimationBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(b.root)

//        b.imageView8.setImageResource(R.drawable.ani_data)
        val drawable = getDrawable(R.drawable.ani_data)
//        b.imageView8.setImageDrawable(drawable)

        // 애니메이션 객체를 추출한다.
         val ani = drawable as AnimationDrawable

        b.button40.setOnClickListener {
            ani.start()
        }

        b.button41.setOnClickListener {
            ani.stop()
        }
    }
}