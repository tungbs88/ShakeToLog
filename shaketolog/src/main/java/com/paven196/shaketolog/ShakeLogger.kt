package com.paven196.shaketolog

import android.app.Activity
import android.app.Application
import android.content.Intent
import android.text.format.DateFormat
import android.util.Log
import android.widget.Toast
import com.github.tbouron.shakedetector.library.ShakeDetector
import com.paven196.shaketolog.preference.AppPreferences
import com.paven196.shaketolog.preference.EPreferencesKey
import java.util.*

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
        ShakeDetector.updateConfiguration(0.5f, 2)
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

    // Init preferences in Base Application
    fun initLoggerPreferences(app: Application) {
        AppPreferences.init(app)
    }

    fun addLog(content: String) {
        val currentLog = AppPreferences.getString(EPreferencesKey.LOG)
        val newContent = if (currentLog.isEmpty())
            timeStamp2Date(System.currentTimeMillis()).plus(" : ").plus(content)
        else
            "\n".plus(timeStamp2Date(System.currentTimeMillis())).plus(" : ").plus(content)
        val log = currentLog.plus(newContent)
        AppPreferences.putString(EPreferencesKey.LOG, log)
    }

    fun clearLog() {
        AppPreferences.remove(EPreferencesKey.LOG)
    }

    private fun timeStamp2Date(timeStamp: Long, format: String = "dd/MM/yyyy HH:mm:ss"): String {
        if (timeStamp == 0L) return ""
        val cal = Calendar.getInstance(
            Locale.getDefault()
        )
        cal.timeInMillis = timeStamp
        return DateFormat.format(format, cal).toString()
    }
}