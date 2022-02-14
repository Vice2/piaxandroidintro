package se.bashar.piax13jan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.startTextView).text = "START"

        findViewById<Button>(R.id.goReadmoreButton).setOnClickListener {

            val intent = Intent(this, ReadmoreActivity::class.java)

            intent.putExtra("fruit", "Banan")

            startActivity(intent)
        }


    }
}