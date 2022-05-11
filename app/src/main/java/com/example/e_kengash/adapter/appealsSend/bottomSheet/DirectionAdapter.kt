package com.example.e_kengash.adapter.appealsSend.bottomSheet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e_kengash.R
import com.example.e_kengash.databinding.ItemBottomSheetDiaolgAppealsBinding
import com.example.e_kengash.network.entity.appealsSend.type.Direction


class DirectionAdapter(private val listener: onClickListener) : RecyclerView.Adapter<DirectionAdapter.ViewHolder>() {

    private var list: MutableList<Direction> = mutableListOf()
    interface onClickListener{
        fun setOnClickListerDirection(text: Direction)
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bind = ItemBottomSheetDiaolgAppealsBinding.bind(itemView)
        fun item(item: Direction) {
           bind.title.text = item.name
            itemView.setOnClickListener {
                listener.setOnClickListerDirection(item)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_bottom_sheet_diaolg_appeals, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.item(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun setData(list: List<Direction>) {
        this.list = list as MutableList<Direction>
        notifyDataSetChanged()
    }
}