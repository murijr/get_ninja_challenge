package br.com.mandy.getninjachallenge.feature.solicitation.lead

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.mandy.getninjachallenge.R
import br.com.mandy.getninjachallenge.common.DATE_FORMAT_OFFER
import br.com.mandy.getninjachallenge.data.entity.leads.Lead
import br.com.mandy.getninjachallenge.data.entity.leads.Leads
import kotlinx.android.synthetic.main.layout_offers_item.view.*
import java.text.SimpleDateFormat
import java.util.*

class LeadAdapter: RecyclerView.Adapter<LeadAdapter.ViewHolder>() {

    private var data: List<Lead>? = null

    private var onClickCallback: ((lead: Lead) -> Unit)? = null

    fun updateData(leads: Leads) {
        this.data = leads.leads
        notifyDataSetChanged()
    }

    fun setOnClick(onClick: (lead: Lead) -> Unit) {
        this.onClickCallback = onClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = ViewHolder(LayoutInflater.from(parent.context)
        .inflate(R.layout.layout_offers_item, parent, false))

    override fun getItemCount() = data?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        data?.let {
            it[position].let { lead ->
                renderTitle(lead, holder)
                renderUserName(lead, holder)
                renderCreatedAt(lead, holder)
                renderAddress(lead, holder)
                renderIcons(lead, holder)
                handleOnClick(lead, holder)
            }
        }
    }

    private fun handleOnClick(lead: Lead, holder: ViewHolder) {
        holder.itemView.card.setOnClickListener {
            onClickCallback?.invoke(lead)
        }
    }

    private fun renderTitle(lead: Lead, holder: ViewHolder) {
        holder.itemView.offer_title.text = lead.embedded?.request?.title
    }

    private fun renderUserName(lead: Lead, holder: ViewHolder) {
        holder.itemView.name.text = lead.embedded?.user?.name
    }

    private fun renderCreatedAt(lead: Lead, holder: ViewHolder) {
        lead.createdAt?.let { date ->
            holder.itemView.create_at.text =
                SimpleDateFormat(DATE_FORMAT_OFFER, Locale.getDefault()).format(date)
        }
    }

    private fun renderAddress(lead: Lead, holder: ViewHolder) {
        lead.embedded?.address?.let { address ->
            holder.itemView.address.text = String.format(
                holder.itemView.context.getString(R.string.text_address), address.neighborhood, address.city)
        }
    }

    private fun renderIcons(lead: Lead, holder: ViewHolder) {
        holder.itemView.icon_name.setImageResource(R.drawable.ic_person_green_24dp)
        holder.itemView.icon_created_at.setImageResource(R.drawable.ic_person_green_24dp)
        holder.itemView.icon_place.setImageResource(R.drawable.ic_place_green_24dp)
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view)
}