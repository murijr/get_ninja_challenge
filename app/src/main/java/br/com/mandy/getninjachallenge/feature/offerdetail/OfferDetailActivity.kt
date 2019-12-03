package br.com.mandy.getninjachallenge.feature.offerdetail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.mandy.getninjachallenge.R

class OfferDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_offer_detail)
    }

    companion object {
        fun startActivity(context: Context) {
            val intent = Intent(context, OfferDetailActivity::class.java)
            context.startActivity(intent)
        }
    }
}
