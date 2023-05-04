package com.smalldogg.study.androidstudy2

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.smalldogg.study.androidstudy2.databinding.ActivitySqliteDatabase2Binding
import java.text.SimpleDateFormat
import java.util.*

class SQLiteDatabase2 : AppCompatActivity() {
    lateinit var b : ActivitySqliteDatabase2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        b = ActivitySqliteDatabase2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(b.root)

        b.button24.setOnClickListener {
            val helper = DBHelper(this)

            val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val now = sdf.format(Date())

            val cv1 = ContentValues()
            cv1.put("textData", "문자열1")
            cv1.put("intData", 11)
            cv1.put("floatData", 11.11)
            cv1.put("dateData", now)

            helper.writableDatabase.insert("TestTable", null, cv1)

            helper.writableDatabase.close()

        }


        b.button25.setOnClickListener {
            val helper = DBHelper(this)

            val c1 = helper.writableDatabase.query("TestTable", null, null, null, null, null, null)

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
                b.textView10.append("idx : $idx\n")
                b.textView10.append("textData : $textData\n")
                b.textView10.append("intData : $intData\n")
                b.textView10.append("floatData : $floatData\n")
                b.textView10.append("dateData : $dateData\n")
            }
            helper.writableDatabase.close()

        }
        b.button26.setOnClickListener {
            val helper = DBHelper(this)

            val cv1 = ContentValues()
            cv1.put("textData", "문자열3")

            val where = "idx = ?"
            val args = arrayOf("1")

            helper.writableDatabase.update("TestTable",cv1, where, args)

            helper.writableDatabase.close()

        }
        b.button27.setOnClickListener {
            val helper = DBHelper(this)

            val where = "idx = ?"
            val args = arrayOf("1")

            helper.writableDatabase.delete("TestTable",where, args)

            helper.writableDatabase.close()

        }
    }
}