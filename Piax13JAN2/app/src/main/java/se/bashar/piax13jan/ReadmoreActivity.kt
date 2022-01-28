package se.bashar.piax13jan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ReadmoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_readmore)

        val fruit = intent.getStringExtra("fruit")

        val fruitTV = findViewById<TextView>(R.id.fruitTextView)

        fruitTV.text = fruit

    }
}