package com.example.e_kengash.adapter.more.senator


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.e_kengash.R
import com.example.e_kengash.databinding.ItemSecretariatRegionBinding
import com.example.e_kengash.network.entity.more.senator.Info


class SenatorAdapter(private val context: Context,private val url:String) :
    RecyclerView.Adapter<SenatorAdapter.ViewHolder>() {

    private var list: MutableList<Info> = mutableListOf()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bind = ItemSecretariatRegionBinding.bind(itemView)
        fun item(item: Info) {
            bind.apply {
                fullName.text = item.full_name
                position.text = item.position
                Glide.with(context).load(url.plus(item.image)).into(image)
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

    fun setData(info: List<Info>) {
        this.list = info as MutableList<Info>
        notifyDataSetChanged()
    }
}