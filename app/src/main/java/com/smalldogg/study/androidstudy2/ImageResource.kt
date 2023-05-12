package com.smalldogg.study.androidstudy2

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.smalldogg.study.androidstudy2.databinding.ActivityImageResourceBinding

class ImageResource : AppCompatActivity() {
    lateinit var b : ActivityImageResourceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        b = ActivityImageResourceBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(b.root)

        b.imageView5.setImageResource(R.drawable.a)

        //Bitmap : JPG, PNG, GIF 파일로 부터 읽어온 이미지 데이터를 관리한다
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.img_android)
        b.imageView6.setImageBitmap(bitmap)

        // Drawable : Bitmap을 포함한 다양한 타입으로부터 이미지 데이터를 관리
        val drawable = getDrawable(R.drawable.img_android)
        b.imageView7.setImageDrawable(drawable)

        // 배경 타일 이미지 생성
        val drawable2 = getDrawable(R.drawable.tile)
        b.container.background = drawable2

        // Layer 이미지를 사용한다.
        val drawable3 = getDrawable(R.drawable.layer)
        b.imageView7.setImageDrawable(drawable3)

        //상태 이미지를 사용한다.
        val drawable4 = getDrawable(R.drawable.btn_image)
        b.button39.background = drawable4
    }
}