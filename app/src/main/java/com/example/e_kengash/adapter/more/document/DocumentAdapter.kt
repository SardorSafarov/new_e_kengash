package com.example.e_kengash.adapter.more.document


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e_kengash.R
import com.example.e_kengash.databinding.ItemDocumentListBinding
import com.example.e_kengash.network.entity.more.document.LawDecision


class DocumentAdapter(private val listener:ItemClick) :
    RecyclerView.Adapter<DocumentAdapter.ViewHolder>() {

    private var list = ArrayList<LawDecision>()

    interface ItemClick{
        fun itemSetOnClickListener(file: String)
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bind = ItemDocumentListBinding.bind(itemView)
        fun item(item: LawDecision) {
            bind.apply {
                item.fields.apply {
                    serialNumber.text = serial_number
                    namee.text = name
                    datee.text =date
                    contentt.text =content
                }
            }
            itemView.setOnClickListener {
                listener.itemSetOnClickListener(item.fields.file)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_document_list, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.item(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun setData(info: List<LawDecision>) {
        list.clear()
        list.addAll(info)
        notifyDataSetChanged()
    }
}