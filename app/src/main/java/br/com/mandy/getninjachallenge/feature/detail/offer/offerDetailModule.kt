package br.com.mandy.getninjachallenge.feature.detail.offer

import org.koin.dsl.module

val offerDetailModule = module {
    factory<OfferDetailContract.Presenter> { OfferDetailPresenter(get()) }
    factory { OfferDetailInfoValueAdapter() }
}