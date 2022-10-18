package com.example.timeconverter

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.timeconverter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener { calcucateTime() }
    }

    @SuppressLint("StringFormatMatches")
    private fun calcucateTime() {
        val stringInTextField = binding.minutesToConvert.text.toString()
        val time = stringInTextField.toDoubleOrNull()
        if (time == null) {
            binding.convertResult.text = ""
            return
        }
        val timeConvert: Double = when (binding.convertOptions.checkedRadioButtonId) {
            R.id.option_days -> 0.00069444444444444
            R.id.option_hours -> 0.0166666666666667
            else -> 60.0
        }

        var wynik = time * timeConvert
        wynik = if (binding.roundUpSwitch.isChecked) {
            "%.3f".format(wynik).toDouble()
        } else {
            String.format("%.6f", wynik).toDouble()
        }
        binding.convertResult.text = getString(R.string.wynik, wynik)
    }
}