package org.bubenheimer

import android.app.Activity
import android.app.Service
import android.content.Intent
import android.os.Bundle
import android.os.StrictMode
import android.widget.Toast

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        StrictMode.setVmPolicy(
                StrictMode.VmPolicy.Builder().detectIncorrectContextUse().penaltyDeath().build()
        )

        startService(Intent(this, MainService::class.java))
    }
}

class MainService : Service() {
    override fun onCreate() {
        super.onCreate()

        println("Pre toast")

        Toast.makeText(this, "Service Toast", Toast.LENGTH_LONG).show()

        println("Past toast")
    }

    override fun onBind(intent: Intent?) = null
}
