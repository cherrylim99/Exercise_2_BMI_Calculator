package com.example.exercise_2_bmi_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val reset : Button = findViewById(R.id.buttonReset)
        val calculateBMI : Button = findViewById(R.id.buttonCalculate)
        calculateBMI.setOnClickListener{calculateBMI()}
        reset.setOnClickListener{reset()}
    }
    fun calculateBMI(){
        val weightInKg : EditText = findViewById(R.id.editTextWeight)
        val heightInCm : EditText = findViewById(R.id.editTextHeight)
        val heightInMeter : Double = heightInCm.text.toString().toDouble() / 100
        val bmi : Double = weightInKg.text.toString().toDouble() / (heightInMeter * heightInMeter)
        val bmiText : TextView = findViewById(R.id.textViewBMI)
        bmiText.text = String.format("%s %.2f",getString(R.string.bmi),bmi)
        val imageBMI : ImageView = findViewById(R.id.imageViewProfile)
        if(bmi<18.5)
        {
            imageBMI.setBackgroundResource(R.drawable.under)
        }else if(bmi in 18.5..24.9){
            imageBMI.setBackgroundResource(R.drawable.normal)
        }
        else if(bmi>25){
            imageBMI.setBackgroundResource(R.drawable.over)
        }
    }

    private fun reset(){
        val weightInKg : EditText = findViewById(R.id.editTextWeight)
        val heightInCm : EditText = findViewById(R.id.editTextHeight)
        val bmiText : TextView = findViewById(R.id.textViewBMI)
        weightInKg.text.clear()
        heightInCm.text.clear()
        bmiText.text = getString(R.string.bmi)
        val imageBMI : ImageView = findViewById(R.id.imageViewProfile)
        imageBMI.setBackgroundResource(R.drawable.empty)
        //weightInKg.hint = getString(R.string.weight)
        //heightInCm.hint = getString(R.string.height)
    }

}