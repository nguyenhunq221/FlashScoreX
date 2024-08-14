package com.vnc.flashscorex.ui.dashboard

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
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
    private var doubleBackToExitPressedOnce:Boolean = false
    private val CAMERA_PERMISSION_REQUEST_CODE  = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = PreferenceUtil(this)
        supportActionBar?.hide()
        window.statusBarColor = ContextCompat.getColor(this, R.color.back_ground_main)
        binding.bottomNavigation.background = null
        binding.bottomNavigation.menu.getItem(2).isEnabled = false

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.findNavController()

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA), CAMERA_PERMISSION_REQUEST_CODE)
        }


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

//        val appBarConfiguration = AppBarConfiguration(setOf(R.id.fragmentHome,R.id.favorFragment,R.id.favorFragment,R.id.predictFragment))
//        setupActionBarWithNavController(navController,appBarConfiguration)

        binding.bottomNavigation.setupWithNavController(navController)
//        binding.bottomNavigation.apply {
//            setOnItemSelectedListener(mNavigationItemSelected)
//        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == CAMERA_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Quyền truy cập vào camera đã được cấp
                Toast.makeText(this, "Quyền truy cập vào camera đã được cấp!", Toast.LENGTH_SHORT).show()
            } else {
                // Quyền truy cập không được cấp, có thể hiển thị thông báo khác hoặc yêu cầu lại quyền
                Toast.makeText(this, "Không cấp quyền truy cập vào camera!", Toast.LENGTH_SHORT).show()
            }
        }
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
            val pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

            // Set the alarm to trigger at the desired time (e.g., 8:00 AM)
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = System.currentTimeMillis()
            calendar.set(Calendar.HOUR_OF_DAY, 7)
            calendar.set(Calendar.MINUTE,22 )
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

    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            val startMain = Intent(Intent.ACTION_MAIN)
            startMain.addCategory(Intent.CATEGORY_HOME)
            startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(startMain)
            return
        }

        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, getString(R.string.exit), Toast.LENGTH_SHORT).show()

        Handler(Looper.getMainLooper()).postDelayed({ doubleBackToExitPressedOnce = false }, 2000)
    }

}