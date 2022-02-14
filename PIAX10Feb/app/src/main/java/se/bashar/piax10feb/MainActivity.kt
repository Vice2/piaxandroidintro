package se.bashar.piax10feb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import se.bashar.piax10feb.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)

        val view = binding.root

        setContentView(view)

        supportFragmentManager.beginTransaction().replace(R.id.mainFragCon, SecondFragment()).commit()

        binding.fancyTV.text = "Banan"
        findViewById<TextView>(R.id.fancyTV).text = "Banan"

        binding.changeTextButton.setOnClickListener {
            binding.fancyTV.text = "Apelsin"
        }

        binding.goFirstButton.setOnClickListener(){
          supportFragmentManager.beginTransaction().replace(R.id.mainFragCon, FirstFragment()).commit()
        }

        binding.goSecondButton.setOnClickListener(){
          supportFragmentManager.beginTransaction().replace(R.id.mainFragCon, SecondFragment()).commit()
        }


    }
}