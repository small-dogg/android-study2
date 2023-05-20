package com.smalldogg.study.androidstudy2

import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.smalldogg.study.androidstudy2.databinding.ActivitySensorListBinding

class SensorList : AppCompatActivity() {
    lateinit var b : ActivitySensorListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        b = ActivitySensorListBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(b.root)

        //센서를 관리하는 매니저를 추출한다.
        val manager = getSystemService(SENSOR_SERVICE) as SensorManager

        //모든 센서 리스트 호출
        val sensor_list = manager.getSensorList(Sensor.TYPE_ALL)

        b.textView19.text=""
        for (sensor in sensor_list) {
            b.textView19.append("센서 이름 : ${sensor.name}\n")
            b.textView19.append("센서 이름 : ${sensor.type}\n")
        }
    }
}