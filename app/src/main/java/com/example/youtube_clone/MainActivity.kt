package com.example.youtube_clone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.youtube_clone.adapters.MainAdapter
import com.example.youtube_clone.databinding.ActivityMainBinding
import com.example.youtube_clone.utils.Status
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = findNavController(R.id.hostFragment)

        setBottomNav()





    }



//     fun setUi() {
//        binding.search.setOnClickListener {
//            binding.main.visibility = View.GONE
//            binding.qidiruv.visibility = View.VISIBLE
//        }
//
//        binding.editBack.setOnClickListener {
//            binding.qidiruv.visibility = View.GONE
//            binding.main.visibility = View.VISIBLE
//
//        }}


    private fun setBottomNav() {
        binding.bottomNavigationView.background = null
        binding.bottomNavigationView.menu.getItem(2).isEnabled = false
        binding.bottomNavigationView.setupWithNavController(navController)
    }
}