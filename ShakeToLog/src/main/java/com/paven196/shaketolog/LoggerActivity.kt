package com.paven196.shaketolog

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


/**
 * Created by tunglt on 09-Mar-22
 */
class LoggerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loger)

        val tvContent: TextView = findViewById(R.id.tvContent)
        tvContent.movementMethod = ScrollingMovementMethod()
    }
}