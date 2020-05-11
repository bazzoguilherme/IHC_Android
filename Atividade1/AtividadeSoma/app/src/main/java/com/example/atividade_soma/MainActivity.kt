package com.example.atividade_soma

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button_sum).setOnClickListener {
            sumValues()
        }
    }

    private fun sumValues() {
        val value1 = findViewById<EditText>(R.id.value1)
        val value2 = findViewById<EditText>(R.id.value2)
        val resultValue = findViewById<TextView>(R.id.result_number)

        var resultSoma: String = ""

        try {
            val num1 = value1.text.toString().toInt()
            val num2 = value2.text.toString().toInt()

            resultSoma = (num1 + num2).toString()
        } catch (e: NumberFormatException) {
            resultSoma = "Erro: verifique a entrada!"
        }
        resultValue.text = resultSoma
    }
}
