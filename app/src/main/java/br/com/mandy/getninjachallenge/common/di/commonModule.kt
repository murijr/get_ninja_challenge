package br.com.mandy.getninjachallenge.common.di

import br.com.mandy.getninjachallenge.common.ExternalCall
import org.koin.dsl.module

val commonModule = module {
    factory { ExternalCall(get()) }
}