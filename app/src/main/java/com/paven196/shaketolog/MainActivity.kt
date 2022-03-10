package com.paven196.shaketolog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ShakeLogger.registerOnShakeToLogListener(this)
    }

    override fun onResume() {
        super.onResume()
        ShakeLogger.startShakeToLogListener()
    }

    override fun onStop() {
        super.onStop()
        ShakeLogger.stopShakeToLogListener()
    }

    override fun onDestroy() {
        super.onDestroy()
        ShakeLogger.destroyShakeToLogListener()
    }
}