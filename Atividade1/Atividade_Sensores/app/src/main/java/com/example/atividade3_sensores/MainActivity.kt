package com.example.atividade3_sensores

import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import kotlin.math.abs


class MainActivity : AppCompatActivity(), SensorEventListener {
    private lateinit var sensorManager: SensorManager
    private var sensor: Sensor? = null


    lateinit var x_val: EditText
    lateinit var y_val: EditText
    lateinit var z_val: EditText

    var xAntigo: Float = 0.0f
    var yAntigo: Float = 0.0f
    var zAntigo: Float = 0.0f

    val limitarAlteracao: Float = 6.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        x_val = findViewById(R.id.edit_x)
        y_val = findViewById(R.id.edit_y)
        z_val = findViewById(R.id.edit_z)

    }

    override fun onResume() {
        super.onResume()
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event?.sensor?.type == Sensor.TYPE_ACCELEROMETER){
            val x = event.values[0]
            val y = event.values[1]
            val z = event.values[2]

            if (xAntigo == 0.0f && yAntigo == 0.0f && zAntigo == 0.0f) {
                xAntigo = x
                yAntigo = y
                zAntigo = z
            }

            x_val.setText(x.toString())
            y_val.setText(y.toString())
            z_val.setText(z.toString())

            if ((abs(x)-abs(xAntigo) > limitarAlteracao) ||
                (abs(y)-abs(yAntigo) > limitarAlteracao) ||
                (abs(z)-abs(zAntigo) > limitarAlteracao)
            ) {
                val intent = Intent(this, NewActivitySensor::class.java)
                startActivity(intent)
            }

            xAntigo = x
            yAntigo = y
            zAntigo = z

        }

//        if (abs(x_val.text.toString().toDouble()) < 1.0f &&
//            y_val.text.toString().toDouble() > 9.0f &&
//            abs(z_val.text.toString().toDouble()) < 2.5f){
//            val intent = Intent(this, NewActivitySensor::class.java)
//            startActivity(intent)
//        }

    }
}
