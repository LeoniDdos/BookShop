package com.libertystudio.bookshop.adapter

import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<P> : RecyclerView.Adapter<BaseViewHolder<P>>() {
    private var dataList: ArrayList<P> = ArrayList()
    var callback: BaseAdapterCallback<P>? = null

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder<P>, position: Int) {
        holder.bind(dataList[position])
    }

    fun setDataList(newDataList: ArrayList<P>) {
        dataList.clear()
        dataList.addAll(newDataList)

        notifyDataSetChanged()
    }

    fun addItem(newItem: P) {
        dataList.add(newItem)

        notifyItemInserted(dataList.size - 1)
    }

    fun removeItem(item: P) {
        val position = dataList.indexOfFirst { item == it }

        if (position >= 0) {
            dataList.removeAt(position)

            notifyItemRemoved(position)
        }
    }
}