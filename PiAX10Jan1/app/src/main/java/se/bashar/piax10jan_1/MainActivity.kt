package se.bashar.piax10jan_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    var thecounter = 0

    lateinit var thenumber : TextView
    lateinit var resetButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        thenumber = findViewById<TextView>(R.id.numberTV)
        resetButton = findViewById(R.id.resetBtn)

        resetButton.setOnClickListener {
            thecounter = 0
            updatestuff()
        }

        val minusButton = findViewById<Button>(R.id.MinusBtn)

        minusButton.setOnClickListener {
            thecounter = thecounter - 1
            updatestuff()
        }

        val plusButton = findViewById<Button>(R.id.plusBtn)

        plusButton.setOnClickListener {
            thecounter = thecounter + 1
            updatestuff()
        }

        val addnumberButton = findViewById<Button>(R.id.addnumberBtn)

        addnumberButton.setOnClickListener {
            val addnumberEditText = findViewById<EditText>(R.id.addnumberET)

            val addnumberText = addnumberEditText.text.toString()

            Log.d("piaxdebug", "Textfältet är " + addnumberText)

            //val addnumber = addnumberText.toIntOrNull()

            /*
            if(addnumber != null)
            {
                thecounter = thecounter + addnumber
            }
             */

            /*
            //Swift:
            if let addnumber = Int(addnumberText){
                thecounter = thecounter + addnumber
            }

             */

            addnumberText.toIntOrNull()?.let {
                thecounter = thecounter + it
            }

            addnumberEditText.setText("")
            updatestuff()
        }
    }

    fun updatestuff()
    {
        if(thecounter<0)
        {
            thecounter = 0
        }

        if(thecounter == 0)
        {
            resetButton.visibility = View.INVISIBLE
        }else {
            resetButton.visibility = View.VISIBLE
        }

        thenumber.text = thecounter.toString()
    }
}