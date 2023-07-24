package com.example.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.coroutines.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// Suspend pause the execution of all current coroutines. Save all current local variables
// Resume continues the suspend coroutine from the place it was paused.

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    var firstCount=0
    var secondCount=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply {
            tvFirst.text = "0"
            tvSecond.text = "0"
            tvThird.text = "0"
        }

      binding.btnFirst.setOnClickListener {
            binding.tvFirst.text = firstCount++.toString()
        }

        binding.btnSecond.setOnClickListener {
            binding.tvSecond.text = secondCount++.toString()
        }

        binding.btnUpload.setOnClickListener {

            // My First Coroutine
            CoroutineScope(Dispatchers.IO).launch {
                uploadFiles()
            }

        }

    }

    private fun uploadFiles(){
        for(i in 1..400000){
            Log.d("Tag","uploading : $i")
        }
    }

}