package com.stormsec.senacap

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v4.app.ActivityCompat

class Navigation {
    companion object {
        private fun startActivity(context: Context, intent: Intent) {
            ActivityCompat.startActivity(context, intent, null)
        }

        fun goToHome(activity: Activity) {
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(activity, intent)
        }

        fun goToLogin(activity: Activity){
            val intent = Intent(activity, LoginActivity::class.java)
            startActivity(activity,intent)
        }

        fun goToTitle(activity: Activity){
            val intent = Intent(activity, RescueFragment::class.java)
            startActivity(activity,intent)
        }
    }
}