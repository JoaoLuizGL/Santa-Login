package br.unisanta.loginsanta.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import br.unisanta.loginsanta.R
import br.unisanta.loginsanta.databinding.ActivityLoginBinding
import br.unisanta.loginsanta.model.User
import br.unisanta.loginsanta.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding
    // private val viewmodel = LoginViewModel()
    private val viewmodel:LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEntrar.setOnClickListener{
            val login = binding.edtLogin.text.toString()
            val senha = binding.edtSenha.text.toString()
            val msg = viewmodel.logar(login, senha)
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }
        binding.btnCadastrar.setOnClickListener{
            val login = binding.edtLogin.text.toString()
            val senha = binding.edtSenha.text.toString()
            val usuario = User(login, senha)
            val msg = viewmodel.cadastrar(usuario)
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }
        binding.btnLista.setOnClickListener{
            val login = binding.edtLogin.text.toString()
            if (login == "admin"){
                val intent = Intent(this,ListaUserActivity::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this, "Acesso negado.", Toast.LENGTH_SHORT).show()

            }

        }
    }
}