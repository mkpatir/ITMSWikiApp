package com.mkpatir.itmswikiapp.presentation

import android.app.Application
import com.mkpatir.itmswikiapp.internal.di.appKoinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ITMSWikiApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ITMSWikiApplication)
            modules(appKoinModules)
        }
    }
}