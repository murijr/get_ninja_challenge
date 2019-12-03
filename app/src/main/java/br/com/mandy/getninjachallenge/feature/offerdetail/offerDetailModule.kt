package br.com.mandy.getninjachallenge.feature.offerdetail

import org.koin.dsl.module

val offerDetailModule = module {
    factory<OfferDetailContract.Presenter> { OfferDetailPresenter(get()) }
}