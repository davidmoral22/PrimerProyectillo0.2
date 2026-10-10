package com.example.primerproyectillo.Controlador

import android.util.Log
import com.example.primeroyectillo.data.Cliente
import com.example.primeroyectillo.data.RepositorioClientes
import com.example.primeroyectillo.logic.`interface`.AccionesCliente
import com.example.primerproyectillo.views.MainActivity
import kotlin.collections.isNotEmpty


class ClienteControlador(private val activity: MainActivity) : AccionesCliente {


    fun start() {
        // 1. Cargamos la lista de clientes del repositorio
        val clientesActuales = RepositorioClientes.clientesIniciales


        // 2. Configuramos los botones de la Activity para asociar la lógica
        activity.btnInsertar.setOnClickListener {
            this.emularInsercion()
        }


        activity.btnActualizar.setOnClickListener {
            this.emularActualizacion(clientesActuales)
        }


        activity.btnBorrar.setOnClickListener {
            this.emularBorrado(clientesActuales)
        }
    }


    private fun emularInsercion() {
        val nuevoCliente = Cliente(4, "Cliente", "Nuevo", "600123456")
        clienteAñadir(nuevoCliente)
    }
    private fun emularActualizacion(lista: List<Cliente>) {
        if (lista.isNotEmpty()) {
            val cliente = lista[0]
            clienteActualizar(cliente.id, "ClienteModificado", cliente.apellidos, cliente.telefono)
        }
    }
    private fun emularBorrado(lista: List<Cliente>) {
        if (lista.isNotEmpty()) {
            val cliente = lista[0]
            clienteBorrar(cliente.id)
        }
    }
    override fun clienteAñadir(cliente: Cliente) {
        Log.d("ClienteControlador", "Añadido cliente con ID: ${cliente.id} - ${cliente.nombre}")
    }
    override fun clienteBorrar(id: Int) {
        Log.d("ClienteControlador", "Borrado cliente con ID: $id")
    }
    override fun clienteActualizar(id: Int, nuevoNombre: String, nuevosApellidos: String, nuevoTelefono: String) {
        Log.d("ClienteControlador", "Actualizado cliente con ID: $id a nuevo nombre: $nuevoNombre")
    }
}
