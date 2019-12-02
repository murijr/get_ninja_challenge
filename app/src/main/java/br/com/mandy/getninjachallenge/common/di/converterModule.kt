package br.com.mandy.getninjachallenge.common.di

import br.com.mandy.getninjachallenge.common.converter.OfferConverter
import com.google.gson.GsonBuilder
import org.koin.dsl.module


val converterModule = module {

    factory {
        val gson = GsonBuilder().create()
        OfferConverter(gson)
    }
}