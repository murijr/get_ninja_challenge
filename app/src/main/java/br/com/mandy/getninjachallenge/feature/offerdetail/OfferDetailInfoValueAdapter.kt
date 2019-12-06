package br.com.mandy.getninjachallenge.feature.offerdetail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.mandy.getninjachallenge.R
import br.com.mandy.getninjachallenge.data.entity.offerdetail.Info
import br.com.mandy.getninjachallenge.data.entity.offers.Offer
import kotlinx.android.synthetic.main.layout_offers_item.view.*

class OfferDetailInfoValueAdapter: RecyclerView.Adapter<OfferDetailInfoValueAdapter.ViewHolder>() {

    private var data: Info? = null

    private var onClickCallback: ((offer: Offer) -> Unit)? = null

    fun updateData(offerDetailInfo: Info) {
        this.data = offerDetailInfo
        notifyDataSetChanged()
    }

    fun setOnClick(onClick: (offer: Offer) -> Unit) {
        this.onClickCallback = onClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_offers_item, parent, false))

    override fun getItemCount() = data?.value?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        data?.let {
        }
    }

    private fun handleOnClick(offer: Offer, holder: ViewHolder) {
        holder.itemView.card.setOnClickListener {
            onClickCallback?.invoke(offer)
        }
    }

    private fun renderTitle(offer: Offer, holder: ViewHolder) {
        holder.itemView.offer_title.text = offer.embedded?.request?.title
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view)
}