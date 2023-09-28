package com.example.logging

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    //    объявление всех переменных.
    private lateinit var myEditText: EditText
    private lateinit var button_log: Button
    private lateinit var button_timber: Button

    //константа
    private val myTag: String = "From EditText"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.plant(Timber.DebugTree())

//        переменные в памяти.
        myEditText = findViewById(R.id.edit_text)
        button_log = findViewById(R.id.button_log)
        button_timber = findViewById(R.id.button_timber)

        button_log.setOnClickListener { sendLog() }
        button_timber.setOnClickListener { sendTimber() }
    }

    private fun sendLog() {
        Log.v(myTag, myEditText.text.toString())
    }

    private fun sendTimber() {
        Timber.i("timber: " + myEditText.text.toString())
//        Timber.d(myTag, myEditText.text.toString())
    }


}