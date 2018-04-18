package com.example.yaj.geoquiz

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class QuizActivity : AppCompatActivity() {

    private lateinit var mTrueButton: Button
    private lateinit var mFalseButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        mTrueButton = findViewById(R.id.true_button)
        mTrueButton.setOnClickListener({ v: View -> })
        mFalseButton = findViewById(R.id.false_button)
    }
}
