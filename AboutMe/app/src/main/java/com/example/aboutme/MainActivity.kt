package com.example.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private val myName = MyName("Sarah Connor")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

//        textLabel = findViewById(R.id.text_name_label)
//        doneButton = findViewById(R.id.button_done)
//        doneButton.setOnClickListener { addNickName(it) }
        binding.buttonDone.setOnClickListener {
            addNickName(it)
        }

    }

    private fun addNickName(view: View) {
//        val inputName = findViewById<EditText>(R.id.text_input_name)
//        inputName.visibility = View.GONE
//        view.visibility = View.GONE
//        textLabel.text = inputName.text.toString()
//        textLabel.visibility = View.VISIBLE

        //Data binding way 1
//        binding.textNameLabel.text = binding.textInputName.text.toString()
//        binding.textNameLabel.visibility = View.VISIBLE
//        binding.textInputName.visibility = View.GONE
//        binding.buttonDone.visibility = View.GONE

        //Data binding 2
        binding.apply {
            //textNickname.text = textInputName.text.toString()
            myName?.nickname = textInputName.text.toString()
            invalidateAll()  //requests a new rebind to refresh UI
            textNickname.visibility = View.VISIBLE
            textInputName.visibility = View.GONE
            buttonDone.visibility = View.GONE
        }

        // Hidden key board
        hiddenKeyboard(view)
    }

    private fun hiddenKeyboard(view: View) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}