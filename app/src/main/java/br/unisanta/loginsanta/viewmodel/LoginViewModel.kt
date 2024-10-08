package br.unisanta.loginsanta.viewmodel

import androidx.lifecycle.ViewModel
import br.unisanta.loginsanta.model.User

class LoginViewModel:ViewModel(){
    private val users = mutableListOf<User>()
    fun logar(loginA:String, senhaA:String):String{
        val contem = users.find { it.login == loginA && it.senha == senhaA}
        if (contem!=null){
            return "Login realizado!"
        }
        else{
            return "Login inválido."
        }
    }
    fun cadastrar(user:User):String{
        users.add(user)
        return "Cadastrado!"
    }
}