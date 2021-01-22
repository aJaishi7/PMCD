package com.college.pmcd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO

class SplashActivity : AppCompatActivity() {
    private val splash = CoroutineScope(Dispatchers.IO);
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide();
        setContentView(R.layout.activity_slide)
        Splash();
    }

    //Splash Function
    private fun Splash() {
        splash.launch {
            delay(5000);
            val intent = Intent(this@SplashActivity, LoginActivity::class.java);
            startActivity(intent);
            finish();
        }
    }

    //Cancel splash on hidding app from user
    override fun onPause() {
        super.onPause()
        splash.cancel()
    }
}