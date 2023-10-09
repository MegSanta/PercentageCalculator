package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val calButton = findViewById<Button>(R.id.calculateButton)
        val answerDisplay = findViewById<TextView>(R.id.answer)
        val smallNum = findViewById<EditText>(R.id.littleNumber)
        val bigNum = findViewById<EditText>(R.id.bigNumber)
        calButton.setOnClickListener {
            if (smallNum.text.isNullOrEmpty() || bigNum.text.isNullOrEmpty()) {
                showToast("Please enter something")
            } else {
                showResult()
                if (answerDisplay.visibility == View.GONE) {
                    answerDisplay.visibility= View.VISIBLE
                } else {
                    answerDisplay.visibility = View.GONE}
                if (calButton.text == "Calculate") {
                    calButton.text = "Restart"
                } else if (calButton.text == "Restart") {
                    calButton.text = "Calculate"
                    smallNum.text.clear()
                    bigNum.text.clear()
                }
            }
        }
    }
    private fun result(): Double {
        val smallNum = findViewById<EditText>(R.id.littleNumber).text.toString().toDouble()
        val bigNum = findViewById<EditText>(R.id.bigNumber).text.toString().toDouble()

        return (smallNum / bigNum) * 100
    }
    private fun showResult(){
        val numResult = result()
        val resultDisplay = findViewById<TextView>(R.id.answer)
        val smallNum = findViewById<EditText>(R.id.littleNumber).text.toString()
        val bigNum = findViewById<EditText>(R.id.bigNumber).text.toString()
        val resultText = "$smallNum is $numResult% of $bigNum"
        resultDisplay.text = resultText

    }
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}