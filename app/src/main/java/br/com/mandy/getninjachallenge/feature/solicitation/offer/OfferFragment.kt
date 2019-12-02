package br.com.mandy.getninjachallenge.feature.solicitation.offer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.mandy.getninjachallenge.R
import org.koin.android.ext.android.inject

class OfferFragment : Fragment() {

    val presenter: OfferPresenter by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_solicitation_available, container, false)
    }
}