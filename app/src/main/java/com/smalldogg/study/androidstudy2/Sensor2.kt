package com.smalldogg.study.androidstudy2

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.smalldogg.study.androidstudy2.databinding.ActivitySensor2Binding

class Sensor2 : AppCompatActivity() {
    lateinit var b: ActivitySensor2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        b = ActivitySensor2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(b.root)

        val manager = getSystemService(SENSOR_SERVICE) as SensorManager

        val listener = object : SensorEventListener {
            override fun onSensorChanged(event: SensorEvent?) {
                when (event?.sensor?.type) {
                    Sensor.TYPE_ACCELEROMETER ->{
                        b.textView24.text = "X 축 기울기 : ${event.values[0]}"
                        b.textView25.text = "Y 축 기울기 : ${event.values[1]}"
                        b.textView26.text = "Z 축 기울기 : ${event.values[2]}"
                    }
                    Sensor.TYPE_MAGNETIC_FIELD -> {
                        b.textView24.text = "X 축 주변 자기장 : ${event.values[0]}"
                        b.textView25.text = "Y 축 주변 자기장 : ${event.values[1]}"
                        b.textView26.text = "Z 축 주변 자기장 : ${event.values[2]}"
                    }
                }
            }

            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
                TODO("Not yet implemented")
            }

        }

        b.button55.setOnClickListener {
            val sensor = manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
            val chk = manager.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_UI)
            if (!chk) {
                b.textView24.text = "가속도 센서를 지원하지 않음."
            }
        }

        b.button56.setOnClickListener {
            manager.unregisterListener(listener)
        }

        b.button57.setOnClickListener {
            val sensor = manager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD)
            val chk = manager.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_UI)
            if (!chk) {
                b.textView24.text = "자기장 센서를 지원하지 않음."
            }
        }

        b.button58.setOnClickListener {
            manager.unregisterListener(listener)
        }
    }
}