package br.com.praiamar.views.activities

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.praiamar.R
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)


        aboutNameTxtView.text = intent.getStringExtra("aboutName")
        aboutDescriptionTxtView.text = intent.getStringExtra("aboutDescription")
        aboutImageView.setImageResource(intent.getIntExtra("aboutImage", 0))

        instagramImageButton.setImageResource(R.drawable.instagram)
        facebookImageButton.setImageResource(R.drawable.facebook)
        twitterImageButton.setImageResource(R.drawable.twitter)


        instagramImageButton.setOnClickListener{
            val intent  = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/praiamaroficial/"))
            openIntent(intent)
        }

        facebookImageButton.setOnClickListener{
            val intent  = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/praiamaroficial/"))
            openIntent(intent)
        }

        twitterImageButton.setOnClickListener{
            val intent  = Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/praiamaroficial"))
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