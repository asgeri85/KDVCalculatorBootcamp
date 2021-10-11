package com.example.kdvcalculatorbootcamp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kdvcalculatorbootcamp.databinding.ActivityMainBinding
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            tutarHesapla()
        }
    }

    fun tutarHesapla(){
        val tutar=binding.editTextTextPersonName.text.toString()
        if(tutar.isNullOrEmpty()){
            Toast.makeText(applicationContext,"Miktar giriniz",Toast.LENGTH_SHORT).show()
            return
        }
        val rakam=tutar.toDouble()

        val faiz=when(binding.radioGroup.checkedRadioButtonId){
            R.id.radioButtonMuk->0.2
            R.id.radioButtonİyi->0.18
            R.id.radioButton->0.15
            else->0.13
        }

        var kdv=rakam*faiz
        if (binding.switch1.isChecked){
            kdv=kotlin.math.ceil(kdv)
        }

        val formatKDv=NumberFormat.getCurrencyInstance(Locale("tr","TR")).format(kdv)
        binding.textViewTutar.text="Tutar:$formatKDv"
    }
}