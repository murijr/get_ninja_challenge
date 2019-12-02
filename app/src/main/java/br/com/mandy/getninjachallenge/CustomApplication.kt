package br.com.mandy.getninjachallenge

import android.app.Application
import br.com.mandy.getninjachallenge.common.di.networkModule
import br.com.mandy.getninjachallenge.common.di.repositoryModule
import br.com.mandy.getninjachallenge.feature.solicitation.accepted.acceptedModule
import br.com.mandy.getninjachallenge.feature.solicitation.available.availableModule
import com.androidnetworking.AndroidNetworking
import org.koin.android.ext.android.get
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CustomApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin()
        startAndroidNetworking()
    }

    private fun startKoin() {
        startKoin {
            androidContext(this@CustomApplication)
            modules(networkModule, acceptedModule, availableModule, repositoryModule)
        }
    }

    private fun startAndroidNetworking() {
        AndroidNetworking.initialize(get(), get())
    }
}