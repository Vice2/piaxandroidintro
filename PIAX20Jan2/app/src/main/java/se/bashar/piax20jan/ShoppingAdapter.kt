package layout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import se.bashar.piax20jan.R

class ShoppingAdapter() : RecyclerView.Adapter<ShoppingViewHolder>() {

    var shoppingList = mutableListOf<String>("Banan", "Päron", "Cykelpump")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val vh = ShoppingViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false))
        return vh
    }

    override fun getItemCount(): Int {
        return shoppingList.size
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {

        holder.itemTextview.text = shoppingList[position]

        holder.itemRemoveButton.setOnClickListener {
            // TODO: Krasch vid ta bort sista raden
            notifyItemRemoved(position)
            shoppingList.removeAt((position))

        }

    }

}

class ShoppingViewHolder (view: View) : RecyclerView.ViewHolder(view) {

    var itemTextview = view.findViewById<TextView>(R.id.shoppingitemTextView)
    var itemRemoveButton = view.findViewById<Button>(R.id.shoppingitemRemoveButton)

}