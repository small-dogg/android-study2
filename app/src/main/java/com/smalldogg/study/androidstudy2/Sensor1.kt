package com.smalldogg.study.androidstudy2

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.smalldogg.study.androidstudy2.databinding.ActivitySensor1Binding

class Sensor1 : AppCompatActivity() {
    lateinit var b: ActivitySensor1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        b = ActivitySensor1Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(b.root)

        //단말기의 센서들을 관리하는 객체를 추출한다.
        val manager = getSystemService(SENSOR_SERVICE) as SensorManager

        //센서에서 값을 가져오면 반응하는 리스너
        val listener = object : SensorEventListener {
            //센서 측정값 변경 탐지
            override fun onSensorChanged(event: SensorEvent?) {
                //센서 타입에 따라 분기
                when (event?.sensor?.type) {
                    Sensor.TYPE_LIGHT -> b.textView20.text = "주변 밝기 : ${event?.values?.get(0)} lux"

                    Sensor.TYPE_PRESSURE -> b.textView20.text = "현재 기압 : ${event?.values?.get(0)} millibar"

                    Sensor.TYPE_PROXIMITY -> b.textView20.text = "물체와의 거리 : ${event?.values?.get(0)} cm"

                    Sensor.TYPE_GYROSCOPE -> {
                        b.textView20.text = "x축 각속도 : ${event?.values?.get(0)}"
                        b.textView20.text = "y축 각속도 : ${event?.values?.get(1)}"
                        b.textView20.text = "z축 각속도 : ${event?.values?.get(2)}"
                    }


                }
            }

            //센서 감도 변경 탐지
            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
                TODO("Not yet implemented")
            }
        }

        b.button47.setOnClickListener {
            //조도 센서 객체
            val sensor = manager.getDefaultSensor(Sensor.TYPE_LIGHT)
            //조도 센서와 리스너를 연결한다.
            val chk = manager.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_UI)

            if (!chk) {
                b.textView20.text = "조도 센서를 지원하지 않습니다."
            }
        }

        b.button48.setOnClickListener {
            manager.unregisterListener(listener)
        }


        b.button49.setOnClickListener {
            //조도 센서 객체
            val sensor = manager.getDefaultSensor(Sensor.TYPE_PRESSURE)
            //조도 센서와 리스너를 연결한다.
            val chk = manager.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_UI)

            if (!chk) {
                b.textView20.text = "기압 센서를 지원하지 않습니다."
            }
        }

        b.button50.setOnClickListener {
            manager.unregisterListener(listener)
        }

        b.button51.setOnClickListener {
            //조도 센서 객체
            val sensor = manager.getDefaultSensor(Sensor.TYPE_PROXIMITY)
            //조도 센서와 리스너를 연결한다.
            val chk = manager.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_UI)

            if (!chk) {
                b.textView20.text = "근접 센서를 지원하지 않습니다."
            }
        }

        b.button52.setOnClickListener {
            manager.unregisterListener(listener)
        }

        b.button53.setOnClickListener {
            //조도 센서 객체
            val sensor = manager.getDefaultSensor(Sensor.TYPE_PROXIMITY)
            //조도 센서와 리스너를 연결한다.
            val chk = manager.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_UI)

            if (!chk) {
                b.textView20.text = "근접 센서를 지원하지 않습니다."
            }
        }

        b.button54.setOnClickListener {
            manager.unregisterListener(listener)
        }

    }
}