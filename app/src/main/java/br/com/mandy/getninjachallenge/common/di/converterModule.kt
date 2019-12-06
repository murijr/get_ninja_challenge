package br.com.mandy.getninjachallenge.common.di

import br.com.mandy.getninjachallenge.common.converter.GenericConverter
import br.com.mandy.getninjachallenge.data.entity.offerdetail.Info
import br.com.mandy.getninjachallenge.feature.detail.lead.LeadDetailInfoValueTypeAdapter
import br.com.mandy.getninjachallenge.feature.detail.offer.OfferDetailInfoValueTypeAdapter
import com.google.gson.GsonBuilder
import org.koin.dsl.module


val converterModule = module {

    factory {
        val gson = GsonBuilder()
            .registerTypeAdapter(Info::class.java,
                OfferDetailInfoValueTypeAdapter()
            )
            .registerTypeAdapter(br.com.mandy.getninjachallenge.data.entity.leaddetail.Info::class.java,
                LeadDetailInfoValueTypeAdapter()
            )
            .create()
        GenericConverter(gson)
    }
}