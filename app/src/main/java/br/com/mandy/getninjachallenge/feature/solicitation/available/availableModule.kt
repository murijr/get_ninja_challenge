package br.com.mandy.getninjachallenge.feature.solicitation.available

import org.koin.dsl.module

val availableModule = module {
    factory { AvailablePresenter() }
}