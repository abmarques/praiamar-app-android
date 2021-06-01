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
                "Praia de Calhetas",
                "Essa é uma das praias mais bonitas do Brasil. A Praia...",
                "Essa é uma das praias mais bonitas do Brasil. A Praia de Calhetas, localizada no município de Santo Agostinho, está sempre cheia de turistas. Na região, prepare-se para encontrar águas cristalinas e calmas, vegetação e opções de práticas esportivas. Além de um mar calmo, que favorece mergulho, na região você pode ainda fazer trilhas, tirolesa, ou apenas curtir a paisagem.",
                R.drawable.calhetas_beach_small,
                R.drawable.calhetas_beach_large,
                -8.344918735456245, -34.94364225506918
            ))

        praiasLitoralNorte.add(1,
            Beach(
                "Praia de Boa Viagem",
                "Entre as praias turísticas de Pernambuco, essa é uma...",
                "Entre as praias turísticas de Pernambuco, essa é uma das mais populares de Recife. Com muitos coqueiros ao seu redor, a Praia dde Boa Viagem possui uma longa faixa de areia e um mar de cor esverdeada. A boa notícia é que há muitos quiosques e barracas na orla, que vendem porções e drinks bem gostosos. Não deixe de tomar um banho de mar, pois as águas são tranquilas e com temperaturas agradáveis.",
                R.drawable.boa_viagem_beach_small,
                R.drawable.boa_viagem_beach_large,
                -8.115925725985395, -34.8929490516586
            ))

        praiasLitoralNorte.add(2,
            Beach(
                "Praia do Forte Orange",
                "Situada na Ilha de Itamaracá, a Praia do Forte Orange...",
                "Situada na Ilha de Itamaracá, a Praia do Forte Orange é perfeita para quem quer aproveitar um clima animado e descontraído. Além de ser dona de paisagens tropicais belíssimas, ela oferece esportes aquáticos, como mergulho e stand-up paddle. As águas tranquilas e agradáveis tornam o banho de mar ainda mais delicioso.",
                R.drawable.forte_orange_beach_small,
                R.drawable.forte_orange_beach_large,
                -7.810397796406493, -34.83922402201031
            ))

        praiasLitoralNorte.add(3,
            Beach(
                "Praia do Janga",
                "A Praia do Janga está localizada na área mais urbana...",
                "A Praia do Janga está localizada na área mais urbana de Recife. No local, você encontrará uma extensa faixa de areia, perfeita para caminhadas. O mar é calmo e as águas são transparentes, o que favorece um delicioso banho de mar. É possível praticar esportes aquáticos, como caiaque e jet ski. A região não é muito movimentada, garantindo momentos de maior tranquilidade.",
                R.drawable.janga_beach_small,
                R.drawable.janga_beach_large,
                -7.950502605235106, -34.82678426640757
            ))

        var litoralNorte = Coast("Litoral Norte", "Lirotal norte cheio de encantos...", R.drawable.calhetas_beach_small, praiasLitoralNorte)

        /* ------------------------------------------------------------------------------------------------------------------------------------------------------------ */

        /*Litoral Sul*/

        var praiasLitoralSul = arrayListOf<Beach>()

        praiasLitoralSul.add(0,
            Beach("Praia de Porto de Galinhas",
                "Na hora de escolher as praias de Pernambuco, litoral sul...",
                "Na hora de escolher as praias de Pernambuco, litoral sul, com certeza, Porto de Galinhas não pode faltar no seu roteiro. Nessa região, as praias são belíssimas e contornadas por coqueiros, mar azul e águas transparentes. A praia que leva o nome do distrito é dona dos cenários mais incríveis da região sul. Não deixe de mergulhar para observar peixes de espécies variadas e recifes de corais!",

                R.drawable.porto_de_galinhas_beach_small,
                R.drawable.porto_de_galinhas_beach_large,
                -8.483941092484008, -34.99992801026139
            ))

        praiasLitoralSul.add(1,
            Beach("Praia de Maracaípe",
                "Você ficará encantado com a Praia de Maracaípe. Bem longe...",
                "Você ficará encantado com a Praia de Maracaípe. Bem longe da área urbana, a região garante as paisagens mais bonitas de Pernambuco. A praia possui uma ampla faixa de areia branquinha e fofa, perfeita para quem gosta de fazer uma caminhada e admirar o cenário. Nessa região, o mar é agitado e atrai muitos surfistas.",
                R.drawable.maracaipe_beach_small,
                R.drawable.maracaipe_beach_large,
                -8.524871252898068, -35.00709598638189
            ))

        praiasLitoralSul.add(2,
            Beach("Praia de Muro Alto",
                "Também no distrito de Porto de Galinhas, a Praia de Muro...",
                "Também no distrito de Porto de Galinhas, a Praia de Muro Alto possui falésias de 3 metros, que formam lindos paredões em toda a sua orla. Os arrecifes também são destaques na paisagem, e formam piscinas naturais de águas calmas e quentinhas. Em um trecho da praia, é possível andar de jet ski. Para curtir toda a região, alugue um buggy e faça também um passeio pelas areias brancas e fofas.",
                R.drawable.muro_alto_beach_small,
                R.drawable.muro_alto_beach_large,
                -8.429079345209257, -34.978324918515874

            ))

        praiasLitoralSul.add(3,
            Beach("Praia de Carneiros",
                "Localizada na cidade de Tamandaré, Carneiros é uma das praias...",
                "Localizada na cidade de Tamandaré, Carneiros é uma das praias mais bonitas do estado. Cercada por coqueiros e com um mar de águas cristalinas, ela ainda é muito charmosa e histórica. Não deixe de curtir a praia, mas aproveite para conhecer a igreja de São Benedito, datada do século XVIII — que é palco de casamentos, inclusive, de famosos. Ela é uma das praias de Pernambuco para lua de mel mais procuradas. ",
                R.drawable.carneiros_beach_small,
                R.drawable.carneiros_beach_large,
                -8.703318767277732, -35.079611919059694
            ))

        var litoralSul = Coast("Litoral Sul", "Na hora de escolher as praias de Pernambuco, litoral sul...", R.drawable.porto_de_galinhas_beach_small, praiasLitoralSul)

        /* ------------------------------------------------------------------------------------------------------------------------------------------------------------ */

        /*Piscinas Naturais*/

        var piscinasNaturais = arrayListOf<Beach>()

        piscinasNaturais.add(0,
            Beach("Piscinas Naturais de Porto de Galinhas",
                "Essa é uma unanimidade brasileira, quando se pensa em piscina...",
                "Essa é uma unanimidade brasileira, quando se pensa em piscina natural já vem logo na nossa mente a praia de porto de galinhas. A praia de Porto de Galinhas fica no Município de Ipojuca e a aproximadamente 49,2 Km do Aeroporto Internacional do Recife. Em cerca de 1 hora saindo da capital você chega nessas, que são uma das 7 maravilhas de Pernambuco, as piscinas naturais de Porto de Galinhas.",
                R.drawable.porto_de_galinhas_natural_pool_small,
                R.drawable.porto_de_galinhas_natural_pool_large,
                -8.508747562269358, -35.00042788706182
            ))

        piscinasNaturais.add(1,
            Beach("Piscinas Naturais de Muro Alto",
                "Do ladinho de Porto de Galinhas, tem a praia de Muro Alto com sua...",
                "Do ladinho de Porto de Galinhas, tem a praia de Muro Alto com sua piscina “gigante”. A praia tem um paredão de corais que chegam a 3km de extensão e por isso forma uma grande piscina. Na maré baixa o visual fica incrível, você pode ir nadando para o paredão de corais ou usando caiaque/ stand up paddle. Também pode fazer um passeio de jangada ou apenas ficar curtindo o mar calmo e cristalino dessa praia",
                R.drawable.muro_alto_natural_pool_small,
                R.drawable.muro_alto_natural_pool_large,
                -8.42877177731615, -34.97876897302474
            ))

        piscinasNaturais.add(2,
            Beach("Piscinas Naturais da Praia dos Carneiros",
                "A Praia dos Carneiros fica no Município de Tamandaré, a 113 Km...",
                "A Praia dos Carneiros fica no Município de Tamandaré, a 113 Km do Recife. Essa praia foi eleita a segunda melhor praia do Brasil, segundo o prêmio do site TripAdvisor, O Traveller´s Choice 2017. Lá você encontra bancos de areias, piscinas naturais, corais, banho de argila medicinal, manguezais e tudo com uma boa infra-estrutura para você curtir seu dia. Você pode explorar a praia caminhando, fazendo passeio de barco, de caiaque, stand up paddle e muito mais.",
                R.drawable.carneiros_beach_natural_pool_small,
                R.drawable.carneiros_beach_natural_pool_large,
                -8.70325513550453, -35.07955827488061
            ))

        piscinasNaturais.add(3,
            Beach("Piscinas Naturais da Baía dos Porcos",
                "As piscinas naturais que encontramos em Fernando de Noronha...",
                "As piscinas naturais que encontramos em Fernando de Noronha, são as mais belas do mundo. A Baía dos Porcos é um dos principais pontos de mergulho na ilha e  na maré mais baixa as piscinas se destacam. Uma água de cor verde/azul, uma riqueza de vida marinha e uma vista mais que privilegiada para o Morro dos dois irmãos. Nas piscinas naturais da Baía dos Porcos podemos ver arraias, tubarões, tartarugas, peixes e corais multicoloridos. Um mergulho lá é inesquecível!",
                R.drawable.fernando_de_noronha_beach_natural_pool_small,
                R.drawable.fernando_de_noronha_beach_natural_pool_large,
                -3.850895573181236, -32.44148045191121
            ))

        var piscinaNatural = Coast("Piscinas Naturais", "Essa é uma unanimidade brasileira, quando se pensa em piscina natural...", R.drawable.fernando_de_noronha_beach_natural_pool_small, piscinasNaturais)

        /* ------------------------------------------------------------------------------------------------------------------------------------------------------------ */

        /*Ilhas*/

        var ilhas = arrayListOf<Beach>()

        ilhas.add(0,
            Beach("Ilha de Fernando de Noronha",
                "Um verdadeiro santuário em território pernambucano. Fernando...",
                "Um verdadeiro santuário em território pernambucano. Fernando de Noronha é um dos arquipélagos mais procurados por turistas que buscam contato com a natureza, paisagens paradisíacas e atividades aquáticas. Para desembarcar na ilha, você precisará pagar taxas de preservação, mas acredite, vale cada centavo o investimento. O arquipélago possui as mais belas praias de Pernambuco. As mais disputadas são as Praias do Sancho, do Cachorro, do Porto, da Conceição, Praia do Boldró, Baía dos Porcos, Baía dos Golfinhos e Praia do Meio.",
                R.drawable.fernando_de_noronha_island_small,
                R.drawable.fernando_de_noronha_island_large,
                -3.854241712582797, -32.42959952739866
            ))
        ilhas.add(1,
            Beach("Ilha da Coroa do Avião",
                "A linda Coroa do Avião fica em uma pequena ilha na região de...",
                "A linda Coroa do Avião fica em uma pequena ilha na região de Itamaracá. Para chegar ao local, você precisará se deslocar de barco até lá. Mas acredite, o local é esplêndido e você vai curtir momentos de relaxamento em meio à natureza. Nessa região, as águas são claras, o vento é agradável e a vegetação da pequena ilha completa o cenário paradisíaco.",
                R.drawable.coroa_do_aviao_island_small,
                R.drawable.coroa_do_aviao_island_large,
                -7.822405295240844, -34.83777679053909
            ))
        ilhas.add(2,
            Beach(
                "Ilha de Itamaracá",
                "Ilha de Itamaracá é perfeita para quem quer aproveitar...",
                "Ilha de Itamaracá é perfeita para quem quer aproveitar um clima animado e descontraído. Além de ser dona de paisagens tropicais belíssimas, ela oferece esportes aquáticos, como mergulho e stand-up paddle. As águas tranquilas e agradáveis tornam o banho de mar ainda mais delicioso.",
                R.drawable.itamaraca_beach_small,
                R.drawable.itamaraca_beach_large,
                -7.755147862132027, -34.82374867654983
            ))

        ilhas.add(3,
            Beach(
                "Ilha de Santo Aleixo",
                "A ilha de Santo Aleixo é uma ilha brasileira localizada...",
                "A ilha de Santo Aleixo é uma ilha brasileira localizada no litoral sul do estado de Pernambuco, região Nordeste do Brasil. Administrativamente faz parte do município de Sirinhaém, embora seja de propriedade particular. Também foi em Santo Aleixo que se passou a primeira invasão francesa no Brasil, a qual durou de março a dezembro de 1531, tendo estes sido expulsos por militares portugueses. Quando da ocupação francesa, a ilha foi denominada -île Saint-Alexis-. Essa invasões, que viriam a se tornar sucessivas, tinham como principal objetivo a coleta de -pau-de-tinta-, como então era conhecido o pau-brasil.",
                R.drawable.santo_aleixo_island_small,
                R.drawable.santo_aleixo_island_large,
                -8.61188581786504, -35.02286927271236
            ))

        var ilha = Coast("Ilhas", "Lirotal norte cheio de encantos...", R.drawable.fernando_de_noronha_island_small, ilhas)

        /* ------------------------------------------------------------------------------------------------------------------------------------------------------------ */

        /*Parques Aquáticos*/

        var parquesAquaticos = arrayListOf<Beach>()

        parquesAquaticos.add(0,
            Beach("Veneza Water Park",
                "Localizado no litoral norte de Pernambuco é sinônimo de.",
                "Localizado no litoral norte de Pernambuco é sinônimo de diversão e alegria numa área de 90.000m², onde estão distribuídas mais de trinta atrações como Toboáguas, Piscina com Ondas artificiais, Rio lento, playgrounds infantis, tirolesa e muito mais.",
                R.drawable.veneza_water_park_small,
                R.drawable.veneza_water_park_large,
                -7.869952005362016, -34.83568588838098
            ))

        parquesAquaticos.add(1,
            Beach("Sundown Park",
                "O Sundown Park e hoje um dos melhores parque aquaticos do Brasil,...",
                "O Sundown Park e hoje um dos melhores parque aquaticos do Brasil, contando uma infra-estrutura de 90.000m² de pura diversao. Sao varias atracoes para toda familia, entre elas, o \"Panico\" que e o 3° maior toboagua do Brasil, e tambem a \"Kionda\", uma fantatica piscina de ondas com quase 3 milhoes de litros d'agua! Lazer e diversao, e so aqui no Sundown Park!",
                R.drawable.sundown_water_park_small,
                R.drawable.sundown_water_park_large,
                -8.949504396378792, -36.70082353368535
            ))

        parquesAquaticos.add(2,
            Beach("Águas Finas Water Park",
                "Passe um dia de lazer em Águas Finas e desfrute de nossas piscinas...",
                "Passe um dia de lazer em Águas Finas e desfrute de nossas piscinas e bicas de água mineral corrente, únicas no País. Se divirta em nossos escorregos e toboáguas, aventure-se em nossas florestas seculares, divirta-se no pesque e pague e se delicie em nosso restaurante temático.",
                R.drawable.aguas_finas_water_park_small,
                R.drawable.aguas_finas_water_park_large,
                -7.9103308210490955, -35.04930157488802

            ))

        parquesAquaticos.add(3,
            Beach("Aldeia Water Park",
                "Temos uma infinidade de opções para tornar os seus dias inesquecíveis...",
                "Temos uma infinidade de opções para tornar os seus dias inesquecíveis. São 17 piscinas, toboáguas, Rio Corrente e Piscina de Ondas. Além disso, dispomos de spa, quadras poliesportivas, campos de futebol society, espaço para esportes radicais e um incrível lago de pesca.",
                R.drawable.aldeia_water_park_small,
                R.drawable.aldeia_water_park_large,
                -7.934307733012818, -35.02923471906694
            ))

        var ParqueAquatico = Coast("Parques Aquaticos", "Lirotal norte cheio de encantos...", R.drawable.veneza_water_park_small, parquesAquaticos)

        /* ------------------------------------------------------------------------------------------------------------------------------------------------------------ */

        var aboutInfo = arrayListOf<Beach>()
        aboutInfo.add(0,
            Beach("Sobre Praiamar",
                "Não fique apenas aqui. Conheça também...",
                "Não fique Apenas aqui. Siga-nos em nossas redes sociais e conheça todo o litoral brasileiro e suas belezas naturais e aproveite o que é seu por natureza.",
                R.drawable.praiamar_logo_small,
                R.drawable.praiamar_logo_large,
                -8.063131166302218, -34.87112437305809
            ))

        var about = Coast("Sobre Praiamar", "Não fique apenas aqui. Conheça também...", R.drawable.praiamar_logo_small, aboutInfo)

        /*Home*/
        litoralList.add(0, litoralNorte)
        litoralList.add(1, litoralSul)
        litoralList.add(2, piscinaNatural)
        litoralList.add(3, ilha)
        litoralList.add(4, ParqueAquatico)
        litoralList.add(5, about)
    }

}