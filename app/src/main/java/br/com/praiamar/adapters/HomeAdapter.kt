package br.com.praiamar.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import br.com.praiamar.R
import br.com.praiamar.models.Litoral
import br.com.praiamar.views.activities.HomeActivity
import br.com.praiamar.views.activities.MainActivity
import kotlinx.android.synthetic.main.activity_home.view.*
import java.util.*

class HomeAdapter(private val litoralList: List<Litoral>,
                  private val activity: MainActivity) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val litoralImagem : ImageView = itemView.imageview
        val txtNomeLitoral : TextView = itemView.txtNomeLitoral
        val txtDescricaoLitoral : TextView = itemView.txtDescricaoLitoral
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_home, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeAdapter.ViewHolder, position: Int) {
        val (nomeLitoral, descricaoLitoral, litoralImagem) = litoralList[position]
        holder.txtNomeLitoral.text = nomeLitoral
        holder.txtDescricaoLitoral.text = descricaoLitoral
        holder.litoralImagem.setImageResource(litoralImagem)

        holder.itemView.setOnClickListener {

            val litoralNome = litoralList.get(position).Nome
            val litoralDescricao = litoralList.get(position).Descricao
            val litoralImagem = "${litoralNome}\n${litoralDescricao}"

            Toast.makeText(activity, litoralNome, Toast.LENGTH_SHORT).show()

        }
    }

    override fun getItemCount(): Int = litoralList.size
}