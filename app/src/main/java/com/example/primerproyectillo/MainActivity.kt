package com.example.primeroyectillo.views

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.primeroyectillo.data.Cliente
import com.example.primeroyectillo.data.RepositorioClientes
import com.example.primeroyectillo.logic.`interface`.AccionesCliente
import com.example.primerproyectillo.R

class MainActivity : AppCompatActivity(), AccionesCliente {

    private val listaClientes = mutableListOf<Cliente>()
    private val dialogo = DialogoClientes()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Cargamos los clientes iniciales
        listaClientes.addAll(RepositorioClientes.clientesIniciales)
        Log.d("MainActivity", "Lista inicial: $listaClientes")

        // Configuramos el listener del diálogo
        dialogo.setListener(this)

        // Enlazamos los botones de la pantalla
        val btnInsertar = findViewById<Button>(R.id.btnInsertar)
        val btnActualizar = findViewById<Button>(R.id.btnActualizar)
        val btnBorrar = findViewById<Button>(R.id.btnBorrar)

        btnInsertar.setOnClickListener {
            dialogo.show()
            dialogo.emularInsercion()
        }

        btnActualizar.setOnClickListener {
            dialogo.show()
            dialogo.emularActualizacion(listaClientes)
        }

        btnBorrar.setOnClickListener {
            dialogo.show()
            dialogo.emularBorrado(listaClientes)
        }
    }

    override fun clienteAñadir(cliente: Cliente) {
        listaClientes.add(cliente)
        Log.d("MainActivity", "El cliente con id=${cliente.id}, ha sido insertado correctamente")
        Log.d("MainActivity", listaClientes.toString())
    }

    override fun clienteBorrar(id: Int) {
        val clienteAEliminar = listaClientes.find { it.id == id }
        if (clienteAEliminar != null) {
            listaClientes.remove(clienteAEliminar)
            Log.d("MainActivity", "El cliente con id=$id, ha sido eliminado correctamente")
            Log.d("MainActivity", listaClientes.toString())
        }
    }

    override fun clienteActualizar(id: Int, nuevoNombre: String, nuevosApellidos: String, nuevoTelefono: String) {
        val indice = listaClientes.indexOfFirst { it.id == id }
        if (indice != -1) {
            listaClientes[indice] = Cliente(id, nuevoNombre, nuevosApellidos, nuevoTelefono)
            Log.d("MainActivity", "El cliente con id=$id, ha sido actualizado correctamente")
            Log.d("MainActivity", listaClientes.toString())
        }
    }
}