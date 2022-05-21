package com.example.e_kengash.adapter.appealsSend.bottomSheet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e_kengash.R
import com.example.e_kengash.adapter.entity.AddressEntity
import com.example.e_kengash.databinding.ItemBottomSheetDiaolgAppealsBinding


class MFYAdapter(private val listener: onClickListener) : RecyclerView.Adapter<MFYAdapter.ViewHolder>() {

    private var list: MutableList<AddressEntity> = mutableListOf()
    interface onClickListener{
        fun setOnClickListerMFY(text: AddressEntity)
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bind = ItemBottomSheetDiaolgAppealsBinding.bind(itemView)
        fun item(item: AddressEntity) {
            bind.title.text = item.name
            itemView.setOnClickListener {
                listener.setOnClickListerMFY(item)
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

    fun setData(list: ArrayList<AddressEntity>) {
        this.list = list
        notifyDataSetChanged()
    }
}