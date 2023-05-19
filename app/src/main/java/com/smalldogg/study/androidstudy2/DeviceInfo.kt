package com.smalldogg.study.androidstudy2

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.Point
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.TelephonyManager
import android.view.WindowManager
import androidx.core.app.ActivityCompat
import com.smalldogg.study.androidstudy2.databinding.ActivityDeviceInfoBinding

class DeviceInfo : AppCompatActivity() {
    val permission_list = arrayOf(
        android.Manifest.permission.READ_PHONE_STATE,
        android.Manifest.permission.READ_SMS,
        android.Manifest.permission.READ_PHONE_NUMBERS
    )
    lateinit var b:ActivityDeviceInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        b = ActivityDeviceInfoBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(b.root)

        requestPermissions(permission_list, 0)

        b.button44.setOnClickListener {
            val manager = getSystemService(TELEPHONY_SERVICE) as TelephonyManager

            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.READ_SMS
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.READ_PHONE_NUMBERS
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.READ_PHONE_STATE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                b.textView18.text = "권한 적용 필요"
            }else {
                b.textView18.text = "전화번호 : ${manager.line1Number}"
                b.textView18.append("SIM 국가 코드 : ${manager.simCountryIso}")
                b.textView18.append("모바일 국가코드 + 모바일 네트워크 코드 : ${manager.simOperator}")
                b.textView18.append("서비스 이름 : ${manager.simOperatorName}")
                b.textView18.append("SIM 상태(통신가능 여부, PIN Lock 여부) : ${manager.simState}")
                b.textView18.append("음성 메일 번호 : ${manager.voiceMailNumber}")
            }
        }

        b.button45.setOnClickListener {
            b.textView18.text = ""
            b.textView18.append("소프트웨어를 커스터마이징한 회사 : ${Build.BRAND}")
            b.textView18.append("제조사 디자인명 : ${Build.DEVICE}")
            b.textView18.append("사용자에게 표시되는 빌드 ID : ${Build.DISPLAY}")
            b.textView18.append("빌드 고유 ID : ${Build.FINGERPRINT}")
            b.textView18.append("ChangeList 번호 : ${Build.ID}")
            b.textView18.append("제품/하드웨어 제조업체 : ${Build.MANUFACTURER}")
            b.textView18.append("제품 모델명 : ${Build.MODEL}")
            b.textView18.append("제품명 : ${Build.PRODUCT}")
            b.textView18.append("빌드 구분 : ${Build.TAGS}")
            b.textView18.append("빌드 타입 : ${Build.TYPE}")
            b.textView18.append("안드로이드 버전 : ${Build.VERSION.RELEASE}")
        }

        b.button46.setOnClickListener {
            val wm = getSystemService(WINDOW_SERVICE) as WindowManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                val matrix = wm.currentWindowMetrics

                val width = matrix.bounds.width()
                val height = matrix.bounds.height()

                b.textView18.text = "width : $width\n"
                b.textView18.append("height : $height\n")

            }else{
                val display = wm.defaultDisplay

                val point = Point()
                display.getSize(point)

                b.textView18.text = "width : ${point.x}\n"
                b.textView18.append("height : ${point.y}\n")
            }
        }


    }
}