package com.hdz.holdon.test

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.hdz.holdon.R


class Adapter(context: Context, dataList: MutableList<String>?) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var onItemClickListener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }


    private var context: Context? = null
    private var dataList: List<String>? = null

    init {
        this.context = context
        this.dataList = dataList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView: View =
            LayoutInflater.from(context).inflate(R.layout.item_text_title_layout, parent, false)
        return Holder(itemView)
    }

    override fun getItemCount(): Int = dataList!!.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is Holder) {
            val title: String = dataList!!.get(position)
            holder.title!!.text = title;
        }


    }

    inner class Holder(itemView: View?) : ViewHolder(itemView!!), View.OnClickListener {
        var title: TextView? = null

        init {
            title = itemView!!.findViewById(R.id.text_title_item)
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            this@Adapter.onItemClickListener?.onItemClick(layoutPosition)
        }
    }

}


