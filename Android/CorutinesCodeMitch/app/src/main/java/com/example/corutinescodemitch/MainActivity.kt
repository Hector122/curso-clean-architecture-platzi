package com.example.corutinescodemitch

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    var text: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text = findViewById(R.id.text_view)

        val button: Button = findViewById(R.id.button_action)
        button.setOnClickListener {

            //IO, Main, Default
            CoroutineScope(Dispatchers.IO).launch {
                fakeApiRequest()
            }
        }
    }

    private fun setNewText(input: String){
        text?.text = text?.text.toString() + "\n $input"
    }

    private suspend fun fakeApiRequest() {
        val va1 = getResultOneFromApi()
        print("debug: $va1")
        setTexOnMianThead(va1)

        val va2 = getResultTwoFromApi()
        print("debug: $va2")
        setTexOnMianThead(va2)
    }

    private suspend fun setTexOnMianThead(str: String){
        withContext(Dispatchers.Main){
            setNewText(str)
        }
    }

    private suspend fun getResultOneFromApi(): String {
        logTread("getResultOneFromApi")
        delay(1000)
        return "RESULT_1"
    }

    private suspend fun getResultTwoFromApi(): String {
        logTread("getResultOneFromApi")
        delay(1000)
        return "RESULT_2"
    }

    private fun logTread(methodName: String) {
        Log.d("Debug: $methodName", "current Thread: ${Thread.currentThread().name}")
    }
}