package com.paven196.shaketolog

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.paven196.shaketolog.preference.AppPreferences
import com.paven196.shaketolog.preference.EPreferencesKey


/**
 * Created by tunglt on 09-Mar-22
 */
class LoggerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loger)

        val tvContent: TextView = findViewById(R.id.tvContent)
        tvContent.movementMethod = ScrollingMovementMethod()

        findViewById<Button>(R.id.btnClear).setOnClickListener {
            ShakeLogger.clearLog()
            finish()
        }

        findViewById<Button>(R.id.btnClose).setOnClickListener {
            finish()
        }

        val log = AppPreferences.getString(EPreferencesKey.LOG)
        tvContent.text = log
    }
}