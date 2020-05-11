package com.example.atividadept2_latlong

import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var lat: TextView
    private lateinit var long: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gps_button : Button = findViewById(R.id.button_gps)
        gps_button.setOnClickListener {
            showGPSInfo(it)
        }
        lat  = findViewById(R.id.val_latitute)
        long = findViewById(R.id.val_longitude)
    }

    private fun showGPSInfo(view: View) {
        val gps = GPSTracker(applicationContext)
        val l : Location? = gps.location
        if (l != null) {
            lat.text = l.latitude.toString()
            long.text = l.longitude.toString()
        }
    }
}
