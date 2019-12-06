package br.com.mandy.getninjachallenge.common.di

import br.com.mandy.getninjachallenge.data.repository.lead.LeadRemoteRepository
import br.com.mandy.getninjachallenge.data.repository.lead.LeadRepository
import br.com.mandy.getninjachallenge.data.repository.offer.OfferRemoteRepository
import br.com.mandy.getninjachallenge.data.repository.offer.OfferRepository
import org.koin.dsl.module

val repositoryModule = module {

    factory<OfferRepository> {
        OfferRemoteRepository(get())
    }

    factory<LeadRepository> {
        LeadRemoteRepository(get())
    }
}