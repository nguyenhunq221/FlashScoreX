package com.vnc.flashscorex.ui.player

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vnc.flashscorex.R
import com.vnc.flashscorex.databinding.ActivityDetailPlayerBinding

class DetailPlayerActivity : AppCompatActivity() {

    private lateinit var binding:ActivityDetailPlayerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()
    }
}