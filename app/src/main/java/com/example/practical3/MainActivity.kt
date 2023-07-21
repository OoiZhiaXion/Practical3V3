package com.example.practical3

import android.icu.util.Currency
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioGroup
import android.widget.Spinner
import com.example.practical3.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        //inflate = load UI to memory
        binding = ActivityMainBinding.inflate(layoutInflater)
        //Show UI
        setContentView(binding.root)
        binding.buttonCalculate.setOnClickListener{
            val age = binding.spinnerAge.selectedItemPosition
            val gender = binding.radioGroupGender.checkedRadioButtonId
            val smoker = binding.checkBoxSmoker.isChecked
            //get different currency based on pc
            val currency:Currency = Currency.getInstance(Locale.getDefault())
            val symbol: String = currency.symbol
            var premium = 0

            if (age == 0)
            {//less than 17
                premium += 60

            }
            else if(age == 1){
                premium += 70
                if (gender == binding.radioButtonMale.id)
                {
                    premium += 50
                    if(smoker)
                    {
                        premium += 100
                    }
                }
            }
            else if(age == 2)
            {
                premium += 90
                if (gender == binding.radioButtonMale.id)
                {
                    premium += 100
                    if(smoker)
                    {
                        premium += 150
                    }
                }
            }
            else if(age == 3)
            {
                premium += 120
                if (gender == binding.radioButtonMale.id)
                {
                    premium += 150
                    if(smoker)
                    {
                        premium += 200
                    }
                }
            }
            else if(age == 4)
            {
                premium += 150
                if (gender == binding.radioButtonMale.id)
                {
                    premium += 200
                    if(smoker)
                    {
                        premium += 250
                    }
                }
            }
            else if (age == 5)
            {
                premium += 150
                if (gender == binding.radioButtonMale.id)
                {
                    premium += 200
                    if(smoker)
                    {
                        premium += 300
                    }
                }
            }
//            binding.textViewPremium.setText("RM"+ premium)
            binding.textViewPremium.text = String.format("%s %d", symbol,premium)

        }
        binding.buttonReset.setOnClickListener{
            binding.textViewPremium.text = ""
            binding.radioGroupGender.clearCheck()
            binding.checkBoxSmoker.isChecked = false
            binding.spinnerAge.setSelection(0)
        }
    }



}