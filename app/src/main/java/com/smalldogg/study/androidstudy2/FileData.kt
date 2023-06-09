package com.smalldogg.study.androidstudy2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.smalldogg.study.androidstudy2.databinding.ActivityFileDataBinding
import java.io.DataInputStream
import java.io.DataOutputStream
import java.io.FileInputStream
import java.io.FileOutputStream

class FileData : AppCompatActivity() {

    //내부 저장소의 앱 데이터 디렉토리 경로
    lateinit var file_path: String

    private lateinit var binding: ActivityFileDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityFileDataBinding.inflate(layoutInflater)
        val view = binding.root
        super.onCreate(savedInstanceState)
        setContentView(view)

        //null을 셋팅하면 앱 데이터 폴더의 경로를 얻어오고
        //Environment.DIRECTORY_종류를 넣어주면 해당 경로를 얻어온다.
//        file_path = getExternalFilesDir(Environment.DIRECTORY_?).toString()
        file_path = getExternalFilesDir(null).toString()
        Log.d("test", file_path)

        binding.button6.setOnClickListener {
            // MODE_PRIVATE : 덮어쓰기
            // MODE_APPEND : 이어쓰기
            val fos = openFileOutput("data1.dat", Context.MODE_PRIVATE)
            val dos = DataOutputStream(fos)
            //데이터 쓰기
            dos.writeInt(100)
            dos.writeDouble(11.11)
            dos.writeBoolean(true)
            dos.writeUTF("문자열1")

            dos.flush()
            dos.close()

            binding.textView6.text = "내부 저장소 쓰기 완료"
        }

        binding.button7.setOnClickListener {
            val fis = openFileInput("data1.dat")
            val dis = DataInputStream(fis)

            val data1 = dis.readInt()
            val data2 = dis.readDouble()
            val data3 = dis.readBoolean()
            val data4 = dis.readUTF()

            dis.close()

            binding.textView6.text = "data1 : $data1\n"
            binding.textView6.append("data2 : $data2\n")
            binding.textView6.append("data3 : $data3\n")
            binding.textView6.append("data4 : $data4\n")
        }

        binding.button8.setOnClickListener {
            val fos = FileOutputStream("$file_path/data2.dat")
            val dos = DataOutputStream(fos)

            dos.writeInt(200)
            dos.writeDouble(22.22)
            dos.writeBoolean(false)
            dos.writeUTF("문자열2")

            dos.flush()
            dos.close()
            binding.textView6.text = "외부 저장소의 앱 데이터 폴더에 저장"
        }

        binding.button9.setOnClickListener {
            val fis = FileInputStream("$file_path/data2.dat")
            val dis = DataInputStream(fis)

            val data1 = dis.readInt()
            val data2 = dis.readDouble()
            val data3 = dis.readBoolean()
            val data4 = dis.readUTF()

            dis.close()

            binding.textView6.text = "data1 : $data1\n"
            binding.textView6.append("data2 : $data2\n")
            binding.textView6.append("data3 : $data3\n")
            binding.textView6.append("data4 : $data4\n")
        }

        binding.button10.setOnClickListener {
            //파일 관리 앱의 액티비티를 실행한다.
            val fileIntent = Intent(Intent.ACTION_CREATE_DOCUMENT)
            fileIntent.addCategory(Intent.CATEGORY_OPENABLE)
            fileIntent.type = "*/*"
            startActivityForResult(fileIntent, 100)
        }

        binding.button11.setOnClickListener {
            //파일 관리 앱의 액티비티를 실행한다.
            val fileIntent = Intent(Intent.ACTION_OPEN_DOCUMENT)
            fileIntent.type = "*/*"
            startActivityForResult(fileIntent, 200)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 100) {
            if (resultCode == RESULT_OK) {
                val des1 = contentResolver.openFileDescriptor(data?.data!!, "w")
                val fos = FileOutputStream(des1?.fileDescriptor)
                val dos = DataOutputStream(fos)
                dos.writeInt(300)
                dos.writeDouble(33.33)
                dos.writeBoolean(true)
                dos.writeUTF("문자열3")

                dos.flush()
                dos.close()
                binding.textView6.text = "Downloads 폴더에 저장"
            }
        } else if (requestCode == 200) {
            if (resultCode == RESULT_OK) {
                val des2 = contentResolver.openFileDescriptor(data?.data!!, "r")
                val fis = FileInputStream(des2?.fileDescriptor)
                val dis = DataInputStream(fis)

                val data1 = dis.readInt()
                val data2 = dis.readDouble()
                val data3 = dis.readBoolean()
                val data4 = dis.readUTF()

                dis.close()

                binding.textView6.text = "data1 : $data1\n"
                binding.textView6.append("data2 : $data2\n")
                binding.textView6.append("data3 : $data3\n")
                binding.textView6.append("data4 : $data4\n")
            }
        }
    }
}