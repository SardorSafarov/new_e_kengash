package com.example.e_kengash.adapter.more.discussion

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e_kengash.R
import com.example.e_kengash.databinding.ItemDiscussionBinding
import com.example.e_kengash.network.entity.more.discussion.offer.Result


class DiscussinOffertAdapter(private val listener:likeDislikeSetOnClickListener) :
    RecyclerView.Adapter<DiscussinOffertAdapter.ViewHolder>() {

    private var list: MutableList<Result> = mutableListOf()
    interface likeDislikeSetOnClickListener{
        fun onClickListener(boolean: Boolean)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bind = ItemDiscussionBinding.bind(itemView)
        fun item(item: Result) {
            bind.apply {
                title.text = item.title
                fullName.text = item.full_name
                totalComment.text = item.total_comment.toString()
                totalLike.text = item.total_like.toString()
                totalDislike.text = item.total_dislike.toString()
                like.setOnClickListener {
                    listener.onClickListener(true)
                }
                dislike.setOnClickListener {
                    listener.onClickListener(false)
                }
            }


        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_discussion, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.item(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun setData(info: List<Result>) {
        this.list = info as MutableList<Result>
        notifyDataSetChanged()
    }
}