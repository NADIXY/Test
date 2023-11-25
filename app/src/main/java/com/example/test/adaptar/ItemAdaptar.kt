package com.example.test.adaptar

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test.data.model.GoShopping
import com.example.test.databinding.ListItemBinding

class ItemAdaptar(
    private val context: Context,
    private val dataset: List<GoShopping>
) : RecyclerView.Adapter<ItemAdaptar.ItemViewHolder>() {

    inner class ItemViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]




        holder.binding.content2TV.text = context.resources.getString(item.index)
        holder.binding.content3TV.text = context.resources.getString(item.name)
        holder.binding.content1TV.text = context.resources.getString(item.menge)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}
