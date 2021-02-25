package demo.com.weatherapp.screen.main.fragment.demodetails

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import demo.com.weatherapp.BR
import demo.com.weatherapp.R
import demo.com.weatherapp.data.model.DemoDetails
import demo.com.weatherapp.databinding.FragmentDemoDetailsBinding
import demo.com.weatherapp.screen.base.fragment.BaseBindingFragment

class DemoDetailsFragment : BaseBindingFragment<FragmentDemoDetailsBinding, DemoDetailsFragmentViewModel>() {
    override val bindingVariable: Int
        get() = BR.demodetailsF
    override val viewModel: DemoDetailsFragmentViewModel
        get() = ViewModelProviders.of(this).get(DemoDetailsFragmentViewModel::class.java)
    override val layoutResource: Int
        get() = R.layout.fragment_demo_details

    override fun initVariable(savedInstanceState: Bundle?, view: View) {
    }

    override fun initData(savedInstanceState: Bundle?, rootView: View) {

    }

}