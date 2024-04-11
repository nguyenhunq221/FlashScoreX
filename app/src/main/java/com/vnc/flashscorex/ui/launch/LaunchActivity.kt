package com.vnc.flashscorex.ui.launch

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.vnc.flashscorex.R
import com.vnc.flashscorex.databinding.ActivityLaunchBinding
import com.vnc.flashscorex.ui.dashboard.DashBoardActivity
import com.vnc.flashscorex.utils.GetCurrent


class LaunchActivity : AppCompatActivity() {

    private lateinit var binding:ActivityLaunchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLaunchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        window.statusBarColor = ContextCompat.getColor(this, R.color.back_ground_main)

        Handler(Looper.getMainLooper()).postDelayed({
            val options = ActivityOptions.makeSceneTransitionAnimation(this)
            val intent = Intent(this,DashBoardActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent,options.toBundle())
            startActivity(intent)
        }, 2000)

        setUpView()

    }

    private fun setUpView(){
        binding.txtDate.text = GetCurrent.getDate()
        binding.txtTime.text = GetCurrent.getTimeHours()
    }

}