package com.example.e_kengash.adapter.more.youth

import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e_kengash.R
import com.example.e_kengash.databinding.ItemQuestionBinding
import com.example.e_kengash.network.entity.more.youth.data.Info
import com.example.e_kengash.repetitive.gone
import com.example.e_kengash.repetitive.visible




class YouthDataAdapter() :
    RecyclerView.Adapter<YouthDataAdapter.ViewHolder>() {

    private var list: MutableList<Info> = mutableListOf()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bind = ItemQuestionBinding.bind(itemView)
        var bool = true
        fun item(item: Info) {
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
    ): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_question, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.item(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun setData(list: Info) {
        this.list = list as MutableList<Info>
        notifyDataSetChanged()
    }
}