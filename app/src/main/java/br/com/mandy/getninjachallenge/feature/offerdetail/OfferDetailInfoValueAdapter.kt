package br.com.mandy.getninjachallenge.feature.offerdetail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.mandy.getninjachallenge.R
import br.com.mandy.getninjachallenge.data.entity.offerdetail.Info
import br.com.mandy.getninjachallenge.data.entity.offers.Offer
import kotlinx.android.synthetic.main.layout_offer_detail_info_item.view.*
import kotlinx.android.synthetic.main.layout_offers_item.view.*

class OfferDetailInfoValueAdapter: RecyclerView.Adapter<OfferDetailInfoValueAdapter.ViewHolder>() {

    private var data: List<Info>? = null

    private var onClickCallback: ((offer: Offer) -> Unit)? = null

    fun updateData(offerDetailInfo: List<Info>) {
        this.data = offerDetailInfo
        notifyDataSetChanged()
    }

    fun setOnClick(onClick: (offer: Offer) -> Unit) {
        this.onClickCallback = onClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_offer_detail_info_item, parent, false))

    override fun getItemCount() = data?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        data?.get(position)?.let {
            if(it.value?.size == 1) {
                holder.itemView.offer_info_answer.text = it.value?.first()
                holder.itemView.offer_info_question.text = it.label
            }
        }
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view)
}