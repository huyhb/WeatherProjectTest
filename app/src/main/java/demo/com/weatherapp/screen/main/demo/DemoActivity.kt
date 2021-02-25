package demo.com.weatherapp.screen.main.demo

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import demo.com.weatherapp.R
import demo.com.weatherapp.BR
import demo.com.weatherapp.data.model.Demo
import demo.com.weatherapp.data.model.Inventory
import demo.com.weatherapp.databinding.ActivityDemoBinding
import demo.com.weatherapp.screen.base.activity.BaseBindingActivity
import demo.com.weatherapp.screen.main.adapter.DemoAdapter
import demo.com.weatherapp.screen.main.adapter.InventoryAdapter
import demo.com.weatherapp.screen.main.demoDetails.DemoDetailsActivity
import demo.com.weatherapp.screen.main.scanProduct.ScannerActivity

class DemoActivity : BaseBindingActivity<ActivityDemoBinding, DemoViewModel>(){

    override val bindingVariable: Int
        get() = BR.viewModel
    override val viewModel: DemoViewModel
        get() = ViewModelProviders.of(this).get(DemoViewModel::class.java)
    override val layoutResource: Int
        get() = R.layout.activity_demo

    override fun initVariable(savedInstanceState: Bundle?) {
        viewDataBinding?.recycleDemo?.apply {
            adapter = DemoAdapter(viewModel.demoList,onItemDemoClick)
            hasFixedSize()
            layoutManager = LinearLayoutManager(this@DemoActivity,
                    LinearLayoutManager.VERTICAL, false)
        }
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun initData(savedInstanceState: Bundle?) {
        changeColorStatusBar()
    }

    override fun onClick(v: View?) {

    }

    private val onItemDemoClick = object : DemoAdapter.OnDemoItemClickListener {
        override fun clickOn(value: Demo) {
            val intent= Intent(applicationContext, DemoDetailsActivity::class.java)
            intent.putExtra("demo", value)
            startActivity(intent)
        }

    }
}