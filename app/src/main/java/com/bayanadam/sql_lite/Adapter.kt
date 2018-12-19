package com.bayanadam.sql_lite

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class Adapter(var context:Context,data:ArrayList<Subject>) : RecyclerView.Adapter<Adapter.ViewHoldr>() {





    var data:List<Subject>


    init {

        this.data = data
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoldr {

        val layout = LayoutInflater.from(context).inflate(R.layout.item_subjct,parent,false)

        return ViewHoldr(layout)

    }


    override fun onBindViewHolder(holder: ViewHoldr, position: Int) {

        holder.title.text =data[position].title
        holder.desc.text = data[position].desc
        holder.id.text = data[position].id


    }


    override fun getItemCount(): Int {
        return data.size
    }


    class ViewHoldr(item:View) : RecyclerView.ViewHolder(item) {


        var title:TextView
        var id:TextView
        var desc:TextView

        init {


            title = item.findViewById(R.id.title_textview)
            id = item.findViewById(R.id.id_textview)
            desc = item.findViewById(R.id.desc_textview)
        }



    }
}