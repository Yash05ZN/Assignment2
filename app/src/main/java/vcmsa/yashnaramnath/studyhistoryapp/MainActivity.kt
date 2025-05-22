package vcmsa.yashnaramnath.studyhistoryapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import vcmsa.yashnaramnath.studyhistoryapp.R

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Code starts here
        val tvIntro = findViewById<TextView>(R.id.tvIntro)
        val tvTitle = findViewById<TextView>(R.id.tvTitle)
        val btnStart = findViewById<Button>(R.id.btnStart)
        val imgViewHistory = findViewById<ImageView>(R.id.imgViewHistory)

        //Start button logic
        btnStart.setOnClickListener {
            Log.d("Button_Test", "Button Clicked")
            val intent = Intent(this, FlashcardScreen::class.java)
            startActivity(intent)
            finish()

        }
    }
}