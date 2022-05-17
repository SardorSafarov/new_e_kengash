package com.example.e_kengash.adapter.more.council

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.e_kengash.R
import com.example.e_kengash.databinding.ItemHomeNewsBinding
import com.example.e_kengash.databinding.ItemSecretariatRegionBinding
import com.example.e_kengash.network.entity.more.council.changeDeputat.article.Meeting
import com.example.e_kengash.network.entity.more.council.deputat.Deputy


class ChangeDeputatArticleAdapter(
    private val listener: onClickListener,
    private val context: Context
) : RecyclerView.Adapter<ChangeDeputatArticleAdapter.ViewHolder>() {

    private var list: MutableList<Meeting> = mutableListOf()

    interface onClickListener {
        fun setOnClickLister(id: Deputy)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bind = ItemHomeNewsBinding.bind(itemView)
        fun item(item: Meeting) {
            bind.apply {
                title.text = item.fields.title
                time.text = item.fields.date
                Glide.with(context).load("http://e-kengash.uz/media/".plus(item.fields.image))
                    .placeholder(R.drawable.ic_person)
                    .into(image)
            }
//            itemView.setOnClickListener {
//                listener.setOnClickLister(item)
//            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChangeDeputatArticleAdapter.ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_home_news, parent, false)
    )

    override fun onBindViewHolder(holder: ChangeDeputatArticleAdapter.ViewHolder, position: Int) {
        holder.item(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun setData(list: List<Meeting>) {
        this.list = list as MutableList<Meeting>
        notifyDataSetChanged()
    }
}