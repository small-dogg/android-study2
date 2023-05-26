package com.smalldogg.study.androidstudy2

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.smalldogg.study.androidstudy2.databinding.ActivityGpsBinding

class GPS : AppCompatActivity() {

    lateinit var b: ActivityGpsBinding

    val permissionList = arrayOf(
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        b = ActivityGpsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gps)

        requestPermissions(permissionList, 0)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        for (r1 in grantResults) {
            if (r1 == PackageManager.PERMISSION_DENIED) {
                return
            }
        }

        //위치 정보를 관리하는 매니저 추출
        val manager = getSystemService(LOCATION_SERVICE) as LocationManager

        //저장되어있는 위치정보 추출
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        val location1 = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
        val location2 = manager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)

        if (location1 != null) {
            showInfo(location1)
        } else if (location2 != null) {
            showInfo(location2)
        }

        val listener = LocationListener {
            showInfo(it)
        }

        b.button61.setOnClickListener {
            if (manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0f, listener)
            }
            if (manager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
                manager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0f, listener)
            }
        }

        b.button62.setOnClickListener {
            manager.removeUpdates(listener)
        }

    }

    fun showInfo(location: Location) {
        if (location != null) {
            b.textView29.text = "Provider : ${location.provider}"
            b.textView30.text = "Provider : ${location.latitude}"
            b.textView31.text = "Provider : ${location.longitude}"
        }

    }
}