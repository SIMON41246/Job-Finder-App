package com.example.jobsapi.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jobsapi.R
import com.example.jobsapi.data.Data

class Adapter(
    private val context: Context, private val list: ArrayList<Data>, private val readmore: Readmore,
) :
    RecyclerView.Adapter<Adapter.RH>() {
    class RH(view: View) : RecyclerView.ViewHolder(view) {
        val slug = view.findViewById<TextView>(R.id.title)
        val tags = view.findViewById<TextView>(R.id.tags)
        val location = view.findViewById<TextView>(R.id.location)
        val btn = view.findViewById<Button>(R.id.btnReadMore)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RH {
        val view = LayoutInflater.from(context).inflate(R.layout.item, parent, false)
        return RH(view)
    }

    override fun onBindViewHolder(holder: RH, position: Int) {
        holder.slug.text = list[holder.adapterPosition].slug
        holder.tags.text = list[holder.adapterPosition].companyName
        holder.location.text =
            list[holder.adapterPosition].location
        holder.btn.setOnClickListener {
            readmore.click(list[holder.adapterPosition])
        }


    }


    override fun getItemCount(): Int {
        return list.size
    }

    interface Readmore {
        fun click(data: Data)
    }


}

