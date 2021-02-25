package demo.com.weatherapp.screen.main.fragment.demodetails

import android.annotation.SuppressLint
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import demo.com.weatherapp.data.model.DemoDetails
import demo.com.weatherapp.screen.base.viewmodel.BaseViewModel
import javax.inject.Inject

class DemoDetailsFragmentViewModel @Inject constructor() : BaseViewModel() {

    var viTri : ObservableField<Int> = ObservableField()
    var maNhap : ObservableField<String> = ObservableField()
    var tenHang : ObservableField<String> = ObservableField()
    var soLuongQuet : ObservableField<Int> = ObservableField()
    var soLuong : ObservableField<Int> = ObservableField()

    init {
        loadData()
    }

    @SuppressLint("CheckResult")
    fun loadData() {
        //demoDetails.set()
        var demotest = DemoDetails(1,"10999111","Test Upload Item Demo",1,5)
        viTri.set(demotest._vitri)
        maNhap.set(demotest._nhapma)
        tenHang.set(demotest.tenHang)
        soLuongQuet.set(demotest._soluongquet)
        soLuong.set(demotest.soLuong)
    }
}