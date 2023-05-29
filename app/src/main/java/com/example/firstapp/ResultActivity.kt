package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        var elResult = findViewById<TextView>(R.id.elResult)
        var name = intent.extras?.getString("EXTRA_TEXTO").orEmpty()
        elResult.text = "Bienvenido $name"
    }
}