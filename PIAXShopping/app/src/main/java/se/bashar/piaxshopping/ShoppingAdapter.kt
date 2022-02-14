package se.bashar.piaxshopping

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ShoppingAdapter() : RecyclerView.Adapter<ShoppingViewHolder>() {

    lateinit var shopfrag : ShoppinglistFragment



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val vh = ShoppingViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false))
        return vh
    }

    override fun getItemCount(): Int {

        shopfrag.model.shopitems.value?.let {
            return it.size
        }

        return 0
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {

        var currentItem = shopfrag.model.shopitems.value!![position]

        holder.titletextview.text = currentItem.shoptitle
        holder.amounttextview.text = currentItem.shopamount.toString()

        if(currentItem.shopdone == true)
        {
            holder.donetextview.visibility = View.VISIBLE
        } else {
            holder.donetextview.visibility = View.INVISIBLE
        }

        holder.itemView.setOnClickListener {
           shopfrag.clickrow(position)
        }
    }
    
}

class ShoppingViewHolder (view: View) : RecyclerView.ViewHolder(view) {

    var titletextview = view.findViewById<TextView>(R.id.shopitemTitleTV)
    var amounttextview = view.findViewById<TextView>(R.id.shopitemAmountTV)
    var donetextview = view.findViewById<TextView>(R.id.shopitemDoneTV)

}