package com.smalldogg.study.androidstudy2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.smalldogg.study.androidstudy2.databinding.ActivityCpapp1Binding
import java.text.SimpleDateFormat
import java.util.*

class CPApp1 : AppCompatActivity() {
    lateinit var b : ActivityCpapp1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        b = ActivityCpapp1Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(b.root)

        b.button28.setOnClickListener {
            val helper = DBHelper(this)

            val sql = """
                insert into TestTable (textData, intData, floatData, dateData)
                values (?,?,?,?)
            """.trimIndent()

            // ? 에 바인딩 될 값
            val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val now = sdf.format(Date())

            val arg1 = arrayOf("문자열1", "100", "11.11", now)
            val arg2 = arrayOf("문자열2", "200", "22.22", now)

            //저장
            helper.writableDatabase.execSQL(sql, arg1)
            helper.writableDatabase.execSQL(sql, arg2)

            helper.writableDatabase.close()

            b.textView11.text = "저장 완료"
        }

        b.button29.setOnClickListener {
            val helper = DBHelper(this)

            val sql = """
                select * from testTable
            """.trimIndent()

            val c1 = helper.writableDatabase.rawQuery(sql, null)
            b.textView11.text = ""

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
                val intData = c1.getInt(idx3)
                val floatData = c1.getFloat(idx4)
                val dateData = c1.getString(idx5)
                b.textView11.append("idx : $idx\n")
                b.textView11.append("textData : $textData\n")
                b.textView11.append("intData : $intData\n")
                b.textView11.append("floatData : $floatData\n")
                b.textView11.append("dateData : $dateData\n")
            }

            helper.close()
        }
    }
}