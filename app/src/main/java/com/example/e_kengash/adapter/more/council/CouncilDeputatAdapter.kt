package com.example.e_kengash.adapter.more.council

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e_kengash.R
import com.example.e_kengash.databinding.ItemSecretariatRegionBinding
import com.example.e_kengash.network.entity.more.council.deputat.Deputy


class CouncilDeputatAdapter(private val listener: onClickListener ) : RecyclerView.Adapter<CouncilDeputatAdapter.ViewHolder>() {

    private var list: MutableList<Deputy> = mutableListOf()
    interface onClickListener{
        fun setOnClickLister(id: Deputy)
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bind = ItemSecretariatRegionBinding.bind(itemView)
        fun item(item: Deputy) {
            bind.apply {
              fullName.text = item.full_name
                position.text = item.position
            }
            itemView.setOnClickListener {
                listener.setOnClickLister(item)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CouncilDeputatAdapter.ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_secretariat_region, parent, false)
    )

    override fun onBindViewHolder(holder: CouncilDeputatAdapter.ViewHolder,position: Int) {
        holder.item(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun setData(list: List<Deputy>) {
        this.list = list as MutableList<Deputy>
        notifyDataSetChanged()
    }
}