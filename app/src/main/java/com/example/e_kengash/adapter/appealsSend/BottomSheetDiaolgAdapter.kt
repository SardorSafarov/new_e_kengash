package com.example.e_kengash.adapter.appealsSend

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e_kengash.R
import com.example.e_kengash.databinding.ItemBottomSheetDiaolgAppealsBinding
import com.example.e_kengash.databinding.ItemHomeNewsBinding
import com.example.e_kengash.network.entity.appealsSend.type.Result
import com.example.e_kengash.network.entity.more.article.New


class BottomSheetDiaolgAdapter(private val listener: onClickListener ) : RecyclerView.Adapter<BottomSheetDiaolgAdapter.ViewHolder>() {

    private var list: MutableList<Result> = mutableListOf()
    interface onClickListener{
        fun setOnClickLister(text: String)
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bind = ItemBottomSheetDiaolgAppealsBinding.bind(itemView)
        fun item(item: Result) {
           bind.title.text = item.name
            itemView.setOnClickListener {
                listener.setOnClickLister(item.name)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BottomSheetDiaolgAdapter.ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_bottom_sheet_diaolg_appeals, parent, false)
    )

    override fun onBindViewHolder(holder: BottomSheetDiaolgAdapter.ViewHolder,position: Int) {
        holder.item(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun setData(list: List<Result>) {
        this.list = list as MutableList<Result>
        notifyDataSetChanged()
    }
}