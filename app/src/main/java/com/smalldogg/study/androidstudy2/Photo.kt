package com.smalldogg.study.androidstudy2

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import com.smalldogg.study.androidstudy2.databinding.ActivityPhotoBinding
import java.io.File

class Photo : AppCompatActivity() {
    lateinit var contentUri: Uri
    lateinit var b: ActivityPhotoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        b = ActivityPhotoBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(b.root)

        val filePath = getExternalFilesDir(null).toString()

        b.button63.setOnClickListener {
            val intent1 = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent1, 1)
        }

        b.button64.setOnClickListener {
            val intent2 = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            //촬영한 사진이 저장될 파일이름
            val fileName = "/temp_${System.currentTimeMillis()}.jpg"
            val picPath = "$filePath/$fileName"

            val file = File(picPath)

            //사진이 저장될 위치를 관리하는 uri 객체
            contentUri = FileProvider.getUriForFile(
                this,
                "com.smalldogg.study.androidstudy2.camera.file_provider",
                file
            )

            intent2.putExtra(MediaStore.EXTRA_OUTPUT, contentUri)
            startActivityForResult(intent2, 2)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> {
                if (resultCode == RESULT_OK) {
                    b.imageView11.setImageBitmap(data?.getParcelableExtra("data"))
                }
            }

            2 -> {
                if (resultCode == RESULT_OK) {
                    b.imageView11.setImageBitmap(BitmapFactory.decodeFile(contentUri.path))

                    File(contentUri.path).delete()
                }
            }
        }
    }
}