package com.example.e_kengash.adapter.more.council.changeDeputat



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e_kengash.R
import com.example.e_kengash.databinding.ItemCouncilDeputatChangeDocBinding
import com.example.e_kengash.network.entity.more.council.changeDeputat.doc.Document


class ChangeDeputatDocAdapter(
    private val listener: onClickListener
) : RecyclerView.Adapter<ChangeDeputatDocAdapter.ViewHolder>() {

    private var list: MutableList<Document> = mutableListOf()

    interface onClickListener {
        fun setOnClickLister(url: String)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bind = ItemCouncilDeputatChangeDocBinding.bind(itemView)
        fun item(item: Document) {
            bind.apply {
                title.text =item.fields.title
                doc1.text =item.fields.files[0].name
                doc2.text =item.fields.files[1].name
                doc3.text =item.fields.files[2].name
                doc4.text =item.fields.files[3].name

            }
           bind.apply {
               doc1.setOnClickListener {
                   listener.setOnClickLister(item.fields.files[0].doc)
               }
               doc2.setOnClickListener {
                   listener.setOnClickLister(item.fields.files[1].doc)
               }
               doc3.setOnClickListener {
                   listener.setOnClickLister(item.fields.files[2].doc)
               }
               doc4.setOnClickListener {
                   listener.setOnClickLister(item.fields.files[3].doc)
               }
           }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_council_deputat_change_doc, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.item(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun setData(list: List<Document>) {
        this.list = list as MutableList<Document>
        notifyDataSetChanged()
    }
}