package com.example.e_kengash.adapter.more.activities

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.e_kengash.R
import com.example.e_kengash.databinding.ItemHomeNewsBinding
import com.example.e_kengash.network.entity.more.activites.New




class ActivitiesAdapter(private val listener: onClickListener,private val context: Context, val domen:String) : RecyclerView.Adapter<ActivitiesAdapter.ViewHolder>() {

    private var list: ArrayList<New> = arrayListOf()
    interface onClickListener{
        fun itemSetOnClickLister(text: String)
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bind = ItemHomeNewsBinding.bind(itemView)
        fun item(item: New) {
            bind.apply {
                title.text = item.title
                time.text = item.date
                Glide.with(context).load(domen.plus(item.image)).into(image)
            }

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ):ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_home_news, parent, false)
    )

    override fun onBindViewHolder(holder:ViewHolder,position: Int) {
        holder.item(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun setData(list: List<New>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }
}