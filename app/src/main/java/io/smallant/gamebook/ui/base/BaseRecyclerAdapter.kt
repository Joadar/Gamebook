package io.smallant.gamebook.ui.base

import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerAdapter<T: Any>(private val itemClickListener: OnItemClickListener<T>? = null):
    RecyclerView.Adapter<BaseViewHolder<T>>() {

    val items: ArrayList<T> = arrayListOf()

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        val item = items[position]
        with(holder) {
            itemView.setOnClickListener {
                itemClickListener?.onItemClick(item)
            }
            bind(item, position)
        }
    }

    fun setItems(list: List<T>?, clearList: Boolean = false) {
        if(clearList)
            items.clear()

        list?.let {
            items.addAll(list)
        }

        notifyDataSetChanged()
    }
}