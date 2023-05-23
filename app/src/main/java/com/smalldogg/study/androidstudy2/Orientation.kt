package com.smalldogg.study.androidstudy2

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.smalldogg.study.androidstudy2.databinding.ActivityOrientationBinding

class Orientation : AppCompatActivity() {
    lateinit var b : ActivityOrientationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        b = ActivityOrientationBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(b.root)

        val manager = getSystemService(SENSOR_SERVICE) as SensorManager

        val listener = object : SensorEventListener {

            //가속도 센서로 부터 측정된 값을 담을 배열
            val accVal = FloatArray(3)
            //자기장 센서로 부터 측정된 값을 담을 배열
            val magVal = FloatArray(3)

            //두 센서로 부터 값을 얻어온 적이 있는지
            var isGetAcc = false
            var isGetMag = false

            override fun onSensorChanged(event: SensorEvent?) {
                when (event?.sensor?.type) {
                    Sensor.TYPE_ACCELEROMETER -> {
                        accVal[0] = event.values.get(0)
                        accVal[1] = event.values.get(1)
                        accVal[2] = event.values.get(2)

                        isGetAcc = true
                    }
                    Sensor.TYPE_MAGNETIC_FIELD -> {
                        magVal[0] = event.values[0]
                        magVal[1] = event.values[1]
                        magVal[2] = event.values[2]

                        isGetMag = true
                    }
                }
                if (isGetAcc && isGetMag) {
                    val R = FloatArray(9)
                    val I = FloatArray(9)

                    SensorManager.getRotationMatrix(R,I,accVal,magVal)
                    val values = FloatArray(3)
                    SensorManager.getOrientation(R,values)
                    // Radian 값을 각도 값으로 변경
                    var azimuth = Math.toDegrees(values[0].toDouble()).toFloat()
                    val pith = Math.toDegrees(values[1].toDouble()).toFloat()
                    val roll = Math.toDegrees(values[2].toDouble()).toFloat()
                    if (azimuth < 0) {
                        azimuth+=360f
                    }
                    b.textView23.text = "방위값 : $azimuth"
                    b.textView27.text = "좌우 기울기 : $pith"
                    b.textView28.text = "앞의 기울기 : $roll"

                    b.imageView9.rotation = 360 - azimuth
                }
            }

            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
            }

        }

        b.button59.setOnClickListener {
            val sensor1 = manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
            val sensor2 = manager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD)

            manager.registerListener(listener,sensor1,SensorManager.SENSOR_DELAY_UI)
            manager.registerListener(listener,sensor2,SensorManager.SENSOR_DELAY_UI)
        }
    }
}