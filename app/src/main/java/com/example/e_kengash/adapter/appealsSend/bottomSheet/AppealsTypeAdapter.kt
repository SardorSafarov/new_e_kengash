package com.example.e_kengash.adapter.appealsSend.bottomSheet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e_kengash.R
import com.example.e_kengash.databinding.ItemBottomSheetDiaolgAppealsBinding
import com.example.e_kengash.network.entity.appealsSend.type.AppealType


class AppealsTypeAdapter(private val listener: onClickListener) : RecyclerView.Adapter<AppealsTypeAdapter.ViewHolder>() {

    private var list: MutableList<AppealType> = mutableListOf()
    interface onClickListener{
        fun setOnClickListerAppeals(text: AppealType)
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bind = ItemBottomSheetDiaolgAppealsBinding.bind(itemView)
        fun item(item: AppealType) {
           bind.title.text = item.name
            itemView.setOnClickListener {
                listener.setOnClickListerAppeals(item)
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

    fun setData(list: List<AppealType>) {
        this.list = list as MutableList<AppealType>
        notifyDataSetChanged()
    }
}