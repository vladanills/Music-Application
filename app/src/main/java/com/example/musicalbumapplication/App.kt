package com.example.musicalbumapplication

import android.app.Application
import android.content.Context
import android.util.Log
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

lateinit var di: Kodein

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        di = Kodein {
            bind<Context>() with singleton { this@App }
            bind<RequestMaker>() with singleton {
                OkHttpRequestMaker(
                    instance()
                )
            }
        }
    }
}