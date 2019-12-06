package br.com.mandy.getninjachallenge.feature.detail.lead

import org.koin.dsl.module

val leadDetailModule = module {
    factory<LeadDetailContract.Presenter> { LeadDetailPresenter(get()) }
    factory { LeadDetailInfoValueAdapter() }
}