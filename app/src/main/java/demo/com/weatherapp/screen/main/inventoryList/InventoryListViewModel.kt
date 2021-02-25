package demo.com.weatherapp.screen.main.inventoryList

import android.annotation.SuppressLint
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import androidx.lifecycle.MutableLiveData
import demo.com.weatherapp.data.model.Inventory
import demo.com.weatherapp.data.model.InventoryResponse
import demo.com.weatherapp.data.repository.WeatherRepository
import demo.com.weatherapp.data.source.remote.BaseNetwork
import demo.com.weatherapp.screen.base.viewmodel.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class InventoryListViewModel @Inject constructor() : BaseViewModel() {

    private var repository: WeatherRepository? = null
    val inventoryItems: ObservableList<Inventory> = ObservableArrayList() // lắng nghe thay đổi
    val loading = MutableLiveData<Boolean>()


    init {
        loading.value = false
        repository = WeatherRepository(BaseNetwork().providerWeatherApi())
        loadData()
    }

    fun onRefresh() {
        loadData()
    }

    @SuppressLint("CheckResult")
    fun loadData() { //thay đổi data trên xml file
        loading.postValue(false)
//        repository!!.getWeather(10.762622, 106.660172)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(
//                        { it ->
//                            //handleResponse(it)
//                        },
//                        { it ->
//                            handleError(it)
//                        })


        inventoryItems.add(Inventory("20/12/2020", "Kiem tra dinh ky", "K201412","Dang kiem tra"))
        inventoryItems.add(Inventory("20/12/2020", "Kiem tra dinh ky", "K201412","Dang kiem tra"))
        inventoryItems.add(Inventory("20/12/2020", "Kiem tra dinh ky", "K201412","Dang kiem tra"))

        loading.value = false
    }

    private fun handleResponse(response: InventoryResponse) {
        loading.value = false
        inventoryItems.clear()
        inventoryItems.addAll(response.data)

    }

    private fun handleError(message: Throwable) {
        loading.value = false
        message.printStackTrace()
    }
}

