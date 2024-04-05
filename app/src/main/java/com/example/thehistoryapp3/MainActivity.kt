package com.example.thehistoryapp3

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val famousPeople = mapOf(
        //map of famous people and what age they passed away with some additional information
        20 to "Cameron Boyce a famous Teen actor",
        30 to "Bob Marley one the most talented musicians to ever live",
        40 to "Elvis Presley the king of rock and Roll",
        50 to "Michael Jackson the king of pop Hee! Hee!",
        60 to "Diego Maradona a well known football legend one of the best to ever bless the pitch",
        70 to "Marco Polo a famous explore and merchant",
        80 to "Marlon Brando a legend in the film industry",
        90 to "Winston Churchill one of England's most notorious Prime ministers",
        100 to "Lao Tzu a famous ancient philosopher"
    )

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Initializing views
        val clickButton=findViewById<Button>(R.id.clickButton)
        val clearButton=findViewById<Button>(R.id.clearButton)
        val textInfo=findViewById<TextView>(R.id.textInfo)
        val ageView=findViewById<EditText>(R.id.ageView)

        //adding click Listener for clear button
        clearButton.setOnClickListener {
            ageView.text.clear()
            textInfo.text = ""
        }

        //adding Click Listener for click button
        clickButton.setOnClickListener {
            val ageStr = ageView.text.toString()
            if (ageStr.isEmpty()) {
                Toast.makeText(this, "Please enter valid age", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

        //checking if age input is correct a error will occur if it is incorrect
            val age = ageStr.toIntOrNull()
            if (age == null) {
                Toast.makeText(this, "APP only accepts whole Integers please try again",
                    Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

        //checking if age is within range a error will occur if not
            if (age !in 20..100) {
                Toast.makeText(this, "Your age is out of the (20-100) range ", Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

        //using logic to match users age with famous people
            val famousPerson = famousPeople[age]
            if (famousPerson != null) { //checking for famous people
                textInfo.text = "Famous person at the Age of $age: $famousPerson"
            } else { //no famous person is found
                Toast.makeText(this, "Sorry we couldn't find any person at this $age", Toast.LENGTH_SHORT
                    ).show()
            }
        }
    }
}