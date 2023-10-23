package com.vnc.flashscorex.ui.launch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.vnc.flashscorex.R
import com.vnc.flashscorex.ui.dashboard.DashBoardActivity

class LaunchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_launch)
        supportActionBar?.hide()
        startActivity(Intent(this,DashBoardActivity::class.java))
    }
}