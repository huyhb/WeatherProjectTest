package demo.com.weatherapp.screen.main.inventoryDetail


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import demo.com.weatherapp.BR
import demo.com.weatherapp.R
import demo.com.weatherapp.data.model.Product
import demo.com.weatherapp.databinding.ActivityDetailInventoryScanBinding
import demo.com.weatherapp.screen.base.activity.BaseBindingActivity


class InventoryDetailActivity: BaseBindingActivity<ActivityDetailInventoryScanBinding, DetailViewModel>() {

    private val TAG = "InventoryDetailActivity"

    override val bindingVariable: Int
        get() = BR.viewModel

    override val viewModel: DetailViewModel
        get() = ViewModelProviders.of(this).get(DetailViewModel::class.java)

    override val layoutResource: Int
        get() = R.layout.activity_detail_inventory_scan


    private val lastText: String? = null
    private var countNumberScan = 0
    private var product: Product? = null


    override fun initVariable(savedInstanceState: Bundle?) {

        viewModel.context = applicationContext
        viewModel.loadData()

        viewDataBinding?.btnStop?.setOnClickListener(this)
        viewDataBinding?.btnConti?.setOnClickListener(this)
        viewDataBinding?.edtValueNumberScan?.setText(countNumberScan.toString(), TextView.BufferType.EDITABLE)
        viewDataBinding?.edtValueNumberScan?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if(viewModel.positionSelect >= 0 && viewModel.positionSelect < viewModel.productList.size && countNumberScan >= 1){
                    viewModel.updateStockTakeQty(viewModel.positionSelect, viewDataBinding?.edtValueNumberScan?.text?.trim().toString().toInt())
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
                if (enter.get(enter.size - 1).toString() == "\n") {
                    countNumberScan += 1
                    viewDataBinding?.edtValueNumberScan?.setText(countNumberScan.toString(), TextView.BufferType.EDITABLE)
                }
            }
        })

        viewDataBinding?.edtValueNumberScan?.isEnabled = false
        viewDataBinding?.edtValueProductCode?.isEnabled = false
        viewDataBinding?.edtValueEnterScan?.isEnabled = false
        viewDataBinding?.edtValueProductName?.isEnabled = false

        product?.let { changeDataOnSelect(it) }
    }


    override fun initData(savedInstanceState: Bundle?) {
        val extras = intent.extras
        if (extras != null) {
            product =   extras.getSerializable("product") as Product?
            viewModel.positionSelect = extras.getInt("position")
        }

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_export -> {

            }

            R.id.btn_stop -> {
                disable()
            }

            R.id.btn_conti -> {
                conti()
            }
        }
    }


    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (event?.getAction() == KeyEvent.ACTION_DOWN) {
            //do something here
            when(keyCode){
                KeyEvent.KEYCODE_BUTTON_R1 -> {
                    Log.d("onKeyDown", "scan code")
                    viewDataBinding?.edtValueProductCode?.requestFocus()
                }
                KeyEvent.KEYCODE_BACK -> {
                    onBackPressed()
                }
            }
        }
        return false;
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

    fun disable(){
        viewDataBinding?.edtValueNumberScan?.isEnabled = false
        viewDataBinding?.edtValueProductCode?.isEnabled = false
        viewDataBinding?.edtValueEnterScan?.isEnabled = false
        viewDataBinding?.edtValueProductName?.isEnabled = false
    }

    fun conti(){
        viewDataBinding?.edtValueNumberScan?.isEnabled = true
        viewDataBinding?.edtValueProductCode?.isEnabled = true
        viewDataBinding?.edtValueEnterScan?.isEnabled = true
        viewDataBinding?.edtValueProductName?.isEnabled = true
    }
}