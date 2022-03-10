package com.paven196.shaketolog

import android.app.Activity
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.github.tbouron.shakedetector.library.ShakeDetector

/**
 * Created by tunglt on 09-Mar-22
 */
object ShakeLogger {
    private const val TAG = "ShakeLogger"

    // OnCreate()
    fun registerOnShakeToLogListener(act: Activity) {
        ShakeDetector.create(act) {
            Log.d(TAG, "onShake: ")
            Toast.makeText(act, "Shake", Toast.LENGTH_SHORT).show()
            act.startActivity(Intent(act, LoggerActivity::class.java))
        }
        ShakeDetector.updateConfiguration(0.2f, 2)
    }

    // OnResume()
    fun startShakeToLogListener() {
        ShakeDetector.start();
    }

    // OnStop()
    fun stopShakeToLogListener() {
        ShakeDetector.stop();
    }

    // OnDestroy()
    fun destroyShakeToLogListener() {
        ShakeDetector.destroy()
    }
}