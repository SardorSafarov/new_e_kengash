package com.example.e_kengash.adapter.notif

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e_kengash.R
import com.example.e_kengash.databinding.ItemNotifBinding
import com.example.e_kengash.network.entity.notif.Result


class NotifAdapter(private val listener: onClickListener ) : RecyclerView.Adapter<NotifAdapter.ViewHolder>() {

    private var list: MutableList<Result> = mutableListOf()
    interface onClickListener{
        fun setOnClickLister(text: String)
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bind = ItemNotifBinding.bind(itemView)
        fun item(item: Result) {
            bind.apply {
                status.text = item.status
                title.text = item.title
                content.text = item.content
                created.text = item.created
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NotifAdapter.ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_notif, parent, false)
    )

    override fun onBindViewHolder(holder: NotifAdapter.ViewHolder,position: Int) {
        holder.item(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun setData(list: List<Result>) {
        this.list = list as MutableList<Result>
        notifyDataSetChanged()
    }
}