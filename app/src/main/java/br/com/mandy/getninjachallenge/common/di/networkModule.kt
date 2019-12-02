package br.com.mandy.getninjachallenge.common.di

import okhttp3.OkHttpClient
import org.koin.dsl.module

val networkModule = module {

    single<OkHttpClient> {
        OkHttpClient().newBuilder().build()
    }
}