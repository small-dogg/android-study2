package com.smalldogg.study.androidstudy2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.smalldogg.study.androidstudy2.databinding.ActivitySqliteDatabase1Binding
import java.text.SimpleDateFormat
import java.util.*

class SQLiteDatabase1 : AppCompatActivity() {
    lateinit var binding : ActivitySqliteDatabase1Binding
    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivitySqliteDatabase1Binding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button20.setOnClickListener {
            val helper = DBHelper(this)

            val sql = """
                insert into TestTable (textData, intData, floatData, dateData)
                values (?,?,?,?)
            """.trimIndent()

            // ? 에 바인딩 될 값
            val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val now = sdf.format(Date())

            val arg1 = arrayOf("문자열1","100","11.11", now)
            val arg2 = arrayOf("문자열2","200","22.22", now)

            //저장
            helper.writableDatabase.execSQL(sql, arg1)
            helper.writableDatabase.execSQL(sql, arg2)

            helper.writableDatabase.close()

            binding.textView9.text = "저장 완료"
        }

        binding.button21.setOnClickListener {
            val helper = DBHelper(this)

            val sql = """
                select * from testTable
            """.trimIndent()

            val c1 = helper.writableDatabase.rawQuery(sql, null)
            binding.textView9.text = ""

            while (c1.moveToNext()) {
                // 가져올 컬럼의 인덱스 번호를 추출한다.
                val idx1 = c1.getColumnIndex("idx")
                val idx2 = c1.getColumnIndex("textData")
                val idx3 = c1.getColumnIndex("intData")
                val idx4 = c1.getColumnIndex("floatData")
                val idx5 = c1.getColumnIndex("dateData")

                //데이터를 추출한다.
                val idx = c1.getInt(idx1)
                val textData = c1.getString(idx2)
                val intData = c1.getInt(idx2)
                val floatData = c1.getFloat(idx2)
                val dateData = c1.getString(idx2)
                binding.textView9.append("idx : $idx\n")
                binding.textView9.append("textData : $textData\n")
                binding.textView9.append("intData : $intData\n")
                binding.textView9.append("floatData : $floatData\n")
                binding.textView9.append("dateData : $dateData\n")
            }

        }

        binding.button22.setOnClickListener {
            val helper = DBHelper(this)

            val sql = """
                update TestTable set textData = ? where idx = ?
            """.trimIndent()

            val arg1 = arrayOf("문자열3","1")
            helper.writableDatabase.execSQL(sql, arg1)
            helper.writableDatabase.close()
            binding.textView9.text = "수정 완료"
        }

        binding.button23.setOnClickListener {
            val helper = DBHelper(this)

            val sql = """
                delete from TestTable where idx = ?
            """.trimIndent()

            val arg1 = arrayOf("1")
            helper.writableDatabase.execSQL(sql, arg1)
            helper.writableDatabase.close()
            binding.textView9.text = "삭제 완료"
        }



    }
}