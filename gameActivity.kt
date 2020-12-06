package com.puja.androidapptest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.*
import androidx.core.view.isVisible
import kotlin.random.Random
import android.widget.Button
import android.widget.TextView

class gameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val firstBtn: Button = findViewById(R.id.btn1)
        val secondBtn: Button = findViewById(R.id.btn2)
        val resultTextView: TextView = findViewById(R.id.tvResult)
        val correctTextView : TextView = findViewById(R.id.tvcorrect)
        val incorrectTextView : TextView = findViewById(R.id.tvincorrect)
        val restartBtn: Button = findViewById(R.id.btnrestart)

        randomNumberGen(firstBtn,secondBtn)
        var count: Int = 0
        var correctAns = 0
        var incorrectAns = 0

        firstBtn.setOnClickListener{
            count++
            val userClick = firstBtn.text.toString().toInt()
            val btnFirstVal = firstBtn.text.toString().toInt()
            val btnSecondVal = secondBtn.text.toString().toInt()
            if (btnFirstVal>btnSecondVal && btnFirstVal == userClick){
                correctAns++


            }
            else{
                incorrectAns++
            }
            randomNumberGen(firstBtn, secondBtn)
            autoDisable(count, firstBtn,secondBtn, correctAns, incorrectAns,correctTextView,incorrectTextView,resultTextView,restartBtn)
        }

        secondBtn.setOnClickListener{
            count++
            val userClick = secondBtn.text.toString().toInt()
            val btnFirstVal = firstBtn.text.toString().toInt()
            val btnSecondVal = secondBtn.text.toString().toInt()
            if (btnSecondVal>btnFirstVal && btnSecondVal == userClick){
                correctAns++

            }
            else{
                incorrectAns++
            }
            randomNumberGen(firstBtn, secondBtn)
            autoDisable(count, firstBtn,secondBtn, correctAns,incorrectAns,correctTextView,incorrectTextView,resultTextView,restartBtn)
        }

        restartBtn.setOnClickListener{
            count = 0
            secondBtn.isClickable = true
            secondBtn.isClickable=true
            restartBtn.isVisible = false
            resultTextView.visibility= View.INVISIBLE
            correctTextView.visibility = View.INVISIBLE
            incorrectTextView.visibility = View.INVISIBLE
            correctTextView.visibility = View.INVISIBLE
            correctAns = 0
            incorrectAns = 0

            randomNumberGen(firstBtn, secondBtn)
        }
    }

    private fun randomNumberGen(btnFirst: Button, btnSecond:Button){
        btnFirst.text = (0..100).shuffled().random().toString()
        btnSecond.text = (0..100).shuffled().random().toString()
    }
    private fun autoDisable(count : Int, btnFirst: Button, btnSecond: Button, correctAns:Int, incorrectAns:Int,tvCorrect:TextView,tvIncorrect:TextView, tvResult:TextView, btnRestart:Button){
        if (count == 10){
            btnFirst.isClickable = false
            btnFirst.text=""
            btnSecond.isClickable = false
            btnSecond.text =""
            if (correctAns<incorrectAns) tvResult.text = "Sorry! you lost the game."
            else tvResult.text = "Congratulations! You won the game"
            tvCorrect.text = "You guessed $correctAns answer correct."
            tvIncorrect.text = "You made $incorrectAns answer incorrect"
            tvCorrect.visibility = View.VISIBLE
            tvIncorrect.visibility = View.VISIBLE
            tvResult.visibility = View.VISIBLE
            btnRestart.visibility = View.VISIBLE
        }
    }

}


