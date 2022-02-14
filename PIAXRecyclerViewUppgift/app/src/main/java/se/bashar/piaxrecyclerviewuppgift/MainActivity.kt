package se.bashar.piaxrecyclerviewuppgift

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    var myAdapter = RowAdapter()
    var row = "Rad "
    var number = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rowview = findViewById<RecyclerView>(R.id.rowRV)

        rowview.layoutManager = LinearLayoutManager(this)
        rowview.adapter = myAdapter






        findViewById<Button>(R.id.addButton).setOnClickListener {
            number++
            myAdapter.list.add(row + number)


            myAdapter.notifyDataSetChanged()


        }

    }
}