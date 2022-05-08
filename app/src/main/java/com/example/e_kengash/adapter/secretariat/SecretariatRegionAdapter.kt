package com.example.e_kengash.adapter.secretariat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e_kengash.R
import com.example.e_kengash.databinding.ItemSecretariatRegionBinding
import com.example.e_kengash.network.entity.notif.Result
import com.example.e_kengash.network.entity.secretariat.region.Info


class SecretariatRegionAdapter(private val listener: onClickListener) :
    RecyclerView.Adapter<SecretariatRegionAdapter.ViewHolder>() {

    private var list: MutableList<Info> = mutableListOf()

    interface onClickListener {
        fun setOnClickLister(text: String)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bind = ItemSecretariatRegionBinding.bind(itemView)
        fun item(item: Info) {
            bind.apply {
                fullName.text = item.full_name
                position.text = item.position
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SecretariatRegionAdapter.ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_secretariat_region, parent, false)
    )

    override fun onBindViewHolder(holder: SecretariatRegionAdapter.ViewHolder, position: Int) {
        holder.item(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun setData(list: List<Info>) {
        this.list = list as MutableList<Info>
        notifyDataSetChanged()
    }
}