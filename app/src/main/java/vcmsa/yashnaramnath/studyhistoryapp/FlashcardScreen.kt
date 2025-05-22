package vcmsa.yashnaramnath.studyhistoryapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

data class Question(val text: String, val answer: Boolean)

class FlashcardScreen : AppCompatActivity() {
    private lateinit var questionText: TextView
    private lateinit var feedbackTextView: TextView
    private lateinit var btnTrue: Button
    private lateinit var btnFalse: Button
    private lateinit var btnNext: Button

    private val Questions = listOf(
        Question("1. The Great Wall of China was built to protect against invasions.", true),
        Question("2. The Magna Carta was signed in France.",false),
        Question("3. World War I ended in 1918.", true),
        Question("4. Knights followed a code of conduct called chivalry.", true),
        Question("5. Nelson Mandela was the first black president of South Africa.", true)
    )
    private var currentQuestionIndex = 0
    private var score = 0


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_flashcard_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Code starts here
        questionText = findViewById(R.id.tvQuestionText)
        feedbackTextView = findViewById(R.id.tvFeedback)
        btnTrue = findViewById(R.id.btnTrue)
        btnFalse = findViewById(R.id.btnFalse)
        btnNext = findViewById(R.id.btnNext)

        showQuestion()

        btnTrue.setOnClickListener {
            checkAnswer(true)
        }
        btnFalse.setOnClickListener {
            checkAnswer(false)
        }
        btnNext.setOnClickListener {
            currentQuestionIndex++
            if (currentQuestionIndex < Questions.size) {
                showQuestion()
            } else {
                val intent = Intent(this, ScoreScreen::class.java)
                intent.putExtra("score", score)
                intent.putExtra("total", Questions.size)
                startActivity(intent)
                finish()
            }
        }
    }
    private fun showQuestion() {
        val currentQuestion = Questions[currentQuestionIndex]
        questionText.text = currentQuestion.text
        feedbackTextView.text = ""
        btnTrue.isEnabled = true
        btnFalse.isEnabled = true
        btnNext.isEnabled = false

    }
    private fun checkAnswer(userAnswer: Boolean) {
        val currentQuestion = Questions[currentQuestionIndex]
        if (userAnswer == currentQuestion.answer) {
            score++
            feedbackTextView.text = "Correct!"
        } else {
            feedbackTextView.text = "Incorrect!"
        }
        btnTrue.isEnabled = false
        btnFalse.isEnabled = false
        btnNext.isEnabled = true


    }

}

