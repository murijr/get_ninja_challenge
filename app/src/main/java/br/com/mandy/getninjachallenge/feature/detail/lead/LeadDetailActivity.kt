package br.com.mandy.getninjachallenge.feature.detail.lead

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.mandy.getninjachallenge.R
import br.com.mandy.getninjachallenge.common.ExternalCall
import br.com.mandy.getninjachallenge.data.entity.leaddetail.Address
import br.com.mandy.getninjachallenge.data.entity.leaddetail.Info
import br.com.mandy.getninjachallenge.data.entity.leaddetail.LeadDetail
import br.com.mandy.getninjachallenge.data.entity.leaddetail.User
import br.com.mandy.getninjachallenge.data.entity.leads.Lead
import kotlinx.android.synthetic.main.activity_lead_detail.*
import kotlinx.android.synthetic.main.activity_offer_detail.btn_call
import kotlinx.android.synthetic.main.activity_offer_detail.offer_address
import kotlinx.android.synthetic.main.activity_offer_detail.offer_detail_email
import kotlinx.android.synthetic.main.activity_offer_detail.offer_detail_list
import kotlinx.android.synthetic.main.activity_offer_detail.offer_detail_tel
import kotlinx.android.synthetic.main.activity_offer_detail.offer_distance
import kotlinx.android.synthetic.main.activity_offer_detail.offer_map
import kotlinx.android.synthetic.main.activity_offer_detail.offer_name
import kotlinx.android.synthetic.main.activity_offer_detail.offer_title
import org.koin.android.ext.android.inject


class LeadDetailActivity : AppCompatActivity(), LeadDetailContract.View {

    private val presenter: LeadDetailContract.Presenter by inject()
    private val adapter: LeadDetailInfoValueAdapter by inject()
    private val externalCall: ExternalCall by inject()

    private val leadDetailURL: String by lazy {
        this.intent.getStringExtra(EXTRA_OFFER_DETAIL_URL)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lead_detail)
        setup()
    }

    private fun setup() {
        configureAdapter()
        presenter.takeView(this)
        presenter.getLeadDetail(leadDetailURL)
        handleUI()
    }

    private fun handleUI() {
        handleOnClickDialBtn()
        handleOnClickWhatsAppBtn()
    }

    private fun handleOnClickDialBtn() {
        btn_call.setOnClickListener { externalCall.performPhoneCall(offer_detail_tel.text.toString()) }
    }

    private fun handleOnClickWhatsAppBtn() {
        btn_whatsapp.setOnClickListener { externalCall.sendMessageWithWhatsApp(offer_detail_tel.text.toString()) }
    }

    private fun configureAdapter() {
        offer_detail_list.isNestedScrollingEnabled = false
        offer_detail_list.adapter = adapter
        offer_detail_list.layoutManager = LinearLayoutManager(this)
    }

    override fun showLeadDetail(leadDetail: LeadDetail) {
        displayTitle(leadDetail.title)
        displayName(leadDetail.embedded?.user?.name)
        displayAddress(leadDetail.embedded?.address)
        displayOfferInfo(leadDetail.embedded?.info)
        displayUserInfo(leadDetail.embedded?.user)
    }

    private fun displayUserInfo(user: User?) {
        offer_detail_email.text = user?.email
        offer_detail_tel.text = user?.embedded?.phones?.first()?.number
    }

    override fun showLeadMap(map: Bitmap) {
        runOnUiThread { offer_map.setImageBitmap(map) }
    }

    override fun showLeadDistance(distance: String) {
        runOnUiThread { offer_distance.text = String.format(getString(R.string.text_distance_km), distance) }
    }

    private fun displayTitle(title: String?) {
        offer_title.text = title
    }

    private fun displayAddress(address: Address?) {
        offer_address.text = String.format(getString(R.string.text_address), address?.neighborhood, address?.city)
    }

    private fun displayName(name: String?) {
        offer_name.text = name
    }

    private fun displayOfferInfo(info: List<Info>?) {
        adapter.updateData(info.orEmpty(), true)
    }

    companion object {
        private const val EXTRA_OFFER_DETAIL_URL = "EXTRA_OFFER_DETAIL_URL"
        fun startActivity(context: Context, lead: Lead) {
            val intent = Intent(context, LeadDetailActivity::class.java)
            intent.putExtra(EXTRA_OFFER_DETAIL_URL, lead.links?.self?.href)
            context.startActivity(intent)
        }
    }
}
