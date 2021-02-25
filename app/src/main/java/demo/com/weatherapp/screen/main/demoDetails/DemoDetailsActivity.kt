package demo.com.weatherapp.screen.main.demoDetails

import android.os.Bundle
import android.view.View
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
import demo.com.weatherapp.R
import demo.com.weatherapp.databinding.ActivityDemoDetailsBinding
import demo.com.weatherapp.screen.base.activity.BaseBindingActivity

class DemoDetailsActivity : BaseBindingActivity<ActivityDemoDetailsBinding, DemoDetailsViewModel>() {
    override val bindingVariable: Int
        get() = BR.demodetails
    override val viewModel: DemoDetailsViewModel
        get() = ViewModelProviders.of(this).get(DemoDetailsViewModel::class.java)
    override val layoutResource: Int
        get() = R.layout.activity_demo_details

    override fun initVariable(savedInstanceState: Bundle?) {
        //hiện thị fragment
        val host = NavHostFragment.create(R.navigation.nav_graph)
        supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, host)
                .setPrimaryNavigationFragment(host).commit()
    }

    override fun initData(savedInstanceState: Bundle?) {
        //
    }

    override fun onClick(v: View?) {

    }


}