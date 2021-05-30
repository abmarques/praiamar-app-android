package br.com.praiamar.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.praiamar.R
import kotlinx.android.synthetic.main.activity_beach_details.*

class BeachDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beach_details)

        beachDetailNameTxtView.text = intent.getStringExtra("beachName")
        beachDetailDescriptionTxtView.text = intent.getStringExtra("beachDescription")
        beachDetailsImageView.setImageResource(intent.getIntExtra("beachImage", 0))

    }
}