package demo.com.weatherapp.screen.main.scanProduct

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import demo.com.weatherapp.BR
import demo.com.weatherapp.R
import demo.com.weatherapp.data.model.Product
import demo.com.weatherapp.databinding.ActivityScanProductBinding
import demo.com.weatherapp.screen.base.activity.BaseBindingActivity
import demo.com.weatherapp.screen.main.adapter.ProductAdapter
import demo.com.weatherapp.screen.main.inventoryDetail.InventoryDetailActivity


class ScannerActivity : BaseBindingActivity<ActivityScanProductBinding, ScannerViewModel>() {

    private val TAG = "ScannerActivity"

    override val bindingVariable: Int
        get() = BR.viewModel

    override val viewModel: ScannerViewModel
        get() = ViewModelProviders.of(this).get(ScannerViewModel::class.java)

    override val layoutResource: Int
        get() = R.layout.activity_scan_product


    private val lastText: String? = null
    private var countNumberScan = 0


    override fun initVariable(savedInstanceState: Bundle?) {

        viewModel.context = applicationContext
        viewModel.createData()

        viewDataBinding?.recycleInventory?.apply {
            adapter = ProductAdapter(viewModel.productList, onItemClick)
            hasFixedSize()
            layoutManager = LinearLayoutManager(this@ScannerActivity,
                    LinearLayoutManager.VERTICAL, false)
        }



        viewDataBinding?.edtValueNumberScan?.setText(countNumberScan.toString(), TextView.BufferType.EDITABLE)
        viewDataBinding?.edtValueNumberScan?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if(viewModel.positionSelect >= 0 && viewModel.positionSelect < viewModel.productList.size && countNumberScan >= 1){
                    viewModel.updateStockTakeQty(viewModel.positionSelect, viewDataBinding?.edtValueNumberScan?.text?.trim().toString().toInt())
                    viewDataBinding?.recycleInventory?.adapter?.notifyDataSetChanged()
                }

            }
        })

        viewDataBinding?.edtValueProductCode?.setText("", TextView.BufferType.EDITABLE)
        viewDataBinding?.edtValueProductCode?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.d("Change", s.toString())
                Log.d("Change", s?.length.toString())
                var sb = s?.length?.let { StringBuilder(it) };
                sb?.append(s)
                Log.d("Change", sb.toString())
            }

            override fun afterTextChanged(s: Editable?) {
                Log.d("Change", s.toString())
                val enter = s.toString().toList()
                if(enter.get(enter.size - 1).toString() == "\n") {
                    countNumberScan += 1
                    viewDataBinding?.edtValueNumberScan?.setText(countNumberScan.toString(), TextView.BufferType.EDITABLE)
                }
            }
        })

        viewDataBinding?.edtValueNumberScan?.isEnabled = false
        viewDataBinding?.edtValueProductCode?.isEnabled = false
        viewDataBinding?.edtValueEnterScan?.isEnabled = false
        viewDataBinding?.edtValueProductName?.isEnabled = false

        viewDataBinding?.btnExport?.setOnClickListener(this)
    }


    override fun initData(savedInstanceState: Bundle?) {
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_export -> {
                viewModel.export()
            }
        }
    }


    private val onItemClick = object : ProductAdapter.OnItemClickListener {
        override fun onClickScan(position:Int, value: Product) {
            viewModel.positionSelect = position

            Log.d("onKeyDown", "scan code")
            val intent = Intent(applicationContext, InventoryDetailActivity::class.java)
            intent.putExtra("product", value)
            intent.putExtra("position", viewModel.positionSelect)
            startActivity(intent)

           // changeDataOnSelect(value)
        }

    }


    fun changeDataOnSelect(value: Product){
        countNumberScan = 0
        viewDataBinding?.edtValueProductCode?.requestFocus()

        viewDataBinding?.edtValueNumberScan?.setText(countNumberScan.toString(), TextView.BufferType.EDITABLE)

        //viewDataBinding?.edtValueProductCode?.setText("", TextView.BufferType.EDITABLE)
        viewDataBinding?.edtValueProductCode?.requestFocus()

        viewDataBinding?.edtValueProductName?.setText(value.name, TextView.BufferType.EDITABLE)

        viewDataBinding?.edtValueEnterScan?.setText(value.bookQty.toString(), TextView.BufferType.EDITABLE)

        viewDataBinding?.edtValueNumberScan?.isEnabled = true
        viewDataBinding?.edtValueProductCode?.isEnabled = true
        viewDataBinding?.edtValueEnterScan?.isEnabled = true
        viewDataBinding?.edtValueProductName?.isEnabled = true
    }
}