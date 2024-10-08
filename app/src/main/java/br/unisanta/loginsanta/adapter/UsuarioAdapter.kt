package br.unisanta.loginsanta.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.unisanta.loginsanta.R
import br.unisanta.loginsanta.model.User

class UsuarioAdapter(private val usuarios:List<User>):
    RecyclerView.Adapter<UsuarioAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val txvLogin: TextView = itemView.findViewById(R.id.txv_login_usuario)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_usuario,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val usuario = usuarios[position]
        holder.txvLogin.text = usuario.login
    }
    override fun getItemCount(): Int {
        return usuarios.size
    }
}