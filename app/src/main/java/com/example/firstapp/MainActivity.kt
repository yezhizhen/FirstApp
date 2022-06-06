package com.example.firstapp


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.firstapp.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.firstTv1.setOnClickListener {
            binding.firstTv1.text = "Bazinga!"
            //Thread.sleep(3000) //This would block the main thread, and the UI display..
            val intent = Intent(this,SecondActivity::class.java) //context

            //Main UI thread not blocked. Therefore "Bazinga“ can be seen (UI main thread refreshed) before the new activity starts
            thread(start = true){
                Thread.sleep(5000)
                startActivity(intent)
            }

        }

    }



}