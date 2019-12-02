package br.com.mandy.getninjachallenge.feature.solicitation.offer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.mandy.getninjachallenge.R
import br.com.mandy.getninjachallenge.data.entity.Offers
import org.koin.android.ext.android.inject

class OfferFragment : Fragment(), OfferContract.View {

    private val presenter: OfferContract.Presenter by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        handleFragmentStart()
        return inflater.inflate(R.layout.fragment_solicitation_offers, container, false)
    }

    private fun handleFragmentStart() {
        presenter.takeView(this)
        presenter.getOffers()
    }

    override fun showOffers(offers: Offers) {
        return
    }
}