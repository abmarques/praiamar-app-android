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

class BeachAdapter(private val beachList: ArrayList<Beach>,
                   private val clickListener: OnBeachItemClickListener ) :
    RecyclerView.Adapter<BeachAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val praiaImagem : ImageView = itemView.imageviewPraia
        val txtNomePraia : TextView = itemView.txtNomePraia
        val txtDescricaoPraia : TextView = itemView.txtDescricaoPraia

        fun initialize(item: Beach, action:OnBeachItemClickListener) {
            praiaImagem.setImageResource(item.Imagem)
            txtNomePraia.text = item.Nome
            txtDescricaoPraia.text = item.Descricao

            itemView.setOnClickListener{
                action.onItemClick(item, adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_beach, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val (praiaNome, praiaDescricao, praiaImagem,) = beachList[position]
//        holder.txtNomePraia.text = praiaNome
//        holder.txtDescricaoPraia.text = praiaDescricao
//        holder.praiaImagem.setImageResource(praiaImagem)

        holder.initialize(beachList.get(position), clickListener)


    }

    override fun getItemCount(): Int = beachList.size
}