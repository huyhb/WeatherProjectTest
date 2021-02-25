package demo.com.weatherapp.screen.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import demo.com.weatherapp.BR
import demo.com.weatherapp.data.model.Demo
import demo.com.weatherapp.databinding.ItemDemoBinding

class DemoAdapter (var items: List<Demo>, var onItemClickListener: DemoAdapter.OnDemoItemClickListener?) : RecyclerView.Adapter<DemoAdapter.ViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
            ItemDemoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binData(items[position],onItemClickListener)
    }

    fun setNewData(newItems: List<Demo>) {
        this.items = newItems
        notifyDataSetChanged()
    }
    class ViewHolder(var binding: ItemDemoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun binData(demo: Demo, onItemClickListener: DemoAdapter.OnDemoItemClickListener?) {
            binding.apply {
                setVariable(BR.demo, demo)
                executePendingBindings()
            }
            binding.layoutCardDemo?.setOnClickListener {
                onItemClickListener?.clickOn(demo)
            }
        }
    }

    interface OnDemoItemClickListener{
        fun clickOn(value: Demo)
    }
}