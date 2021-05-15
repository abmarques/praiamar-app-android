package br.com.praiamar.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import br.com.praiamar.R
import br.com.praiamar.adapters.HomeAdapter
import br.com.praiamar.models.Litoral
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var litoralList = mutableListOf<Litoral>()
    private var adapter = HomeAdapter(litoralList, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        litoralList.add(0, Litoral("Litoral Norte", "Lirotal norte cheio de encantos...", R.drawable.porto_de_galinhas))
        litoralList.add(1, Litoral("Litoral Sul", "Lirotal norte cheio de encantos...", R.drawable.praia_de_calhetas))
        litoralList.add(2, Litoral("Piscinas Naturais", "Lirotal norte cheio de encantos...", R.drawable.praia_dos_carneiros))
        litoralList.add(2, Litoral("Ilhas", "Lirotal norte cheio de encantos...", R.drawable.praia_de_maracaipe))
        litoralList.add(3, Litoral("Parques Aquáticos", "Lirotal norte cheio de encantos...", R.drawable.coroa_do_aviao))

        initRecyclerView()

    }

    private fun initRecyclerView() {
        recyclerView.adapter = adapter

        val layoutManager = GridLayoutManager(this, 1)
        recyclerView.layoutManager = layoutManager
    }
}