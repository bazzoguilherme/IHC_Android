package com.example.atividade2_newactivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MessageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)

        val message = intent.getStringExtra(EXTRA_MESSAGE)

        findViewById<TextView>(R.id.sent_text).apply {
            text = message
        }

    }
}
