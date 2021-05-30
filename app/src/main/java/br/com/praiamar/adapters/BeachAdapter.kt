package br.com.praiamar.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.praiamar.R
import br.com.praiamar.models.Beach
import kotlinx.android.synthetic.main.activity_beach.view.*

class BeachAdapter(private val beachList: ArrayList<Beach>) :
    RecyclerView.Adapter<BeachAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val praiaImagem : ImageView = itemView.imageviewPraia
        val txtNomePraia : TextView = itemView.txtNomePraia
        val txtDescricaoPraia : TextView = itemView.txtDescricaoPraia
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeachAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_beach, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: BeachAdapter.ViewHolder, position: Int) {
        val (praiaNome, praiaDescricao, praiaImagem,) = beachList[position]
        holder.txtNomePraia.text = praiaNome
        holder.txtDescricaoPraia.text = praiaDescricao
        holder.praiaImagem.setImageResource(praiaImagem)


    }

    override fun getItemCount(): Int = beachList.size
}