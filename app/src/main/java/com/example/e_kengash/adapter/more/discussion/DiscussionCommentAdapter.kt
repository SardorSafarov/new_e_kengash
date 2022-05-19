package com.example.e_kengash.adapter.more.discussion

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e_kengash.R
import com.example.e_kengash.databinding.ItemCommentsBinding
import com.example.e_kengash.network.entity.more.discussion.offerAbout.comment.Result


class DiscussionCommentAdapter :
    RecyclerView.Adapter<DiscussionCommentAdapter.ViewHolder>() {

    private var list: MutableList<Result> = mutableListOf()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bind = ItemCommentsBinding.bind(itemView)
        fun item(item: Result) {
            bind.apply {
                item.apply {
                    fullName.text =full_name
                    date.text =created
                    contentt.text =content
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_comments, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.item(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun setData(results: List<Result>) {
        this.list = results as MutableList<Result>
        notifyDataSetChanged()
    }
}