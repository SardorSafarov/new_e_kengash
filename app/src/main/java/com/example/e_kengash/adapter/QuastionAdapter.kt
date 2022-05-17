package com.example.e_kengash.adapter

import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e_kengash.R
import com.example.e_kengash.databinding.ItemQuestionBinding
import com.example.e_kengash.repetitive.gone
import com.example.e_kengash.repetitive.visible


class QuastionAdapter(private val listener: onClickListener) :
    RecyclerView.Adapter<QuastionAdapter.ViewHolder>() {

    private var list: MutableList<com.example.e_kengash.network.entity.more.council.data.Info> = mutableListOf()

    interface onClickListener {
        fun setOnClickLister(text: String)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bind = ItemQuestionBinding.bind(itemView)
        var bool = true
        fun item(item: com.example.e_kengash.network.entity.more.council.data.Info) {
            bind.apply {
                question.text = item.title
                answer.text = Html.fromHtml(item.content)
                itemView.setOnClickListener {
                    when(bool){
                        true->{
                            answer.visible()
                            bool = false
                        }
                        else->{
                            answer.gone()
                            bool = true
                        }
                    }
                }
            }

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): QuastionAdapter.ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_question, parent, false)
    )

    override fun onBindViewHolder(holder: QuastionAdapter.ViewHolder, position: Int) {
        holder.item(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun setData(list: List<com.example.e_kengash.network.entity.more.council.data.Info>) {
        this.list = list as MutableList<com.example.e_kengash.network.entity.more.council.data.Info>
        notifyDataSetChanged()
    }
}