package com.example.taskthreeweeklyfive

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.facebook.drawee.backends.pipeline.Fresco
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    val baseUrl = "https://api.thecatapi.com/v1/images/search"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Fresco.initialize(this)
        simpleCase()
    }
    private fun simpleCase() {
        val client = HttpClient()
        GlobalScope.launch(Dispatchers.IO) {
            val data = client.get<String>(baseUrl)
            Log.i("MyLog", data)
        }
    }
}