package com.paven196.shaketolog

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ShakeLogger.registerOnShakeToLogListener(this)

        val edtLog = findViewById<EditText>(R.id.edtLog)
        findViewById<Button>(R.id.btnAddLog).setOnClickListener {
            val content = edtLog.text.toString()
            if (content.isNotEmpty())
                ShakeLogger.addLog(content)
            else
                Toast.makeText(this, "Enter log", Toast.LENGTH_SHORT).show()
        }
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