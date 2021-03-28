package com.example.quizapp

object Constants{

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_question"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions(): ArrayList<Question>{  // This function will get an array list of type questions
        val questionList = ArrayList<Question>()

        // 1
        val que1 = Question(1,"What country does this flag belong to?",
        R.drawable.ic_bg_argentina, "Argentina","Brazil","Belgium",
        "Italy",1)
        questionList.add(que1)

        // 2
        val que2 = Question(2,"What country does this flag belong to?",
            R.drawable.ic_bg_australia, "Argentina","Australia","Belgium",
            "Italy",2)
        questionList.add(que2)

        // 3
        val que3 = Question(3,"What country does this flag belong to?",
            R.drawable.ic_bg_belgium, "Argentina","Brazil","Belgium",
            "Italy",3)
        questionList.add(que3)

        // 4
        val que4 = Question(4,"What country does this flag belong to?",
            R.drawable.ic_bg_brazil, "Argentina","Brazil","Belgium",
            "Italy",2)
        questionList.add(que4)

        // 5
        val que5 = Question(5,"What country does this flag belong to?",
            R.drawable.ic_bg_fiji, "Argentina","Fiji","Belgium",
            "Italy",2)
        questionList.add(que5)

        // 6
        val que6 = Question(6,"What country does this flag belong to?",
            R.drawable.ic_bg_germany, "Argentina","Brazil","Germany",
            "Italy",3)
        questionList.add(que6)

        // 7
        val que7 = Question(7,"What country does this flag belong to?",
            R.drawable.ic_bg_india, "Argentina","Brazil","Belgium",
            "India",4)
        questionList.add(que7)

        // 8
        val que8 = Question(8,"What country does this flag belong to?",
            R.drawable.ic_bg_new_zealand, "New Zealand","Brazil","Belgium",
            "Italy",1)
        questionList.add(que8)

        // 9
        val que9 = Question(9,"What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark, "Denmark","Brazil","Belgium",
            "Italy",1)
        questionList.add(que9)

        // 10
        val que10 = Question(10,"What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait, "Kuwait","Brazil","Belgium",
            "Italy",1)
        questionList.add(que10)

        return questionList
    }
}