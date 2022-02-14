package se.bashar.piax20jan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import layout.ShoppingAdapter

class MainActivity : AppCompatActivity() {

    var shoppingAdapter = ShoppingAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var shoppingRV = findViewById<RecyclerView>(R.id.shoppingRV)

        shoppingRV.layoutManager = LinearLayoutManager(this)
        shoppingRV.adapter = shoppingAdapter

        findViewById<Button>(R.id.addButton).setOnClickListener {
            var addtext = findViewById<EditText>(R.id.addItemNameEditText).text.toString()
            var addamout = findViewById<EditText>(R.id.addItemAmountEditText).text.toString()

            var tempshop = ShopThing()
            tempshop.shopname = addtext
            tempshop.shopamount = addamout.toInt() //TODO: Hantera om inte siffra i texten

            shoppingAdapter.shoppingList.add(tempshop)

            shoppingAdapter.notifyItemInserted(shoppingAdapter.shoppingList.size-1)
        }

    }


}

/*

    0   Banan
    1   Kiwi
    2   Apelsin
    3   Utemöbler
    4   Ko


 */