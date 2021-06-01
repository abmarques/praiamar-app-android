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

        if(litoralList[position].Nome.equals("Sobre Praiamar")){
            var item = litoralList[position].beaches[0]

            var intent = Intent(this, AboutActivity::class.java)
            intent.putExtra("aboutName", item.Nome)
            intent.putExtra("aboutDescription", item.Descricao)
            intent.putExtra("aboutImage", item.LargeImagem)
            startActivity(intent)

        }else {
            val intent = Intent(this, CoastActivity::class.java)
            intent.putParcelableArrayListExtra("praias", litoralList[position].beaches)
            startActivity(intent)
        }
    }

    private fun loadHomeDataList() {

        /*Litoral Norte*/

        var praiasLitoralNorte = arrayListOf<Beach>()

        praiasLitoralNorte.add(0,
            Beach(
                getString(R.string.calhetas_beach_name),
                getString(R.string.calhetas_beach_preview),
                getString(R.string.calhetas_beach_description),
                R.drawable.calhetas_beach_small,
                R.drawable.calhetas_beach_large,
                -8.344918735456245, -34.94364225506918
            ))

        praiasLitoralNorte.add(1,
            Beach(
                getString(R.string.boa_viagem_beach_name),
                getString(R.string.boa_viagem_beach_preview),
                getString(R.string.boa_viagem_beach_description),
                R.drawable.boa_viagem_beach_small,
                R.drawable.boa_viagem_beach_large,
                -8.115925725985395, -34.8929490516586
            ))

        praiasLitoralNorte.add(2,
            Beach(
                getString(R.string.forte_orange_beach_name),
                getString(R.string.forte_orange_beach_preview),
                getString(R.string.forte_orange_beach_description),
                R.drawable.forte_orange_beach_small,
                R.drawable.forte_orange_beach_large,
                -7.810397796406493, -34.83922402201031
            ))

        praiasLitoralNorte.add(3,
            Beach(
                getString(R.string.janga_beach_name),
                getString(R.string.janga_beach_preview),
                getString(R.string.janga_beach_description),
                R.drawable.janga_beach_small,
                R.drawable.janga_beach_large,
                -7.950502605235106, -34.82678426640757
            ))

        var litoralNorte = Coast(getString(R.string.north_coast_name), getString(R.string.north_coast_preview), R.drawable.calhetas_beach_small, praiasLitoralNorte)

        /* ------------------------------------------------------------------------------------------------------------------------------------------------------------ */

        /*Litoral Sul*/

        var praiasLitoralSul = arrayListOf<Beach>()

        praiasLitoralSul.add(0,
            Beach(
                getString(R.string.porto_de_galinhas_beach_name),
                getString(R.string.porto_de_galinhas_beach_preview),
                getString(R.string.porto_de_galinhas_beach_description),
                R.drawable.porto_de_galinhas_beach_small,
                R.drawable.porto_de_galinhas_beach_large,
                -8.483941092484008, -34.99992801026139
            ))

        praiasLitoralSul.add(1,
            Beach(
                getString(R.string.maracaipe_beach_name),
                getString(R.string.maracaipe_beach_preview),
                getString(R.string.maracaipe_beach_description),
                R.drawable.maracaipe_beach_small,
                R.drawable.maracaipe_beach_large,
                -8.524871252898068, -35.00709598638189
            ))

        praiasLitoralSul.add(2,
            Beach(
                getString(R.string.muro_alto_beach_name),
                getString(R.string.muro_alto_beach_preview),
                getString(R.string.muro_alto_beach_description),
                R.drawable.muro_alto_beach_small,
                R.drawable.muro_alto_beach_large,
                -8.429079345209257, -34.978324918515874

            ))

        praiasLitoralSul.add(3,
            Beach(
                getString(R.string.carneiros_beach_name),
                getString(R.string.carneiros_beach_preview),
                getString(R.string.carneiros_beach_description),
                R.drawable.carneiros_beach_small,
                R.drawable.carneiros_beach_large,
                -8.703318767277732, -35.079611919059694
            ))

        var litoralSul = Coast(getString(R.string.south_coast_name), getString(R.string.south_coast_preview), R.drawable.porto_de_galinhas_beach_small, praiasLitoralSul)

        /* ------------------------------------------------------------------------------------------------------------------------------------------------------------ */

        /*Piscinas Naturais*/

        var piscinasNaturais = arrayListOf<Beach>()

        piscinasNaturais.add(0,
            Beach(
                getString(R.string.porto_de_galinhas_natural_pools_name),
                getString(R.string.porto_de_galinhas_natural_pools_preview),
                getString(R.string.porto_de_galinhas_natural_pools_description),
                R.drawable.porto_de_galinhas_natural_pool_small,
                R.drawable.porto_de_galinhas_natural_pool_large,
                -8.508747562269358, -35.00042788706182
            ))

        piscinasNaturais.add(1,
            Beach(
                getString(R.string.muro_alto_natural_pools_name),
                getString(R.string.muro_alto_natural_pools_preview),
                getString(R.string.muro_alto_natural_pools_description),
                R.drawable.muro_alto_natural_pool_small,
                R.drawable.muro_alto_natural_pool_large,
                -8.42877177731615, -34.97876897302474
            ))

        piscinasNaturais.add(2,
            Beach(
                getString(R.string.carneiros_beach_natural_pools_name),
                getString(R.string.carneiros_beach_natural_pools_preview),
                getString(R.string.carneiros_beach_natural_pools_description),
                R.drawable.carneiros_beach_natural_pool_small,
                R.drawable.carneiros_beach_natural_pool_large,
                -8.70325513550453, -35.07955827488061
            ))

        piscinasNaturais.add(3,
            Beach(
                getString(R.string.noronha_beach_natural_pools_name),
                getString(R.string.noronha_beach_natural_pools_preview),
                getString(R.string.noronha_beach_natural_pools_description),
                R.drawable.fernando_de_noronha_beach_natural_pool_small,
                R.drawable.fernando_de_noronha_beach_natural_pool_large,
                -3.850895573181236, -32.44148045191121
            ))

        var piscinaNatural = Coast(getString(R.string.natural_pools_name), getString(R.string.natural_pools_preview), R.drawable.fernando_de_noronha_beach_natural_pool_small, piscinasNaturais)

        /* ------------------------------------------------------------------------------------------------------------------------------------------------------------ */

        /*Ilhas*/

        var ilhas = arrayListOf<Beach>()

        ilhas.add(0,
            Beach(
                getString(R.string.noronha_island_name),
                getString(R.string.noronha_island_preview),
                getString(R.string.noronha_island_description),
                R.drawable.fernando_de_noronha_island_small,
                R.drawable.fernando_de_noronha_island_large,
                -3.854241712582797, -32.42959952739866
            ))
        ilhas.add(1,
            Beach(
                getString(R.string.coroa_do_aviao_island_name),
                getString(R.string.coroa_do_aviao_island_preview),
                getString(R.string.coroa_do_aviao_island_description),
                R.drawable.coroa_do_aviao_island_small,
                R.drawable.coroa_do_aviao_island_large,
                -7.822405295240844, -34.83777679053909
            ))
        ilhas.add(2,
            Beach(
                getString(R.string.itamaraca_island_name),
                getString(R.string.itamaraca_island_preview),
                getString(R.string.itamaraca_island_description),
                R.drawable.itamaraca_beach_small,
                R.drawable.itamaraca_beach_large,
                -7.755147862132027, -34.82374867654983
            ))

        ilhas.add(3,
            Beach(
                getString(R.string.santo_aleixo_island_name),
                getString(R.string.santo_aleixo_island_preview),
                getString(R.string.santo_aleixo_island_description),
                R.drawable.santo_aleixo_island_small,
                R.drawable.santo_aleixo_island_large,
                -8.61188581786504, -35.02286927271236
            ))

        var ilha = Coast(getString(R.string.islands_name), getString(R.string.islands_preview), R.drawable.fernando_de_noronha_island_small, ilhas)

        /* ------------------------------------------------------------------------------------------------------------------------------------------------------------ */

        /*Parques Aquáticos*/

        var parquesAquaticos = arrayListOf<Beach>()

        parquesAquaticos.add(0,
            Beach(
                getString(R.string.veneza_water_park_name),
                getString(R.string.veneza_water_park_preview),
                getString(R.string.veneza_water_park_description),
                R.drawable.veneza_water_park_small,
                R.drawable.veneza_water_park_large,
                -7.869952005362016, -34.83568588838098
            ))

        parquesAquaticos.add(1,
            Beach(
                getString(R.string.sundown_park_name),
                getString(R.string.sundown_park_preview),
                getString(R.string.sundown_park_description),
                R.drawable.sundown_water_park_small,
                R.drawable.sundown_water_park_large,
                -8.949504396378792, -36.70082353368535
            ))

        parquesAquaticos.add(2,
            Beach(
                getString(R.string.aguas_finas_name),
                getString(R.string.aguas_finas_preview),
                getString(R.string.aguas_finas_description),
                R.drawable.aguas_finas_water_park_small,
                R.drawable.aguas_finas_water_park_large,
                -7.9103308210490955, -35.04930157488802

            ))

        parquesAquaticos.add(3,
            Beach(
                getString(R.string.aldeia_water_park_name),
                getString(R.string.aldeia_water_park_preview),
                getString(R.string.aldeia_water_park_description),
                R.drawable.aldeia_water_park_small,
                R.drawable.aldeia_water_park_large,
                -7.934307733012818, -35.02923471906694
            ))

        var ParqueAquatico = Coast(getString(R.string.water_parks_name), getString(R.string.water_parks_preview), R.drawable.veneza_water_park_small, parquesAquaticos)

        /* ------------------------------------------------------------------------------------------------------------------------------------------------------------ */

        var aboutInfo = arrayListOf<Beach>()
        aboutInfo.add(0,
            Beach(
                getString(R.string.about_praiamar_name),
                getString(R.string.about_praiamar_preview),
                getString(R.string.about_praiamar_description),
                R.drawable.praiamar_logo_small,
                R.drawable.praiamar_logo_large,
                -8.063131166302218, -34.87112437305809
            ))

        var about = Coast(getString(R.string.about_praiamar_name), getString(R.string.about_praiamar_preview), R.drawable.praiamar_logo_small, aboutInfo)

        /*Home*/
        litoralList.add(0, litoralNorte)
        litoralList.add(1, litoralSul)
        litoralList.add(2, piscinaNatural)
        litoralList.add(3, ilha)
        litoralList.add(4, ParqueAquatico)
        litoralList.add(5, about)
    }

}