package com.example.leonardomoralescoroutines

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i(TAG, "main fun init")

        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        buttonRun.setOnClickListener {
            viewModel.startProgressbar()
        }

        buttonCancel.setOnClickListener {
            viewModel.restartProgressbar()
        }

// entender esta parte
        lifecycleScope.launchWhenStarted {
            viewModel.progressBar.collect {
                progressBar.progress = it
            }
        }

        // runCoroutinesWithJob()
        //runAsyncCoroutines()
        //runWithRunBlocking()
        //showTextInMainDispatcher()
        // runTwoCoroutinesInParallel();
        //runTwoCoroutinesInParallelWithAsync()
        // runCoroutineScope()
    }

    private suspend fun getInfoForInternet(): String {
        delay(5000)
        return "Response from internet"
    }

    private suspend fun getInfoForInternet(int: Int): String {
        delay(5000)
        return "Response from internet $int"
    }

    private fun runCoroutineScope() {
        buttonRun.setOnClickListener {
            lifecycleScope.launch {
                while (true) {
                    delay(1000)
                    Log.i(TAG, "Coroutine running...")
                }
            }

            lifecycleScope.launch {
                delay(5000)
                Intent(this@MainActivity, SecondActivity::class.java).also {
                    startActivity(it)
                    finish()
                }
            }
        }
    }

    private fun runTwoCoroutinesInParallelWithAsync() {
        GlobalScope.launch(Dispatchers.IO) {
            val time = measureTimeMillis {
                val job1 = async { getInfoForInternet(1) }
                val job2 = async { getInfoForInternet(2) }

                job1.join()
                job2.join()

                Log.i(TAG, job1.await())
                Log.i(TAG, job2.await())

            }
            Log.i(TAG, time.toString())
        }
    }

    private fun runTwoCoroutinesInParallelWithLaunch() {
        GlobalScope.launch(Dispatchers.IO) {

            val x = measureTimeMillis {
                delay(1000)
            }



            val time = measureTimeMillis {
                var res1: String? = null
                var res2: String? = null

                val job1 = launch { res1 = getInfoForInternet(1) }
                val job2 = launch { res2 = getInfoForInternet(2) }

                job1.join()
                job2.join()

                Log.i(TAG, "$res1")
                Log.i(TAG, "$res2")

            }
            Log.i(TAG, time.toString())
        }
    }

    private fun showTextInMainDispatcher() {
        GlobalScope.launch(Dispatchers.IO) {
            val response = getInfoForInternet()

            Log.i(TAG, "running long task..")
            withContext(Dispatchers.Main) {
                textView.text = response
                Log.i(TAG, "Finished long task!")
            }

        }
    }

    private fun runWithRunBlocking() {
        Log.i(TAG, "fun init")
        runBlocking {
            Log.i(TAG, "init coroutine on: ${Thread.currentThread().name} ")
            delay(5000)
            Log.i(TAG, "Finalize coroutine on: ${Thread.currentThread().name} ")
        }

        /* GlobalScope.launch {
             Log.i(TAG, "init coroutine on: ${Thread.currentThread().name} ")
             delay(5000)
             Log.i(TAG, "Finalize coroutine on: ${Thread.currentThread().name} ")
         }*/

        Log.i(TAG, "fun finalize")
    }

    private fun runAsyncCoroutines() {
        val job = GlobalScope.launch {
            val sum1 = async {
                delay(5000)
                sum(5, 8)
            }

            val sum2 = async {
                delay(2000)
                sum(4, 3)
            }

            val total = sum1.await() + sum2.await()

            Log.i(TAG, "Value: $total")
        }
    }

    private fun sum(num1: Int, num2: Int) = num1 + num2

    private fun runCoroutinesWithJob() {
        // run default
        val job = GlobalScope.launch {
            Log.i(TAG, "Coroutine init")
            delay(5000)  // coroutines, don't block thread because use 'suspend' fun
            Log.i(TAG, "Coroutine finalize")
        }


        buttonRun.setOnClickListener {
            GlobalScope.launch(Dispatchers.Main) {
                Log.i(TAG, "Coroutine init")
                //Thread.sleep(5000) // Stop the current thread until finish
                delay(5000)  // coroutines, don't block thread because use 'suspend' fun
                Log.i(TAG, "Coroutine finalize")
            } as CompletableJob

            GlobalScope.launch(Dispatchers.Main) {
                Log.i(TAG, "Second Coroutine")
            }
        }


        buttonCancel.setOnClickListener {
            job.cancel()
            Log.i(TAG, "Coroutine cancel: ${Thread.currentThread().name}")
        }
    }
}