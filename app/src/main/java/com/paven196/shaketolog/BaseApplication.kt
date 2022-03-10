package com.paven196.shaketolog

import android.app.Application

/**
 * Created by tunglt on 10-Mar-22
 */
class BaseApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        ShakeLogger.initLoggerPreferences(this)
    }
}