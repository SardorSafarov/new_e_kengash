package com.example.e_kengash.adapter.more.activities

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.e_kengash.R
import com.example.e_kengash.databinding.ItemRecommendedBinding
import com.example.e_kengash.network.entity.more.activites.about.Recommended


class ActivitiesRecommendedAdapter(
    private val listener: onClickListener,
    private val context: Context,
    val domen: String
) : RecyclerView.Adapter<ActivitiesRecommendedAdapter.ViewHolder>() {

    private var list: ArrayList<Recommended> = arrayListOf()

    interface onClickListener {
        fun itemSetOnClickLister(id: String)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bind = ItemRecommendedBinding.bind(itemView)
        fun item(item: Recommended) {
            bind.apply {
                title.text = item.title
                Glide.with(context).load(domen.plus(item.image)).into(image)
            }
            itemView.setOnClickListener {
                listener.itemSetOnClickLister(item.id.toString())
            }

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_recommended, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.item(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun setData(list: List<Recommended>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }
}