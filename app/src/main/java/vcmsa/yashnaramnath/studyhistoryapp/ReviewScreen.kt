package vcmsa.yashnaramnath.studyhistoryapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ReviewScreen : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_review_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Code Starts here
        val tvReview = findViewById<TextView>(R.id.tvReview)
        val tvAnswers = findViewById<TextView>(R.id.tvAnswers)
        val btnBack = findViewById<Button>(R.id.btnBack)

        btnBack.setOnClickListener {
            Log.d("Button_Test", "Moving back to Score Screen")
            val intent = Intent(this, ScoreScreen::class.java)
            startActivity(intent)
            finish()

        }
    }
}
