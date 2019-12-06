package br.com.mandy.getninjachallenge.feature.detail.offer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.mandy.getninjachallenge.R
import br.com.mandy.getninjachallenge.data.entity.offerdetail.Info
import kotlinx.android.synthetic.main.layout_offer_detail_info_item.view.*

class OfferDetailInfoValueAdapter: RecyclerView.Adapter<OfferDetailInfoValueAdapter.ViewHolder>() {

    private var data: List<Info>? = null

    private var offerAccepted: Boolean = false

    fun updateData(offerDetailInfo: List<Info>, offerAccepted: Boolean = false) {
        this.data = offerDetailInfo
        this.offerAccepted = offerAccepted
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_offer_detail_info_item, parent, false))

    override fun getItemCount() = data?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        data?.get(position)?.let {
            holder.itemView.offer_info_question.text = it.label
            holder.itemView.offer_info_answer.text = it.value?.joinToString()
        }
        if(offerAccepted) {
            holder.itemView.imageView.setImageDrawable(
                holder.itemView.context.getDrawable(R.drawable.ic_info_green_24dp))
        }
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view)
}