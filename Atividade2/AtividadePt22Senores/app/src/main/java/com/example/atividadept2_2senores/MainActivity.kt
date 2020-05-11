package com.example.atividadept2_2senores

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity(), SensorEventListener {
    private lateinit var sensorManager: SensorManager
    private var sensorLuminosidade: Sensor? = null
    private var sensorGravity: Sensor? = null

    lateinit var textSensor: TextView
    lateinit var x_view: TextView
    lateinit var y_view: TextView
    lateinit var z_view: TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textSensor = findViewById(R.id.text_sensor_saida)
        x_view = findViewById(R.id.x_gravity)
        y_view = findViewById(R.id.y_gravity)
        z_view = findViewById(R.id.z_gravity)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensorLuminosidade = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
        sensorGravity = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY)
        if (sensorLuminosidade == null){
            textSensor.text = "Sensor não suportado."
        }
    }

    override fun onResume() {
        super.onResume()
//        if (sensorLuminosidade != null) {
        sensorManager.registerListener(this, sensorLuminosidade, SensorManager.SENSOR_DELAY_NORMAL)
//        }
        sensorManager.registerListener(this, sensorGravity, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
//        if (sensorLuminosidade != null){
//            sensorManager.unregisterListener(this)
//        }
        sensorManager.unregisterListener(this)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event?.sensor?.type == Sensor.TYPE_LIGHT){
            textSensor.text = event.values[0].toString()
        } else if (event?.sensor?.type == Sensor.TYPE_GRAVITY){
            x_view.text = event.values[0].toString()
            y_view.text = event.values[1].toString()
            z_view.text = event.values[2].toString()
        }
    }
}
