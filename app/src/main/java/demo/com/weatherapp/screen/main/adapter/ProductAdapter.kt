package demo.com.weatherapp.screen.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import demo.com.weatherapp.BR
import demo.com.weatherapp.data.model.Product
import demo.com.weatherapp.databinding.ItemProductBinding

class ProductAdapter(var items: List<Product>, var onItemClickListener: OnItemClickListener) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
            ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )


    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binData(items[position], onItemClickListener)
    }

    class ViewHolder(var binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {

        fun binData(product: Product, onItemClickListener: OnItemClickListener?) {
            binding.apply {
                setVariable(BR.product, product)
                executePendingBindings()
            }
            binding.layoutCard?.setOnClickListener {
                onItemClickListener?.onClickScan(position,product)
            }
        }
    }

    fun setNewData(newItems: List<Product>) {
        this.items = newItems
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun onClickScan(position:Int, value: Product)
    }
}