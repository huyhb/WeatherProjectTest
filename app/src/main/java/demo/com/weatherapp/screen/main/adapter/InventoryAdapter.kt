package demo.com.weatherapp.screen.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import demo.com.weatherapp.BR
import demo.com.weatherapp.data.model.Inventory
import demo.com.weatherapp.databinding.ItemHourlyBinding
import demo.com.weatherapp.databinding.ItemInventoryBinding

class InventoryAdapter(var items: List<Inventory>, var onItemClickListener: OnItemClickListener? ) : RecyclerView.Adapter<InventoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
            ItemInventoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )


    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binData(items[position], onItemClickListener)
    }

    class ViewHolder(var binding: ItemInventoryBinding) : RecyclerView.ViewHolder(binding.root) {

        fun binData(inventory: Inventory, onItemClickListener: OnItemClickListener?) {
            binding.apply {
                setVariable(BR.inventory, inventory)
                executePendingBindings()
            }
            binding.layoutCard?.setOnClickListener {
                onItemClickListener?.onClickScan(inventory)
            }
        }
    }

    fun setNewData(newItems: List<Inventory>) {
        this.items = newItems
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun onClickScan(value: Inventory)
    }
}