package br.com.praiamar.views.activities

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.praiamar.R
import kotlinx.android.synthetic.main.activity_beach_details.*

class BeachDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beach_details)

        beachDetailNameTxtView.text = intent.getStringExtra("beachName")
        beachDetailDescriptionTxtView.text = intent.getStringExtra("beachDescription")
        beachDetailsImageView.setImageResource(intent.getIntExtra("beachImage", 0))


        hoteisButton.setOnClickListener{
            val intent  = Intent(Intent.ACTION_WEB_SEARCH)
            intent.putExtra(SearchManager.QUERY, "Hotéis em ${beachDetailNameTxtView.text}")
            openIntent(intent)
        }

        restaurantesButton.setOnClickListener{
            val intent  = Intent(Intent.ACTION_WEB_SEARCH)
            intent.putExtra(SearchManager.QUERY, "Restaurantes em ${beachDetailNameTxtView.text}")
            openIntent(intent)
        }

    }

    private fun openIntent(intent: Intent){
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }else {
            Toast.makeText(this,"Ocorreu um erro interno." , Toast.LENGTH_LONG).show()
        }
    }
}