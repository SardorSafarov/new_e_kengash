package com.example.e_kengash.adapter.article

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e_kengash.R
import com.example.e_kengash.databinding.ItemHomeNewsBinding
import com.example.e_kengash.network.entity.more.article.New


class ArticleAdapter(private val listener: onClickListener ) : RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

    private var list: MutableList<New> = mutableListOf()
    interface onClickListener{
        fun setOnClickLister(text: String)
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bind = ItemHomeNewsBinding.bind(itemView)
        fun item(item: New) {
            bind.title.text = item.title
            bind.time.text = item.date
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ArticleAdapter.ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_home_news, parent, false)
    )

    override fun onBindViewHolder(holder: ArticleAdapter.ViewHolder,position: Int) {
        holder.item(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun setData(list: List<New>) {
        this.list = list as MutableList<New>
        notifyDataSetChanged()
    }
}