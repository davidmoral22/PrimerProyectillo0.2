package com.example.primerproyectillo.views

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.primerproyectillo.R
import com.example.primerproyectillo.Controlador.ClienteControlador

class MainActivity : AppCompatActivity() {

    // Declaramos los botones como públicos o accesibles
    lateinit var btnInsertar: Button
    lateinit var btnActualizar: Button
    lateinit var btnBorrar: Button

    private lateinit var controlador: ClienteControlador

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Vinculamos con los IDs del XML (asegúrate de que coincidan con los tuyos)
        btnInsertar = findViewById(R.id.btnInsertar)
        btnActualizar = findViewById(R.id.btnActualizar)
        btnBorrar = findViewById(R.id.btnBorrar) // Si en tu XML se llama de otra forma, cámbialo aquí

        // Arrancamos el controlador pasándole la actividad
        controlador = ClienteControlador(this)
        controlador.start()
    }
}