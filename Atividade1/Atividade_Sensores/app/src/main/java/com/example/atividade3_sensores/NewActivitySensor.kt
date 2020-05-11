package com.example.atividade3_sensores

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class NewActivitySensor : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_sensor)

        val button = findViewById<Button>(R.id.button_goBack)
        button.setOnClickListener {
            goBackActivity()
        }
    }

    private fun goBackActivity() {
        finish()
    }
}
