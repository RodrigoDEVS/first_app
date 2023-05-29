package com.example.firstapp.imccalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.firstapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class ImcCalculatorActivity : AppCompatActivity() {

    private var maleSelected = true
    private var femaleSelected = false
    private var currentHeight:Int = 120
    private var currentWeight:Int = 60
    private var currentAge:Int = 30

    private lateinit var maleCard:CardView
    private lateinit var femaleCard:CardView
    private lateinit var tvHeight:TextView
    private lateinit var rsHeight:RangeSlider
    private lateinit var btnSubstract:FloatingActionButton
    private lateinit var btnAdd:FloatingActionButton
    private lateinit var tvWeight:TextView
    private lateinit var btnLess:FloatingActionButton
    private lateinit var btnPlus:FloatingActionButton
    private lateinit var tvAge:TextView
    private lateinit var btnCalculate:AppCompatButton

    companion object{
        const val IMC_KEY = "IMC_RESULT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_calculator)
        initComponents()
        initListeners()
        initUI()
    }

    private fun initComponents() {
        maleCard = findViewById(R.id.maleCard)
        femaleCard = findViewById(R.id.femaleCard)
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeigh)
        btnSubstract = findViewById(R.id.btnSubstract)
        btnAdd = findViewById(R.id.btnAdd)
        tvWeight = findViewById(R.id.tvWeight)
        btnLess = findViewById(R.id.btnLess)
        btnPlus = findViewById(R.id.btnPlus)
        tvAge = findViewById(R.id.tvAge)
        btnCalculate = findViewById(R.id.btnCalculate)
    }

    private fun initListeners() {
        maleCard.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        femaleCard.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        rsHeight.addOnChangeListener { _, value, _ ->
            var df = DecimalFormat("#.##")
            currentHeight =  df.format(value).toInt()
            tvHeight.text = "$currentHeight cm"
        }
        btnSubstract.setOnClickListener {
            currentWeight -= 1
            setWeight()
        }
        btnAdd.setOnClickListener {
            currentWeight += 1
            setWeight()
        }
        btnLess.setOnClickListener {
            currentAge -= 1
            setAge()
        }
        btnPlus.setOnClickListener {
            currentAge += 1
            setAge()
        }
        btnCalculate.setOnClickListener {
            val result = calculateIMC()
            navigateToResult(result)
        }
    }

    private fun navigateToResult(result: Double) {
        val intent = Intent(this, ResultIMCActivity::class.java)
        intent.putExtra(IMC_KEY, result)
        startActivity(intent)
    }

    private fun calculateIMC():Double {
        var df = DecimalFormat("#.##")
        val imc = currentWeight/(currentHeight.toDouble()/100 * currentHeight.toDouble()/100)
        return df.format(imc).toDouble()
    }

    private fun setAge() {
        tvAge.text = currentAge.toString()
    }

    private fun setWeight() {
        tvWeight.text = currentWeight.toString()
    }

    private fun changeGender(){
        maleSelected = !maleSelected
        femaleSelected = !femaleSelected
    }

    private fun setGenderColor(){
        maleCard.setCardBackgroundColor(getBackgroundColor(maleSelected))
        femaleCard.setCardBackgroundColor(getBackgroundColor(femaleSelected))
    }

    private fun getBackgroundColor(selectedGender:Boolean) : Int{
        var selectedColor = if(selectedGender){
            R.color.card_selected
        }else{
            R.color.card_background
        }
        return ContextCompat.getColor(this, selectedColor)
    }

    private fun initUI() {
        setGenderColor()
        setWeight()
        setAge()
    }

}