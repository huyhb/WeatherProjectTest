package demo.com.weatherapp.screen.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import demo.com.weatherapp.R
import demo.com.weatherapp.data.model.DataDaily
import demo.com.weatherapp.databinding.ItemWeeklyBinding
import demo.com.weatherapp.util.Utils

class WeeklyAdapter(
        private var items: List<DataDaily>
) : RecyclerView.Adapter<WeeklyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_weekly,
                    parent, false)
    )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binData(items[position])
    }

    class ViewHolder(private val binding: ItemWeeklyBinding) : RecyclerView.ViewHolder(
            binding.root) {

        fun binData(item: DataDaily) {
            binding.apply {
                day = Utils.convertTimeToDay(item.time)
                image = item.icon
                tempMax = Utils.changeTempFToC(item.temperatureHigh).toString() + Utils.makeTemp()
                tempMin = Utils.changeTempFToC(item.temperatureLow).toString() + Utils.makeTemp()
            }
        }
    }

    fun setNewData(data: List<DataDaily>) {
        this.items = data
        notifyDataSetChanged()
    }
}