package com.vnc.flashscorex.ui.dashboard

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.vnc.flashscorex.R
import com.vnc.flashscorex.databinding.ActivityDashBoardBinding
import com.vnc.flashscorex.utils.PreferenceUtil
import java.util.Calendar


class DashBoardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashBoardBinding
    private lateinit var navController: NavController
    private lateinit var sharedPreferences:PreferenceUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()
        sharedPreferences = PreferenceUtil(this)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.findNavController()


//        val mNavigationItemSelected = object : NavigationBarView.OnItemSelectedListener {
//            override fun onNavigationItemSelected(item: MenuItem): Boolean {
//                when (item.itemId) {
//                    R.id.fragmentHome -> {
//                        NavigationUI.onNavDestinationSelected(
//                            item,
//                            navController
//                        )
//                        return true
//                    }
//                    R.id.favorFragment -> {
//                        NavigationUI.onNavDestinationSelected(
//                            item,
//                            navController
//                        )
//                        return true
//                    }
//                    R.id.predictFragment -> {
//                        NavigationUI.onNavDestinationSelected(
//                            item,
//                            navController
//                        )
//                        return true
//                    }
//                    R.id.newsFragment -> {
//                        NavigationUI.onNavDestinationSelected(
//                            item,
//                            navController
//                        )
//                        return true
//                    }
//                    else -> {
//                        return false
//                    }
//                }
//            }
//        }

        val appBarConfiguration = AppBarConfiguration(setOf(R.id.fragmentHome,R.id.favorFragment,R.id.favorFragment,R.id.predictFragment))
        setupActionBarWithNavController(navController,appBarConfiguration)

        binding.bottomNavigation.setupWithNavController(navController)
//        binding.bottomNavigation.apply {
//            setOnItemSelectedListener(mNavigationItemSelected)
//        }
    }
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onStart() {
        super.onStart()
        val notificationSet = sharedPreferences.getBoolean("notificationSet")

        if (!notificationSet){
            val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
            val intent = Intent(this, NoticeReceiver::class.java)
            val pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

            // Set the alarm to trigger at the desired time (e.g., 8:00 AM)
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = System.currentTimeMillis()
            calendar.set(Calendar.HOUR_OF_DAY, 7)
            calendar.set(Calendar.MINUTE,20 )
            calendar.set(Calendar.SECOND, 25)

            // Schedule the alarm to repeat every day
            alarmManager.setRepeating(
                AlarmManager.RTC_WAKEUP,
                calendar.timeInMillis,
                AlarmManager.INTERVAL_DAY,
                pendingIntent
            )

            sharedPreferences.saveBoolean("notificationSet",true)
        }
    }

}