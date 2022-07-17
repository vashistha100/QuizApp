package com.manish_sharma.todoapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener{

    private var mCurrentPosition:Int = 1
    private var mQuestionlist:ArrayList<Question>?=null
    private var mSelectedOptionPosition : Int = 0
    private var mCorrectAnswers:Int = 0

    private var progressbar:ProgressBar?=null
    private var tvProgress:TextView?=null
    private var tvQuestion: TextView?=null
    private  var tvImage:  ImageView?=null
     private var mUserName:String?=null
    private var tvoption1:TextView?=null
    private var tvoption2:TextView?=null
    private var tvoption3:TextView?=null
    private var tvoption4:TextView?=null

    private var btnSubmit:Button?=null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        progressbar=findViewById(R.id.ProgressBar)
        tvProgress=findViewById(R.id.questionProgress)
        tvQuestion=findViewById(R.id.tv_question)
        tvImage=findViewById(R.id.iv_image)
        tvoption1 = findViewById(R.id.OptionOne)
        tvoption2 = findViewById(R.id.OptionTwo)
        tvoption3 = findViewById(R.id.OptionThree)
        tvoption4 = findViewById(R.id.OptionFour)
        btnSubmit = findViewById(R.id.btn_submit)

        tvoption1?.setOnClickListener(this)
        tvoption2?.setOnClickListener(this)
        tvoption3?.setOnClickListener(this)
        tvoption4?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)
        mUserName=intent.getStringExtra(Constants.USER_NAME)
      mQuestionlist = Constants.getQuestions()

        setQuestion()
       //defaultOptionsView()

    }

    private fun setQuestion() {

   defaultOptionsView()

        val ques: Question = mQuestionlist!![mCurrentPosition - 1]
        tvImage?.setImageResource(ques.image)
        progressbar?.progress = mCurrentPosition
        tvProgress?.text = "${mCurrentPosition}/${progressbar?.max}"
        tvQuestion?.text = ques.question
        tvoption1?.text = ques.optionOne
        tvoption2?.text = ques.optionTwo
        tvoption3?.text = ques.optionThree
        tvoption4?.text = ques.optionFour

        if(mCurrentPosition == mQuestionlist!!.size)
        {
            btnSubmit?.text="FINISH"
        }
        else
        {
            btnSubmit?.text="SUBMIT"
        }
    }
    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        tvoption1?.let {
            options.add(0,it)
        }
        tvoption2?.let {
            options.add(1,it)
        }
        tvoption3?.let {
            options.add(2,it)
        }
        tvoption4?.let {
            options.add(3,it)
        }
        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(
                this,R.drawable.default_otpion_background
            )
        }

    }
    private fun selectedOptionView(tv:TextView,selectedOptionNum:Int)
    {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background =ContextCompat.getDrawable(
            this,R.drawable.option_selected_bg
        )
    }


    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.OptionOne->{
                tvoption1?.let {
                    selectedOptionView(it,1)
                }
            }
            R.id.OptionTwo->{
                tvoption2?.let {
                    selectedOptionView(it,2)
                }
            }
            R.id.OptionThree->{
                tvoption3?.let {
                    selectedOptionView(it,3)
                }
            }
            R.id.OptionFour->{
                tvoption4?.let {
                    selectedOptionView(it,4)
                }
            }
            R.id.btn_submit->{
                if(mSelectedOptionPosition==0){
                    mCurrentPosition++

                    when{
                        mCurrentPosition<=mQuestionlist!!.size->{
                            setQuestion()
                        }
                        else->{
                            val intent = Intent(this,resultActivity::class.java)
                            intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswers)
                            intent.putExtra(Constants.USER_NAME,mUserName)
                            intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionlist?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }
                else{
                    val question = mQuestionlist?.get(mCurrentPosition-1)
                    if(question!!.correctAnswer!= mSelectedOptionPosition)
                    {correctAnswerView(mSelectedOptionPosition,R.drawable.wrong_otpion_background)}
                    else{
                        mCorrectAnswers++
                    }

                    correctAnswerView(question.correctAnswer,R.drawable.correct_otpion_background)
                    if(mCurrentPosition==mQuestionlist!!.size){
                        btnSubmit?.text="FINISH"
                    }
                    else{
                        btnSubmit?.text="GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition=0
                }

            }

        }
    }
    private fun correctAnswerView(answer: Int,drawableview:Int)
    {
        when(answer){
            1->  {
                tvoption1?.background=ContextCompat.getDrawable(this,
            drawableview)
        }
            2->  {
                tvoption2?.background=ContextCompat.getDrawable(this,
                    drawableview)
            }
            3->  {
                tvoption3?.background=ContextCompat.getDrawable(this,
                    drawableview)
            }
            4->  {
                tvoption4?.background=ContextCompat.getDrawable(this,
                    drawableview)
            }

        }

    }

}