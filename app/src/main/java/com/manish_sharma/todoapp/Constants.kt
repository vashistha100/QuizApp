package com.manish_sharma.todoapp

object Constants {
 const val USER_NAME:String ="user_name"
    const val TOTAL_QUESTIONS :String="total_questions"
    const val CORRECT_ANSWERS :String="correct_answers"

    fun getQuestions():ArrayList<Question>{
        val questionList = ArrayList<Question>()
        val que1=Question(
            1,"What country does this flag belongs to ?",
            R.drawable.ic_flag_of_argentina,
            "Argentina","Denmark",
            "Australia","England",1
        )
        questionList.add(que1)
        val que2=Question(
            1,"What country does this flag belongs to ?",
            R.drawable.ic_flag_of_india,
            "Argentina","India",
            "Australia","England",2
        )
        questionList.add(que2)
        val que3=Question(
            1,"What country does this flag belongs to ?",
            R.drawable.ic_flag_of_australia,
            "Austria","America",
            "Australia","England",3
        )
        questionList.add(que3)
        val que4=Question(
            1,"What country does this flag belongs to ?",
            R.drawable.ic_flag_of_belgium,
            "Argentina","Belarus" ,
            "Oman","Belgium",4
        )
        questionList.add(que4)
        val que5=Question(
            1,"What country does this flag belongs to ?",
            R.drawable.ic_flag_of_germany,
            "Quatar","Germany",
            "Australia","England",2
        )
        questionList.add(que5)
        val que6=Question(
            1,"What country does this flag belongs to ?",
            R.drawable.ic_flag_of_kuwait,
            "Kuwait","Albania",
            "Australia","England",1
        )
        questionList.add(que6)
        val que7=Question(
            1,"What country does this flag belongs to ?",
            R.drawable.ic_flag_of_fiji,
            "Fiji","India",
            "Australia","England",1
        )
        questionList.add(que7)

        val que8=Question(
            1,"What country does this flag belongs to ?",
            R.drawable.ic_flag_of_brazil,
            "Kuwait","Angola",
            "Australia","Brazil",4
        )
        questionList.add(que8)

        val que9=Question(
            1,"What country does this flag belongs to ?",
            R.drawable.ic_flag_of_denmark,
            "Kuwait","Azarbaizan",
            "Denmark","England",3
        )
        questionList.add(que9)

    return questionList
    }

}