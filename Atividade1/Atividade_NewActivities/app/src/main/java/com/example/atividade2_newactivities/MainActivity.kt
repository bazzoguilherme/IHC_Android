package com.example.atividade2_newactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

const val EXTRA_MESSAGE = "com.example.atividade2_newactivities.MESSAGE"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val send = findViewById<Button>(R.id.button_send)
        send.setOnClickListener {
            sendMessage(it)
        }
    }

    private fun sendMessage(view: View){
        val inputText = findViewById<EditText>(R.id.input_textMessage)
        val message = inputText.text.toString()
        val intent = Intent(this, MessageActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }
}
