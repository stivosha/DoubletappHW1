package ru.stivosha.doubletapphw1

import android.app.Application

class HW1Application : Application() {

    companion object {
        lateinit var logger: ConsoleLogger
    }

    override fun onCreate() {
        super.onCreate()
        logger = ConsoleLogger(this)
    }
}