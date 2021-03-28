package com.example.quizapp

// This class will not have any specific features and functionality, the only thing it
// will have is Data Info. The question text, image, options and which one will be correct.
// Therefore, this will be a data class.

data class Question(  // All the questions will have the below mentioned features.
    val id: Int,
    val question: String,
    val image: Int,
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val optionFour: String,
    val correctAnswer: Int
)