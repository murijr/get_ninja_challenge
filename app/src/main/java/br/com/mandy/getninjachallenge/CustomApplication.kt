package br.com.mandy.getninjachallenge

import android.app.Application
import br.com.mandy.getninjachallenge.feature.solicitation.accepted.acceptedModule
import br.com.mandy.getninjachallenge.feature.solicitation.available.availableModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CustomApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@CustomApplication)
            modules(acceptedModule, availableModule)
        }
    }
}