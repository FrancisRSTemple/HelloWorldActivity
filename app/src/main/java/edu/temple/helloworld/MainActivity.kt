package edu.temple.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    // Declare view properties
    lateinit var displayTextView: TextView
    lateinit var nameEditText: EditText
    lateinit var clickMeButton: Button

    private var NAME_KEY = "name"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views defined in Layout
        displayTextView = findViewById(R.id.displayTextView)
        nameEditText = findViewById(R.id.nameEditText)
        clickMeButton = findViewById(R.id.clickMeButton)
        
        // Respond to button click event
        clickMeButton.setOnClickListener{

            /* Write your code here */

            displayTextView.text = "Hello, ${nameEditText.text.toString()}"

        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState.getString(NAME_KEY)?.run{
            displayTextView.text = this
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(NAME_KEY, displayTextView.text.toString())
    }
}