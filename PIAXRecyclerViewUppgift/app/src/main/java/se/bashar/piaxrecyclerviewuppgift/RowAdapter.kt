package se.bashar.piaxrecyclerviewuppgift

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RowAdapter() : RecyclerView.Adapter<MyViewHolder>() {

    var list = mutableListOf<String>("")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val viewHolder = MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_rowadapter, parent, false))
        return viewHolder
    }
    override fun getItemCount(): Int {
        return list.size
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.hejsan.text = list[position]


    }
}
class MyViewHolder (view: View) : RecyclerView.ViewHolder(view) {

    var hejsan = view.findViewById<TextView>(R.id.rowTV)

}