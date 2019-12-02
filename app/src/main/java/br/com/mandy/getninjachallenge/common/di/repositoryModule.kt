package br.com.mandy.getninjachallenge.common.di

import br.com.mandy.getninjachallenge.data.repository.offer.OfferRemoteRepository
import br.com.mandy.getninjachallenge.data.repository.offer.OfferRepository
import org.koin.dsl.module

val repositoryModule = module {

    factory<OfferRepository> {
        OfferRemoteRepository(get())
    }
}