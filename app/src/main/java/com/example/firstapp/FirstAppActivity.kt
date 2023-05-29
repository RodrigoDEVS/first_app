package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText

class FirstAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_app)

        val btnPress = findViewById<AppCompatButton>(R.id.btnPress)
        val txtInput = findViewById<AppCompatEditText>(R.id.txtInput)

        btnPress.setOnClickListener{
            var texto = txtInput.text.toString()
            if (texto.isNotEmpty()){

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("EXTRA_TEXTO", texto)
                startActivity(intent)

            }
        }
    }
}