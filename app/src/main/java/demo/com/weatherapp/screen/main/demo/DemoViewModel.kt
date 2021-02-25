package demo.com.weatherapp.screen.main.demo

import android.annotation.SuppressLint
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import androidx.lifecycle.MutableLiveData
import demo.com.weatherapp.data.model.Demo
import demo.com.weatherapp.screen.base.viewmodel.BaseViewModel
import javax.inject.Inject

class DemoViewModel @Inject constructor() : BaseViewModel() {
    val loading = MutableLiveData<Boolean>()
    var demoList: ObservableList<Demo> = ObservableArrayList() //partenm
    init {
        loading.value = false

        loadData()
    }
    fun onRefresh() {
        //loadData()
    }

    @SuppressLint("CheckResult")
    fun loadData() {
        loading.postValue(false)
        demoList.add(Demo("Tittle 1","23/02/2021","Không có ghi chú","Nhân viên 1","Hoàn thành"))
        demoList.add(Demo("Tittle 2","23/02/2021","Không có ghi chú","Nhân viên 2","Hoàn thành"))
        demoList.add(Demo("Tittle 3","23/02/2021","Không có ghi chú","Nhân viên 3","Đang xử lí"))
        demoList.add(Demo("Tittle 4","23/02/2021","Không có ghi chú","Nhân viên 4","Hoàn thành"))
        demoList.add(Demo("Tittle 5","23/02/2021","Không có ghi chú","Nhân viên 2","Hoàn thành"))
        loading.value = false
    }
}