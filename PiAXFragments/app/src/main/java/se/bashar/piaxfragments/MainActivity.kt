package se.bashar.piaxfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentContainerView

class MainActivity : AppCompatActivity() {

    var theStartFrag = StartFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportFragmentManager.beginTransaction().add(R.id.fragConatiner, StartFragment()).commit()

        val fragcont = findViewById<FragmentContainerView>(R.id.fragConatiner)

        findViewById<Button>(R.id.goOneButton).setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragConatiner, theStartFrag).commit()

        }

        findViewById<Button>(R.id.goTwoButton).setOnClickListener {
            supportFragmentManager.beginTransaction().add(R.id.fragConatiner, SecondFragment()).addToBackStack(null).commit()

        }
    }
}