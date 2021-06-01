package br.com.praiamar.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.praiamar.R
import br.com.praiamar.models.Coast
import kotlinx.android.synthetic.main.activity_home.view.*

class HomeAdapter(private val coastList: List<Coast>,
                  private val onRecyclerViewClickListener: OnRecyclerViewClickListener) :
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
        val (nomeLitoral, descricaoLitoral, litoralImagem) = coastList[position]
        holder.txtNomeLitoral.text = nomeLitoral
        holder.txtDescricaoLitoral.text = descricaoLitoral
        holder.litoralImagem.setImageResource(litoralImagem)

        holder.itemView.setOnClickListener {
            onRecyclerViewClickListener.onRecyclerViewItemClicked(position)

        }
    }

    override fun getItemCount(): Int = coastList.size
}