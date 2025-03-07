package com.example.apiroom.feature_app.presentation

import android.app.Application
import com.example.apiroom.di.moduleUser
import com.example.apiroom.di.moduleViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(applicationContext)
            androidLogger(Level.DEBUG)
            modules(listOf(
                moduleUser, moduleViewModel
            ))
        }
    }
}