package com.example.colormyviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.colormyviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setListeners()
    }

    private fun setListeners() {
        val clickableViews: List<View> = listOf(
            binding.textBoxOne, binding.textBoxTwo, binding.textBoxThree, binding.textBoxFour,
            binding.textBoxFive, binding.redButton, binding.yellowButton, binding.greenButton
        )

        for (view in clickableViews) {
            view.setOnClickListener { makeColored(it) }
        }
    }

    private fun makeColored(view: View) {
        when (view.id) {
            R.id.text_box_one -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.text_box_two -> view.setBackgroundResource(android.R.color.holo_blue_light)
            R.id.text_box_three -> view.setBackgroundResource(android.R.color.holo_red_dark)
            R.id.text_box_four -> view.setBackgroundResource(android.R.color.black)
            R.id.text_box_five -> view.setBackgroundResource(android.R.color.holo_orange_light)

            R.id.red_button -> view.setBackgroundResource(R.color.red)
            R.id.yellow_button -> view.setBackgroundResource(R.color.yellow)
            R.id.green_button -> view.setBackgroundResource(R.color.green)

            else -> view.setBackgroundResource(android.R.color.darker_gray)
        }
    }
}