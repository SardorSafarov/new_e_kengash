package com.example.e_kengash.adapter.more.youth

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.e_kengash.R
import com.example.e_kengash.databinding.ItemSecretariatRegionBinding
import com.example.e_kengash.network.entity.more.council.deputat.Deputy
import com.example.e_kengash.network.entity.more.youth.deputat.Info


class YouthDeputatAdapter(
    private val listener: onClickListener,
    private val context: Context?,
    private val accessDomen2: String
) : RecyclerView.Adapter<YouthDeputatAdapter.ViewHolder>() {

    private var list: MutableList<Info> = mutableListOf()

    interface onClickListener {
        fun setOnClickLister(id: Info)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bind = ItemSecretariatRegionBinding.bind(itemView)
        fun item(item: Info) {
            bind.apply {
                Glide.with(context!!).load(accessDomen2.plus(item.image)).into(image)
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
    ): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_secretariat_region, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.item(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun setData(list: List<Info>) {
        this.list = list as MutableList<Info>
        notifyDataSetChanged()
    }
}
