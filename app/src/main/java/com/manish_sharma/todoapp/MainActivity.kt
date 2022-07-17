package com.manish_sharma.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnStart:Button=findViewById(R.id.btnStart)
        val etText1:EditText=findViewById(R.id.et_1)
        btnStart.setOnClickListener {
            if (etText1.text.isEmpty())
            {
                Toast.makeText(this, "Please enter a Name", Toast.LENGTH_SHORT).show()
            }
            else{
                val intent= Intent(this,QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME,etText1.text.toString())
                startActivity(intent)
                finish()
                
            }
        }
    }
}