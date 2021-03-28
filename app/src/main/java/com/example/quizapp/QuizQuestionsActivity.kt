package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener { // We make/implement our class
                                                                          // OnClickListener
    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0
    private var mUserName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUserName = intent.getStringExtra(Constants.USER_NAME) // We get the username through the key
                                                               // "Constants.USER_NAME"

        mQuestionList = Constants.getQuestions()  // This will be available in our whole project.
        // val questionsList = Constants.getQuestions() // This was available locally.

        setQuestion() // Calling the function

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)

        btn_submit.setOnClickListener(this)

        // !!! All these are for testing purposes since all the variables are local !!!
        // Log.i("Questions Size", "${questionsList.size}") // Shows the size of questions

        // val currentPosition = 1
        // val question: Question? = questionsList[currentPosition-1] //Since the questions has the id from 1 but array lists start in 0

        // progressbar.progress = currentPosition // Assigning the progress bar the value
        // tv_progress.text = "$currentPosition" + "/" + progressbar.max

        // tv_question.text = question!!.question
        // iv_image.setImageResource(question.image) // Assigning the image

        // tv_option_one.text = question.optionOne  // Assigning the options the values
        // tv_option_two.text = question.optionTwo
        // tv_option_three.text = question.optionThree
        // tv_option_four.text = question.optionFour
    }

    private fun setQuestion(){  // Function to get the questions globally.

        // mCurrentPosition = 1  // This was for testing purposes.
        val question = mQuestionList!![mCurrentPosition-1]

        defaultOptionsView()  // So that all buttons return to the default view after clicking.

        if (mCurrentPosition == mQuestionList!!.size){
            btn_submit.text = "FINISH"
        }else{
            btn_submit.text = "SUBMIT"
        }

        progressbar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/" + progressbar.max

        tv_question.text = question!!.question
        iv_image.setImageResource(question.image)

        tv_option_one.text = question.optionOne
        tv_option_two.text = question.optionTwo
        tv_option_three.text = question.optionThree
        tv_option_four.text = question.optionFour

    }

    private fun defaultOptionsView(){

        val options = ArrayList<TextView>()  // Array list of UI elements can be created.
        // Adding options value to the 'option' array list.
        options.add(0, tv_option_one)
        options.add(1, tv_option_two)
        options.add(2, tv_option_three)
        options.add(3, tv_option_four)

        for (option in options){

            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT  // Style in which the text will be displayed.
            // To set bg a drawable file, the "ContextCompat" is used.
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }
    }

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.tv_option_one -> {
                selectedOptionView(tv_option_one, 1)
            }
            R.id.tv_option_two -> {
                selectedOptionView(tv_option_two, 2)
            }
            R.id.tv_option_three -> {
                selectedOptionView(tv_option_three, 3)
            }
            R.id.tv_option_four -> {
                selectedOptionView(tv_option_four, 4)
            }
            R.id.btn_submit -> {
                if (mSelectedOptionPosition == 0){   // This variable's default value starts at 0
                    mCurrentPosition ++

                    when{
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }else -> {
                        val intent = Intent(this, ResultActivity::class.java)
                        intent.putExtra(Constants.USER_NAME, mUserName)
                        intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                        intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionList!!.size)
                        startActivity(intent)
                        finish()

                        // Toast.makeText(this,
                           // "You have successfully completed the quiz", Toast.LENGTH_SHORT).show()
                        }
                    }
                }else{
                    val question = mQuestionList?.get(mCurrentPosition-1)
                    if (question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if (mCurrentPosition == mQuestionList!!.size){
                        btn_submit.text = "FINISH"
                    }else{
                        btn_submit.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int){

        when(answer){
            1 -> {
                tv_option_one.background = ContextCompat.getDrawable(this, drawableView)
            }
            2 -> tv_option_two.background = ContextCompat.getDrawable(this, drawableView)
            3 -> tv_option_three.background = ContextCompat.getDrawable(this, drawableView)
            4 -> tv_option_four.background = ContextCompat.getDrawable(this, drawableView)
        }

    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int){

        defaultOptionsView()  // We reset the buttons view
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD) // Style in which the text will be displayed.
        // To set bg a drawable file, the "ContextCompat" is used.
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
    }
}