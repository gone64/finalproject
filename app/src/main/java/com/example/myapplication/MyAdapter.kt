package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MyAdapter (private val context: Context,private val dataList: List<DataClass>):
    RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.product,parent,false)
        return MyViewHolder(view)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var imageView = holder.itemView.findViewById<ImageView>(R.id.rec_Image)
        Glide.with(holder.itemView).load(dataList[position].proUrl).into(imageView)
        holder.recName.setText(dataList[position].proName)
        holder.recPrice.setText(dataList[position].proPrice)
        holder.recLoc.setText(dataList[position].proLoc)
        holder.recDesc.setText(dataList[position].proDesc)
        holder.number.setText(dataList[position].number)

    }

    override fun getItemCount(): Int {
        return dataList.size
    }

}
class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    var recName: TextView
    var recPrice: TextView
    var recLoc: TextView
    var recDesc: TextView
    val number: TextView



    init {
        recName = itemView.findViewById(R.id.recName)
        recPrice = itemView.findViewById(R.id.recPrice)
        recLoc = itemView.findViewById(R.id.recLocation)
        recDesc = itemView.findViewById(R.id.recDesc)
        number = itemView.findViewById(R.id.recCond)

    }
}