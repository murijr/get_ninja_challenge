package br.com.mandy.getninjachallenge.feature.solicitation.offer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.mandy.getninjachallenge.R
import br.com.mandy.getninjachallenge.data.entity.offers.Offers
import br.com.mandy.getninjachallenge.feature.detail.offer.OfferDetailActivity
import kotlinx.android.synthetic.main.fragment_solicitation_offers.*
import org.koin.android.ext.android.inject

class OfferFragment : Fragment(), OfferContract.View {

    private val presenter: OfferContract.Presenter by inject()
    private val adapter: OfferAdapter by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_solicitation_offers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }

    private fun handleUI() {
        handleClickListItem()
        handleRefreshData()
    }

    private fun handleRefreshData() {
        refresh.setOnRefreshListener {
            presenter.getOffers()
        }
    }

    private fun handleClickListItem() {
        adapter.setOnClick { offer ->
            this.context?.let { OfferDetailActivity.startActivity(it, offer) }
        }
    }

    private fun setup() {
        configureAdapter()
        presenter.takeView(this)
        presenter.getOffers()
        handleUI()
    }

    private fun configureAdapter() {
        offers_list.layoutManager = LinearLayoutManager(this.context)
        offers_list.adapter = adapter
    }

    override fun showOffers(offers: Offers) {
        refresh.isRefreshing = false
        adapter.updateData(offers)
    }
}