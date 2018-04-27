package com.example.yaj.geoquiz

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class QuizActivity : AppCompatActivity() {

    private lateinit var mTrueButton: Button
    private lateinit var mFalseButton: Button
    private lateinit var mNextButton: Button
    private lateinit var mQuestionTextView: TextView
    private var mQuestionBank: List<Question> = listOf(
            Question(R.string.question_australia, true),
            Question(R.string.question_oceans, true),
            Question(R.string.question_mideast, false),
            Question(R.string.question_africa, false),
            Question(R.string.question_americas, true),
            Question(R.string.question_asia, true)
    )

    private var mCurrentIndex: Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        mTrueButton = findViewById(R.id.true_button)
        mTrueButton.setOnClickListener({ checkAnswer(true)
        })
        mFalseButton = findViewById(R.id.false_button)
        mFalseButton.setOnClickListener({ checkAnswer(false)
        })
        mQuestionTextView = findViewById(R.id.question_text_view)
        mQuestionTextView.setText(mQuestionBank[mCurrentIndex].mTextResId)

        mNextButton = findViewById(R.id.next_button)
        mNextButton.setOnClickListener({v: View ->
            mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.size
            updateQuestion()
        })
    }

    private fun updateQuestion(): Unit {
        mQuestionTextView.setText(mQuestionBank[mCurrentIndex].mTextResId)
    }

    private fun checkAnswer(userPressedTrue: Boolean) {
        val answerIsTrue = mQuestionBank[mCurrentIndex].mAnswerTrue
        var messageResId = 0
        messageResId =  if (userPressedTrue == answerIsTrue)  R.string.correct_toast else R.string.incorrect_toast
        var toast: Toast = Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.TOP, 0, 0)
        toast.show()

    }
}
