package com.example.primeroyectillo.views

import android.util.Log
import com.example.primeroyectillo.data.Cliente
import com.example.primeroyectillo.logic.`interface`.AccionesCliente
import kotlin.random.Random

class DialogoClientes {
    private var listener: AccionesCliente? = null
    fun setListener(listener: AccionesCliente) {
        this.listener = listener
    }

    fun show() {
        Log.d("DialogoClientes", "Mostrando diálogo simulado de captura de datos...")
    }

    // Metiendo un cliente aleatorio
    fun emularInsercion() {
        val idAleatorio = Random.nextInt(103, 200)
        val nuevoCliente = Cliente(idAleatorio, "Nombre$idAleatorio", "Apellidos$idAleatorio", "60000000$idAleatorio")
        Log.d("DialogoClientes", "Metiendo cliente id: $idAleatorio")
        listener?.clienteAñadir(nuevoCliente)
    }

    // Ectualización de un cliente existente
    fun emularActualizacion(clientesActuales: List<Cliente>) {
        if (clientesActuales.isNotEmpty()) {
            val clienteAleatorio = clientesActuales.random()
            Log.d("DialogoClientes", "Actualización de cliente id: ${clienteAleatorio.id}")
            listener?.clienteActualizar(clienteAleatorio.id, "CAMBIADO", "NUEVO_APELLIDO", "999999999")
        }
    }

    // Vorrado de un cliente existente
    fun emularBorrado(clientesActuales: List<Cliente>) {
        if (clientesActuales.isNotEmpty()) {
            val clienteAleatorio = clientesActuales.random()
            Log.d("DialogoClientes", "Borrado de cliente id: ${clienteAleatorio.id}")
            listener?.clienteBorrar(clienteAleatorio.id)
        }
    }
}