package br.com.mandy.getninjachallenge.feature.solicitation.offer

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.mandy.getninjachallenge.R
import br.com.mandy.getninjachallenge.common.DATE_FORMAT_OFFER
import br.com.mandy.getninjachallenge.data.entity.offers.Offer
import br.com.mandy.getninjachallenge.data.entity.offers.Offers
import kotlinx.android.synthetic.main.layout_offers_item.view.*
import java.text.SimpleDateFormat
import java.util.*

class OfferAdapter: RecyclerView.Adapter<OfferAdapter.ViewHolder>() {

    private var data: List<Offer>? = null

    private var onClickCallback: ((offer: Offer) -> Unit)? = null

    fun updateData(offers: Offers) {
        this.data = offers.offers
        notifyDataSetChanged()
    }

    fun setOnClick(onClick: (offer: Offer) -> Unit) {
        this.onClickCallback = onClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = ViewHolder(LayoutInflater.from(parent.context)
        .inflate(R.layout.layout_offers_item, parent, false))

    override fun getItemCount() = data?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        data?.let {
            it[position].let { offer ->
                renderTitle(offer, holder)
                renderUserName(offer, holder)
                renderCreatedAt(offer, holder)
                renderAddress(offer, holder)
                renderIcons(offer, holder)
                handleOnClick(offer, holder)
            }
        }
    }

    private fun handleOnClick(offer: Offer, holder: ViewHolder) {
        holder.itemView.card.setOnClickListener {
            onClickCallback?.invoke(offer)
        }
    }

    private fun renderTitle(offer: Offer, holder: ViewHolder) {
        holder.itemView.title.text = offer.embedded?.request?.title
    }

    private fun renderUserName(offer: Offer, holder: ViewHolder) {
        holder.itemView.name.text = offer.embedded?.request?.embedded?.user?.name
    }

    private fun renderCreatedAt(offer: Offer, holder: ViewHolder) {
        offer.embedded?.request?.createdAt?.let { date ->
            holder.itemView.create_at.text =
                SimpleDateFormat(DATE_FORMAT_OFFER, Locale.getDefault()).format(date)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun renderAddress(offer: Offer, holder: ViewHolder) {
        offer.embedded?.request?.embedded?.address?.let { address ->
            holder.itemView.address.text = "${address.neighborhood} - ${address.city}"
        }
    }

    private fun renderIcons(offer: Offer, holder: ViewHolder) {
        if(offer.state == "read") {
            holder.itemView.icon_name.setImageResource(R.drawable.ic_person_read_24dp)
            holder.itemView.icon_created_at.setImageResource(R.drawable.ic_person_read_24dp)
            holder.itemView.icon_place.setImageResource(R.drawable.ic_place_read_24dp)
        } else {
            holder.itemView.icon_name.setImageResource(R.drawable.ic_person_unread_24dp)
            holder.itemView.icon_created_at.setImageResource(R.drawable.ic_person_unread_24dp)
            holder.itemView.icon_place.setImageResource(R.drawable.ic_place_unread_24dp)
        }
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view)
}