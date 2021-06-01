package br.com.praiamar.views.activities

import android.app.SearchManager
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import br.com.praiamar.R
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.android.synthetic.main.activity_beach_details.*

class BeachDetailsActivity : AppCompatActivity() {

    lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private var beachLatitude : Double = 0.0
    private var beachLongitude : Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beach_details)

        beachDetailNameTxtView.text = intent.getStringExtra("beachName")
        beachDetailDescriptionTxtView.text = intent.getStringExtra("beachDescription")
        beachDetailsImageView.setImageResource(intent.getIntExtra("beachImage", 0))
        beachLatitude = intent.getDoubleExtra("beachLatitude", 0.0)
        beachLongitude = intent.getDoubleExtra("beachLongitude", 0.0)

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

        comoChegarButton.setOnClickListener{
            fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
            fetchLocation()

            val intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("geo:${beachLatitude},${beachLongitude}"))
            var chooser = Intent.createChooser(intent, "Launch Maps")
            startActivity(chooser)
        }




    }

    private fun fetchLocation() {
        val task = fusedLocationProviderClient.lastLocation

        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)
            != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 101)
            return
        }
        task.addOnSuccessListener {
            if(it != null) {
                Toast.makeText(applicationContext, "${it.latitude}, ${it.longitude}", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun openIntent(intent: Intent){
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }else {
            Toast.makeText(this,"Ocorreu um erro interno." , Toast.LENGTH_SHORT).show()
        }
    }
}