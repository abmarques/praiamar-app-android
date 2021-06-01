package br.com.praiamar.views.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import br.com.praiamar.R
import br.com.praiamar.adapters.BeachAdapter
import br.com.praiamar.adapters.OnBeachItemClickListener
import br.com.praiamar.models.Beach
import kotlinx.android.synthetic.main.activity_coast.*

class CoastActivity : AppCompatActivity(), OnBeachItemClickListener {

    private var beachList = arrayListOf<Beach>()
    private var adapter = BeachAdapter(beachList, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coast)

        var intentBeachList = intent.getParcelableArrayListExtra<Beach>("praias") as ArrayList<Beach>
        beachList.addAll(intentBeachList)

        initRecyclerView()

    }

    private fun initRecyclerView() {
        beachRecyclerView.adapter = adapter
        adapter.notifyDataSetChanged()

        val layoutManager = GridLayoutManager(this, 1)
        beachRecyclerView.layoutManager = layoutManager
    }

    override fun onItemClick(item: Beach, position: Int) {
        var intent = Intent(this, BeachDetailsActivity::class.java)
        intent.putExtra("beachName", item.Nome)
        intent.putExtra("beachDescription", item.Descricao)
        intent.putExtra("beachImage", item.LargeImagem)
        intent.putExtra("beachLatitude", item.Latitude)
        intent.putExtra("beachLongitude", item.Longitude)

        startActivity(intent)
    }
}