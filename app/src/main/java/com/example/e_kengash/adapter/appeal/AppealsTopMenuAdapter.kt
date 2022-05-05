package com.example.e_kengash.adapter.appeal

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e_kengash.R
import com.example.e_kengash.databinding.ItemAppleasTopMenuBinding
import com.example.e_kengash.repetitive.D

class AppealsTopMenuAdapter(private val listener: onClickListener ) : RecyclerView.Adapter<AppealsTopMenuAdapter.ViewHolder>() {

    private var list: MutableList<String> = mutableListOf()
    private var row_index: Int = 0
    interface onClickListener{
        fun setOnClickLister(text: String)
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bind = ItemAppleasTopMenuBinding.bind(itemView)
        fun item(text: String) {
            bind.title.text = text
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AppealsTopMenuAdapter.ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_appleas_top_menu, parent, false)
    )

    override fun onBindViewHolder(holder: AppealsTopMenuAdapter.ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.item(list[position])
        holder.itemView.setOnClickListener {
            row_index = position
            listener.setOnClickLister(list[position])
            notifyDataSetChanged()
        }
        if (row_index == position) {

            holder.bind.title.apply {
                setBackgroundResource(R.drawable.bg_text_blue)
                setTextColor(Color.WHITE)
            }

        } else {
            holder.bind.title.apply {
                setBackgroundResource(R.color.white)
                setTextColor(Color.GRAY)
            }
        }
    }

    override fun getItemCount(): Int = list.size

    fun setData(list: MutableList<String>) {
        this.list = list
        notifyDataSetChanged()
    }
}