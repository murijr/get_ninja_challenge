package br.com.mandy.getninjachallenge.feature.solicitation.lead

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.mandy.getninjachallenge.R
import br.com.mandy.getninjachallenge.data.entity.leads.Leads
import br.com.mandy.getninjachallenge.feature.detail.lead.LeadDetailActivity
import kotlinx.android.synthetic.main.fragment_solicitation_accepted.*
import kotlinx.android.synthetic.main.fragment_solicitation_offers.*
import org.koin.android.ext.android.inject

class LeadFragment : Fragment(), LeadContract.View {

    private val presenter: LeadContract.Presenter by inject()
    private val adapter: LeadAdapter by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_solicitation_accepted, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }

    private fun handleUI() {
        observeClickListItem()
    }

    private fun observeClickListItem() {
        adapter.setOnClick { lead ->
            this.context?.let { LeadDetailActivity.startActivity(it, lead) }
        }
    }

    private fun setup() {
        configureAdapter()
        presenter.takeView(this)
        presenter.getLeads()
        handleUI()
    }

    private fun configureAdapter() {
        lead_list.layoutManager = LinearLayoutManager(this.context)
        lead_list.adapter = adapter
    }

    override fun showLeads(leads: Leads) {
        adapter.updateData(leads)
    }
}