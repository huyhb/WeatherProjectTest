package demo.com.weatherapp.util

import android.widget.EditText
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import demo.com.weatherapp.data.model.*
import demo.com.weatherapp.screen.main.adapter.*
import kotlin.toString as toString1

object BindingUtil {

    @BindingAdapter("infoItem")
    @JvmStatic
    fun setAdapterHourly(recyclerView: RecyclerView, items: List<Info>) {
        val adapter: RecyclerView.Adapter<*>? = recyclerView.adapter
        if (adapter != null && adapter is InfoAdapter) {
            if (items != null) {
                adapter.setNewData(items)
            }
        }
    }

    @BindingAdapter("hourlyItem")
    @JvmStatic
    fun setItemHourly(recyclerView: RecyclerView, items: List<DataHourly>?) {
        val adapter: RecyclerView.Adapter<*>? = recyclerView.adapter
        if (adapter != null && adapter is HourlyAdapter) {
            if (items != null) {
                adapter.setNewData(items)
            }
        }
    }

    @BindingAdapter("weeklyItem")
    @JvmStatic
    fun setItemWeekly(recyclerView: RecyclerView, items: List<DataDaily>?) {
        val adapter: RecyclerView.Adapter<*>? = recyclerView.adapter
        if (adapter != null && adapter is WeeklyAdapter) {
            if (items != null) {
                adapter.setNewData(items)
            }
        }
    }

    @BindingAdapter("imageWeekly")
    @JvmStatic
    fun loadImageWeekly(imageView: ImageView, icon: String) {
        Glide.with(imageView.context).load(
                Utils.getImage(Utils.changeIconToName(icon), imageView.context)).into(
                imageView)
    }

    @BindingAdapter("imageHourly")
    @JvmStatic
    fun loadImageHourly(imageView: ImageView, icon: String) {
        Glide.with(imageView.context).load(
                Utils.getImage(Utils.changeIconToName(icon), imageView.context)).into(
                imageView)
    }


    //loading binding data
    @BindingAdapter("inventoryItem")
    @JvmStatic
    fun setItemInventory(recyclerView: RecyclerView, items: List<Inventory>?) {
        val adapter: RecyclerView.Adapter<*>? = recyclerView.adapter
        if (adapter != null && adapter is InventoryAdapter) {
            if (items != null) {
                adapter.setNewData(items)
            }
        }
    }

    @BindingAdapter("productItem")
    @JvmStatic
    fun setItemProduct(recyclerView: RecyclerView, items: List<Product>?) {
        val adapter: RecyclerView.Adapter<*>? = recyclerView.adapter
        if (adapter != null && adapter is ProductAdapter) {
            if (items != null) {
                adapter.setNewData(items)
            }
        }
    }

    //loading binding data
    @BindingAdapter("demoItem")
    @JvmStatic
    fun setItemDemo(recyclerView: RecyclerView, items: List<Demo>?) {
        val adapter: RecyclerView.Adapter<*>? = recyclerView.adapter
        if (adapter != null && adapter is DemoAdapter) {
            if (items != null) {
                adapter.setNewData(items)
            }
        }
    }


}
