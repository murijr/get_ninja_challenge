package br.com.mandy.getninjachallenge.feature.solicitation.available

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.mandy.getninjachallenge.R
import org.koin.android.ext.android.inject

class AvailableFragment : Fragment() {

    val presenter: AvailablePresenter by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_solicitation_available, container, false)
    }
}