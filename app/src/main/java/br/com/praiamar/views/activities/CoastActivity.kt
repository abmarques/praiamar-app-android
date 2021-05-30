package br.com.praiamar.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import br.com.praiamar.R
import br.com.praiamar.adapters.BeachAdapter
import br.com.praiamar.models.Beach
import kotlinx.android.synthetic.main.activity_coast.*

class CoastActivity : AppCompatActivity() {

    private var beachList = arrayListOf<Beach>()
    private var adapter = BeachAdapter(beachList)

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
}