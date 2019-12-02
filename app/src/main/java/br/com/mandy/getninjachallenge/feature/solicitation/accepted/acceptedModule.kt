package br.com.mandy.getninjachallenge.feature.solicitation.accepted

import org.koin.dsl.module

val acceptedModule = module {
    factory { AcceptedPresenter() }
}