package vcmsa.yashnaramnath.studyhistoryapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ScoreScreen : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score_screen)
        val mainLayout = findViewById<ConstraintLayout>(R.id.main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //code starts here
        val score = intent.getIntExtra("score", 0)
        val total = intent.getIntExtra("total", 5)

        Log.d("ScoreScreen", "Score: $score, Total: $total")


        val tvFeedback = findViewById<TextView>(R.id.tvFeedback)
        val btnReview = findViewById<Button>(R.id.btnReview)
        val btnexit = findViewById<Button>(R.id.btnexit)
        val tvScore = findViewById<TextView>(R.id.tvScore)
        tvScore.text = "Your Score is: $score out of $total!"

        val feedback = when {
            score == total -> "Excellent! You got a perfect score!"
            score >= total * 3 / 4 -> "Great job! You know your stuff."
            score >= total / 2 -> "Good effort! A bit more practice will help."
            else -> "Keep trying! Review the answers and try again."
        }

        tvFeedback.text = feedback

        btnReview.setOnClickListener {
            Log.d("Button_Test", "Moving to ReviewScreen")
            startActivity(Intent(this, ReviewScreen::class.java))
            finish()
        }

        btnexit.setOnClickListener {
            finishAffinity()
        }
    }
}

