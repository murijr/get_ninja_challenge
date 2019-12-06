package br.com.mandy.getninjachallenge.common.di

import br.com.mandy.getninjachallenge.common.converter.GenericConverter
import br.com.mandy.getninjachallenge.data.entity.offerdetail.Info
import br.com.mandy.getninjachallenge.feature.detail.offer.InfoValueTypeAdapter
import com.google.gson.GsonBuilder
import org.koin.dsl.module


val converterModule = module {

    factory {
        val gson = GsonBuilder()
            .registerTypeAdapter(Info::class.java, InfoValueTypeAdapter())
            .create()
        GenericConverter(gson)
    }
}