package br.com.mandy.getninjachallenge.feature.solicitation.lead

import org.koin.dsl.module

val leadModule = module {
    factory { LeadPresenter() }
}