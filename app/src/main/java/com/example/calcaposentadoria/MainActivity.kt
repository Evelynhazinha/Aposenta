package com.example.calcaposentadoria

import android.R
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.calcaposentadoria.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btCalc.setOnClickListener {
            calcularAposentadoria()
        }
    }

    private  fun calcularAposentadoria() {
        val idade = binding.InputEditText.text.toString().toInt()
        val items = listOf("Feminino" , "Masculino" )
        val adapter = ArrayAdapter(this, R.layout.simple_spinner_dropdown_item, items)
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        binding.actionBarSpinner.adapter = adapter

        val genero = binding.actionBarSpinner.selectedItem.toString()

        var resultado: Int


        if (genero == "Masculino") {
            resultado = 65 - idade
        } else {
            resultado = 62 - idade
        }

        if (resultado <= 0){
            binding.result.text = "Você já deveria estar aposentado."
        } else  if (resultado == 1){
            binding.result.text = "Falta ${resultado} ano para você se aposentar."
        } else {
            binding.result.text = "Faltam ${resultado} anos para você se aposentar."
        }


    }
}