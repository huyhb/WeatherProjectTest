package demo.com.weatherapp.screen.main.inventoryList

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import demo.com.weatherapp.BR
import demo.com.weatherapp.R
import demo.com.weatherapp.data.model.Inventory
import demo.com.weatherapp.databinding.ActivityInventoryListBinding
import demo.com.weatherapp.screen.base.activity.BaseBindingActivity
import demo.com.weatherapp.screen.main.adapter.InventoryAdapter
import demo.com.weatherapp.screen.main.scanProduct.ScannerActivity

class InventoryListActivity : BaseBindingActivity<ActivityInventoryListBinding, InventoryListViewModel>() {


    private val TAG = "InventoryListActivity"

    override val bindingVariable: Int
        get() = BR.viewModel

    override val viewModel: InventoryListViewModel
        get() = ViewModelProviders.of(this).get(InventoryListViewModel::class.java)

    override val layoutResource: Int
        get() = R.layout.activity_inventory_list

    override fun initVariable(savedInstanceState: Bundle?) {
        viewDataBinding?.recycleInventory?.apply {
            adapter = InventoryAdapter(viewModel.inventoryItems, onItemClick)
            hasFixedSize()
            layoutManager = LinearLayoutManager(this@InventoryListActivity,
                    LinearLayoutManager.VERTICAL, false)
        }

    }

    override fun initData(savedInstanceState: Bundle?) {

    }

    override fun onClick(v: View?) {
        when(v?.id){ //Viết thêm không chạy
            R.id.list_btn -> {
                Log.d("btnSelectAll","Click")
                Toast.makeText(this,"Select All!",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private val onItemClick = object : InventoryAdapter.OnItemClickListener {
        override fun onClickScan(value: Inventory) {
            val intent= Intent(applicationContext, ScannerActivity::class.java)
            intent.putExtra("inventory", value)
            startActivity(intent)
        }

    }

}
