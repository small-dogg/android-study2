package com.smalldogg.study.androidstudy2

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DBHelper : SQLiteOpenHelper {
    constructor(context: Context) : super(context, "Test.db", null, 2)

    //데이터베이스 파일이 없을 경우 파일이 만들어지고 자동으로 호출됨
    //어플리케이션 설치 후 최초 접근 시 호출
    //최신 형태의 테이블 생성하는 쿼리문을 작성
    override fun onCreate(db: SQLiteDatabase?) {
        Log.d("test", "데이터베이스가 생성되었습니다.")

        val sql = """
            create table TestTable
                (idx integer primary key autoincrement,
                textData text not null,
                intData integer not null,
                floatData real not null,
                dateData date not null)
        """.trimIndent()

        db?.execSQL(sql)
    }

    //버전이 변경될 경우 호출
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        Log.d("test", "데이터베이스가 업데이트 되었습니다.${oldVersion} ${newVersion}")
        when (oldVersion) {
            1 -> {
                //1에서 2로 변경되었을 때
            }
            2 -> {
                //2에서 3으로 변경되었을 때
            }
        }
    }
}