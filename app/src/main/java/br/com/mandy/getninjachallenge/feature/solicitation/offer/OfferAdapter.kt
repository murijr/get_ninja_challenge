package br.com.mandy.getninjachallenge.feature.solicitation.offer

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.mandy.getninjachallenge.R
import br.com.mandy.getninjachallenge.data.entity.Offer
import br.com.mandy.getninjachallenge.data.entity.Offers
import kotlinx.android.synthetic.main.layout_offers_item.view.*

class OfferAdapter: RecyclerView.Adapter<OfferAdapter.ViewHolder>() {

    private var data: List<Offer>? = null

    fun updateData(offers: Offers) {
        this.data = offers.offers
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = ViewHolder(LayoutInflater.from(parent.context)
        .inflate(R.layout.layout_offers_item, parent, false))

    override fun getItemCount() = data?.size ?: 0

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        data?.let {
            it[position].let { offer ->
                holder.itemView.title.text = offer.embedded?.request?.title
                holder.itemView.name.text = offer.embedded?.request?.embedded?.user?.name
                holder.itemView.title.text = offer.embedded?.request?.title
                offer.embedded?.request?.embedded?.address?.let { address ->
                    holder.itemView.address.text = "${address.neighborhood} - ${address.city}"
                }
            }
        }
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view)
}