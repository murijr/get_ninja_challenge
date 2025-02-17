package br.com.mandy.getninjachallenge.feature.solicitation

import android.content.Context
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import br.com.mandy.getninjachallenge.R
import br.com.mandy.getninjachallenge.feature.solicitation.lead.LeadFragment
import br.com.mandy.getninjachallenge.feature.solicitation.offer.OfferFragment

private val TAB_TITLES = arrayOf(
    R.string.tab_title_text_available,
    R.string.tab_title_text_accepted
)

class SectionsPagerAdapter(private val context: Context, fm: FragmentManager): FragmentPagerAdapter(fm,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {

    override fun getItem(position: Int) = when(position) {
        0 -> OfferFragment()
        else -> LeadFragment()
    }

    override fun getPageTitle(position: Int) = context.resources.getString(TAB_TITLES[position])

    override fun getCount() = 2
}