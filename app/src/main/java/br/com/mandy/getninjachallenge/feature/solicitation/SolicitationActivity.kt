package br.com.mandy.getninjachallenge.feature.solicitation

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import br.com.mandy.getninjachallenge.R
import kotlinx.android.synthetic.main.activity_solicitation.*

class SolicitationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_solicitation)
        handleUI()
    }

    private fun handleUI() {
        configureViewPager()
    }

    private fun configureViewPager() {
        SectionsPagerAdapter(
            this,
            supportFragmentManager
        ).apply {
            view_pager.adapter = this
            tabs.setupWithViewPager(view_pager)
        }
    }
}