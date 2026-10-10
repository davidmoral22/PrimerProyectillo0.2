package com.example.primeroyectillo.logic.`interface`

import com.example.primeroyectillo.data.Cliente

interface AccionesCliente {
    fun clienteAñadir(cliente: Cliente)
    fun clienteBorrar(id: Int)
    fun clienteActualizar(id: Int, nuevoNombre: String, nuevosApellidos: String, nuevoTelefono: String)
}