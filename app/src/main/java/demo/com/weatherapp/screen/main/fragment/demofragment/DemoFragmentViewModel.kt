package demo.com.weatherapp.screen.main.fragment.demofragment

import android.annotation.SuppressLint
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import demo.com.weatherapp.data.model.Product
import demo.com.weatherapp.screen.base.viewmodel.BaseViewModel
import javax.inject.Inject

class DemoFragmentViewModel @Inject constructor() : BaseViewModel() {
    var productListF: ObservableList<Product> = ObservableArrayList()

    init {
        loadData()
    }

    @SuppressLint("CheckResult")
    private fun loadData() {
        //fake data
        val pd1 = Product(1,"Id 1", "Sp 1",4,5)
        val pd2 = Product(2,"Id 2", "Sp 2",4,7)
        val pd3 = Product(3,"Id 3", "Sp 3",2,5)

        productListF.add(pd1)
        productListF.add(pd2)
        productListF.add(pd3)

    }
}