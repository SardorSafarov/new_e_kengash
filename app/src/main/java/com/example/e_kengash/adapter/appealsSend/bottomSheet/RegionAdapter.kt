package com.example.e_kengash.adapter.appealsSend.bottomSheet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e_kengash.R
import com.example.e_kengash.databinding.ItemBottomSheetDiaolgAppealsBinding
import com.example.e_kengash.network.entity.appealsSend.region.Addresse


class RegionAdapter(private val listener: onClickListener) : RecyclerView.Adapter<RegionAdapter.ViewHolder>() {

    private var list: MutableList<Addresse> = mutableListOf()
    interface onClickListener{
        fun setOnClickListerRegion(text: Addresse)
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bind = ItemBottomSheetDiaolgAppealsBinding.bind(itemView)
        fun item(item: Addresse) {
            bind.title.text = item.name
            itemView.setOnClickListener {
                listener.setOnClickListerRegion(item)
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

    fun setData(list: List<Addresse>) {
        this.list = list as MutableList<Addresse>
        notifyDataSetChanged()
    }
}