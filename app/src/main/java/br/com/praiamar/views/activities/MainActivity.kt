package br.com.praiamar.views.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import br.com.praiamar.R
import br.com.praiamar.adapters.HomeAdapter
import br.com.praiamar.adapters.OnRecyclerViewClickListener
import br.com.praiamar.models.Coast
import br.com.praiamar.models.Beach
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnRecyclerViewClickListener  {
    private var litoralList = arrayListOf<Coast>()
    private var adapter = HomeAdapter(litoralList, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadHomeDataList()
        initRecyclerView()

    }

    private fun initRecyclerView() {
        homeRecyclerView.adapter = adapter
        adapter.notifyDataSetChanged()

        val layoutManager = GridLayoutManager(this, 1)
        homeRecyclerView.layoutManager = layoutManager
    }


    override fun onRecyclerViewItemClicked(position: Int) {
        val intent = Intent(this, CoastActivity::class.java)
        var aux = litoralList[position].beaches
        intent.putParcelableArrayListExtra("praias", aux)
        startActivity(intent)
    }











    private fun loadHomeDataList() {

        /*Load Litoral Norte*/
        var praiasLitoralNorte = arrayListOf<Beach>()
        praiasLitoralNorte.add(0, Beach("Ilha de Itamaracá", "A Ilha de Itamaracá...", R.drawable.coroa_do_aviao))
        praiasLitoralNorte.add(1, Beach("Mangue Seco", "Forte Orange...", R.drawable.coroa_do_aviao))
        praiasLitoralNorte.add(2, Beach("Ponta de Pedras", "Forte Orange...", R.drawable.coroa_do_aviao))
        var litoralNorte = Coast("Litoral Norte", "Lirotal norte cheio de encantos...", R.drawable.coroa_do_aviao, praiasLitoralNorte)


        /*Load Litoral Sul*/
        var praiasLitoralSul = arrayListOf<Beach>()
        praiasLitoralSul.add(0, Beach("Praia de Boa Viagem", "Praia de Boa Viagem...", R.drawable.porto_de_galinhas))
        praiasLitoralSul.add(1, Beach("Porto de Galinhas", "Porto de Galinhas...", R.drawable.porto_de_galinhas))
        praiasLitoralSul.add(2, Beach("Praia de Muro Alto", "Praia de Muro Alto...", R.drawable.porto_de_galinhas))
        var litoralSul = Coast("Litoral Sul", "Lirotal norte cheio de encantos...", R.drawable.porto_de_galinhas, praiasLitoralSul)


        /*Load Piscinas Naturais*/
        var piscinasNaturais = arrayListOf<Beach>()
        piscinasNaturais.add(0, Beach("Piscinas Naturais do Paiva", "Piscinas Naturais do Paiva...", R.drawable.praia_de_calhetas))
        piscinasNaturais.add(1, Beach("Piscinas Naturais de Serrambi", "Piscinas Naturais de Serrambi...", R.drawable.praia_de_calhetas))
        piscinasNaturais.add(2, Beach("Piscinas Naturais de Muro Alto", "Piscinas Naturais de Muro Alto...", R.drawable.praia_de_calhetas))
        var piscinaNatural = Coast("Piscinas Naturais", "Lirotal norte cheio de encantos...", R.drawable.praia_de_calhetas, piscinasNaturais)


        /*Load Ilhas*/
        var ilhas = arrayListOf<Beach>()
        ilhas.add(0, Beach("Fernando de Noronha", "Fernando de Noronha...", R.drawable.praia_de_maracaipe))
        ilhas.add(1, Beach("Ilha Coroa do Aviao", "Ilha Coroa do Aviao...", R.drawable.praia_de_maracaipe))
        ilhas.add(2, Beach("Ilha de Santo Aleixo", "Ilha de Santo Aleixo...", R.drawable.praia_de_maracaipe))
        var ilha = Coast("Ilas", "Lirotal norte cheio de encantos...", R.drawable.praia_de_maracaipe, ilhas)


        /*Load Parques Aquáticos*/
        var parquesAquaticos = arrayListOf<Beach>()
        parquesAquaticos.add(0, Beach("Veneza Water Park", "Veneza Water Park...", R.drawable.coroa_do_aviao))
        parquesAquaticos.add(1, Beach("Coqueiral Park", "Coqueiral Park...", R.drawable.coroa_do_aviao))
        parquesAquaticos.add(2, Beach("Aldeia Water Park", "Aldeia Water Park...", R.drawable.coroa_do_aviao))
        var ParqueAquatico = Coast("Parques Aquaticos", "Lirotal norte cheio de encantos...", R.drawable.coroa_do_aviao, parquesAquaticos)


        /*Load Home*/
        litoralList.add(0, litoralNorte)
        litoralList.add(1, litoralSul)
        litoralList.add(2, piscinaNatural)
        litoralList.add(3, ilha)
        litoralList.add(4, ParqueAquatico)

    }




}