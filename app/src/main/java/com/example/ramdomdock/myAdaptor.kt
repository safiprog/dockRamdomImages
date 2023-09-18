package com.example.ramdomdock

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class myAdaptor(val context:Context,val datas:ArrayList<model_class>):RecyclerView.Adapter<myAdaptor.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myAdaptor.ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(
            R.layout.item_resource,parent,false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: myAdaptor.ViewHolder, position: Int) {

        Glide.with(context).load(datas[position].url).into(holder.img)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    inner class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val img=itemView.findViewById<ImageView>(R.id.images)
    }

}