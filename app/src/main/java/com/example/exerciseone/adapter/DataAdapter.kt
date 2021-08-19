package com.example.exerciseone.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.exerciseone.R
import com.example.exerciseone.model.ModelClass
import com.example.exerciseone.model.Row
import kotlinx.android.synthetic.main.row_item.view.*


class DataAdapter(private val dataList: List<Row>, val context: Context) : RecyclerView.Adapter<DataAdapter.DataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row_item,parent,false)
        return DataViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val currentItem = dataList[position]
        holder.tvTitle.text=currentItem.title
        holder.tvDesc.text=currentItem.description

        if (currentItem.imageHref!==null){
          Glide.with(context).load(currentItem.imageHref).error(R.drawable.newsimgicon).placeholder(R.drawable.newsimgicon).into(holder.imageView)
          //https://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/American_Beaver.jpg/220px-American_Beaver.jpg
        }else{
            holder.imageView.setImageResource(R.drawable.newsimgicon)
        }

    }

    override fun getItemCount()=dataList.size

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val imageView: ImageView = itemView.imgProfile
        val tvTitle: TextView = itemView.tvTitle
        val tvDesc: TextView = itemView.tvDesc

    }
}