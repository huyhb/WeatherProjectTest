package demo.com.weatherapp.screen.main.fragment.demofragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import demo.com.weatherapp.BR
import demo.com.weatherapp.R
import demo.com.weatherapp.data.model.Product
import demo.com.weatherapp.databinding.FragmentDemoBinding
import demo.com.weatherapp.screen.base.fragment.BaseBindingFragment
import demo.com.weatherapp.screen.main.adapter.ProductAdapter
import demo.com.weatherapp.util.ToastUtils

class DemoFragment : BaseBindingFragment<FragmentDemoBinding, DemoFragmentViewModel>() {

    override val bindingVariable: Int
        get() = BR.demoFragment
    override val viewModel: DemoFragmentViewModel
        get() = ViewModelProviders.of(this).get(DemoFragmentViewModel::class.java)
    override val layoutResource: Int
        get() = R.layout.fragment_demo

    override fun initVariable(savedInstanceState: Bundle?, view: View) {
        viewDataBinding?.recycleInventory?.apply {
            adapter = ProductAdapter(viewModel.productListF, onItemClick)
            hasFixedSize()
            layoutManager = LinearLayoutManager(this@DemoFragment.context,
                    LinearLayoutManager.VERTICAL, false)
        }
    }

    override fun initData(savedInstanceState: Bundle?, rootView: View) {
    }

    private val onItemClick = object : ProductAdapter.OnItemClickListener {
        override fun onClickScan(position:Int, value: Product) {
            ToastUtils.quickToast(this@DemoFragment.requireContext(),"Click me",Toast.LENGTH_SHORT)
            findNavController().navigate(R.id.action_demoFragment_to_demoDetailsFragment)
        }

    }


}