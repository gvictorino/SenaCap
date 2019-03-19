package com.stormsec.senacap

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.View

class SplashActivity : AppCompatActivity(){
    companion object {
        private val SPLASH_DURATION = 3000
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val decorView = window.decorView
        val uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        decorView.systemUiVisibility = uiOptions
    }
    public override fun onResume() {
        super.onResume()

        Handler().postDelayed({
            Navigation.goToLogin(this@SplashActivity)
            finish()
        }, SPLASH_DURATION.toLong())
    }
}