package com.smalldogg.study.androidstudy2

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.net.Uri

class TestProvider : ContentProvider() {

    var db : SQLiteDatabase? = null

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        val cnt = db?.delete("TestTable", selection, selectionArgs)
        return cnt!!
    }

    //열의 데이터 타입을 MIME 타입 형태로 반환하는 메서드
    //알려줄 필요가없다면 Null을 반환
    override fun getType(uri: Uri): String? {
        return null
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        db?.insert("TestTable", null, values)
        return uri
    }

    //Content Provider 객체가 생성되면 자동으로 호출되는 메서드
    //데이터베이스에 접근할 수 있는 객체를 생성하고
    //접속을 성공하면 T 실패하면 F를반환
    override fun onCreate(): Boolean {
        db = DBHelper(context!!).writableDatabase

        if (db == null) {
            return false
        }
        return true
    }

    //select
    //uri : 프로바이더 요청시 사용한 URI 값
    //projection : 가져올 컬럼 이름 목록 , null이면 모든 컬럼 가져옴
    //selection : 조건절, null이면 조건이 없음
    //selectionArgs : 조건절의 ?에 바인될 값 배열
    //sortOrder : 정렬 기준이 되는 컬럼
    override fun query(
        uri: Uri, projection: Array<String>?, selection: String?,
        selectionArgs: Array<String>?, sortOrder: String?
    ): Cursor? {
        val c1 = db?.query("TestTable",projection,selection,selectionArgs, null, null, sortOrder)
        return c1
    }

    override fun update(
        uri: Uri, values: ContentValues?, selection: String?,
        selectionArgs: Array<String>?
    ): Int {
        val cnt = db?.update("TestTable", values, selection, selectionArgs)
        return cnt!!
    }
}