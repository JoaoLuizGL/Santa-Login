package br.unisanta.loginsanta.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.unisanta.loginsanta.R
import br.unisanta.loginsanta.adapter.UsuarioAdapter
import br.unisanta.loginsanta.viewmodel.LoginViewModel

class ListaUserActivity : AppCompatActivity() {
    private val viewmodel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_user)
        val rvUsuarios = findViewById<RecyclerView>(R.id.rv_usuarios)
        val usuarios = viewmodel.lista()
        rvUsuarios.layoutManager = LinearLayoutManager(this)
        rvUsuarios.adapter = UsuarioAdapter(usuarios)
        }
    }