package com.example.tnytnewsapplication

import android.app.Application
import com.example.tnytnewsapplication.data.di.apiModule
import com.example.tnytnewsapplication.data.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TNYTNewsApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@TNYTNewsApplication)
            modules(
                apiModule,
                viewModelModule
            )
        }
    }
}