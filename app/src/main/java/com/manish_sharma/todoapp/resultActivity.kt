package com.manish_sharma.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class resultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)
        val totalQuestion=intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val userName= intent.getStringExtra(Constants.USER_NAME)
       val tvUsername:TextView = findViewById(R.id.tv_name)
        val tvScore:TextView=findViewById(R.id.tv_score)
        val btnFinish:Button=findViewById(R.id.btn_finish)
        tvUsername.setText(userName)
        tvScore.text="You scored $correctAnswers out of $totalQuestion"

        btnFinish.setOnClickListener{

            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }


    }
}