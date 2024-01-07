package com.vnc.flashscorex.ui.launch

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.vnc.flashscorex.R
import com.vnc.flashscorex.databinding.ActivityLaunchBinding
import com.vnc.flashscorex.ui.dashboard.DashBoardActivity


class LaunchActivity : AppCompatActivity() {

    private lateinit var binding:ActivityLaunchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        installSplashScreen()
        binding = ActivityLaunchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        window.statusBarColor = ContextCompat.getColor(this, R.color.status_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            val options = ActivityOptions.makeSceneTransitionAnimation(this)
            val intent = Intent(this,DashBoardActivity::class.java)
//            startActivity(intent,options.toBundle())
            startActivity(intent)
        }, 1000)

    }
}