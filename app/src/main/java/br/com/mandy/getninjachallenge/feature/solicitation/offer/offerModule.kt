package br.com.mandy.getninjachallenge.feature.solicitation.offer

import org.koin.dsl.module

val offerModule = module {
    factory { OfferPresenter() }
}