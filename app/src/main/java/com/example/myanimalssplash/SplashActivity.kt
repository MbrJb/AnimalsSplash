package com.example.myanimalssplash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class SplashActivity : AppCompatActivity() {

    private lateinit var splashViewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)
        initViewModel()
        observeSplashLiveData()
    }

    private fun initViewModel() {
        splashViewModel = ViewModelProvider(this).get(SplashViewModel::class.java)
    }

    private fun observeSplashLiveData() {
        splashViewModel.initSplashScreen()
        val observer = Observer<SplashModel> {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
        splashViewModel.liveData.observe(this, observer)
    }
}