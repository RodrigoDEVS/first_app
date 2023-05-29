package com.example.firstapp.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat
import com.example.firstapp.R
import com.example.firstapp.imccalculator.ImcCalculatorActivity.Companion.IMC_KEY

class ResultIMCActivity : AppCompatActivity() {

    private lateinit var tvFinal:TextView
    private lateinit var tvIMC:TextView
    private lateinit var tvDescription:TextView
    private lateinit var btnRecalculate:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imcactivity)
        val result:Double = intent.extras?.getDouble(IMC_KEY) ?: -1.0
        initComponents()
        initUI(result)
        initListeners()
    }

    private fun initListeners() {
        btnRecalculate.setOnClickListener { finish() }
    }

    private fun initUI(result: Double) {
        tvIMC.text = result.toString()
        when(result){
            in 0.00..18.50 -> {
                tvFinal.text = getString(R.string.under_weight)
                tvFinal.setTextColor(ContextCompat.getColor(this, R.color.under_weight))
                tvDescription.text = getString(R.string.under_weight_description)
            }
            in 18.51..24.99 -> {
                tvFinal.text = getString(R.string.normal_weight)
                tvFinal.setTextColor(ContextCompat.getColor(this, R.color.normal_weight))
                tvDescription.text = getString(R.string.normal_weight_description)
            }
            in 25.00..29.99 -> {
                tvFinal.text = getString(R.string.overweight)
                tvFinal.setTextColor(ContextCompat.getColor(this, R.color.overweight))
                tvDescription.text = getString(R.string.overweight_description)
            }
            in 30.00..34.99 -> {
                tvFinal.text = getString(R.string.obesity_1)
                tvFinal.setTextColor(ContextCompat.getColor(this, R.color.obesity_1))
                tvDescription.text = getString(R.string.obesity_1_description)
            }
            in 35.00..39.99 -> {
                tvFinal.text = getString(R.string.obesity_2)
                tvFinal.setTextColor(ContextCompat.getColor(this, R.color.obesity_2))
                tvDescription.text = getString(R.string.obesity_2_description)
            }
            in 40.00..99.99 -> {
                tvFinal.text = getString(R.string.morbid_obesity)
                tvFinal.setTextColor(ContextCompat.getColor(this, R.color.morbid_obesity))
                tvDescription.text = getString(R.string.morbid_obesity_description)
            }
            else -> {
                tvIMC.text = getString(R.string.error)
                tvFinal.text = getString(R.string.error)
                tvFinal.setTextColor(ContextCompat.getColor(this, R.color.error))
                tvDescription.text = getString(R.string.error)
            }
        }
    }

    private fun initComponents() {
        tvFinal = findViewById(R.id.tvFinal)
        tvIMC = findViewById(R.id.tvIMC)
        tvDescription = findViewById(R.id.tvDescription)
        btnRecalculate = findViewById(R.id.btnRecalculate)
    }
}