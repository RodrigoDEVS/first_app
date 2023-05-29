package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.example.firstapp.imccalculator.ImcCalculatorActivity
import com.example.firstapp.todoapp.TodoActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnInput = findViewById<AppCompatButton>(R.id.btnInput)
        val btnImcApp = findViewById<AppCompatButton>(R.id.btnIMCApp)
        val btnTODOApp = findViewById<AppCompatButton>(R.id.btnTODOApp)

        btnInput.setOnClickListener {
            val intent = Intent(this, FirstAppActivity::class.java)
            startActivity(intent)
        }
        btnImcApp.setOnClickListener {
            val intent = Intent(this, ImcCalculatorActivity::class.java)
            startActivity(intent)
        }
        btnTODOApp.setOnClickListener {
            val intent = Intent(this, TodoActivity::class.java)
            startActivity(intent)
        }

    }
}