package demo.com.weatherapp.screen.main.inventoryDetail

import android.annotation.SuppressLint
import android.content.Context
import android.os.Environment
import android.util.Log
import android.widget.Toast
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import androidx.lifecycle.MutableLiveData
import com.ajts.androidmads.library.SQLiteToExcel
import demo.com.weatherapp.data.db.DBHelper
import demo.com.weatherapp.data.db.DBQueries
import demo.com.weatherapp.data.model.Product
import demo.com.weatherapp.data.model.ProductResponse
import demo.com.weatherapp.data.repository.WeatherRepository
import demo.com.weatherapp.data.source.remote.BaseNetwork
import demo.com.weatherapp.screen.base.viewmodel.BaseViewModel
import java.io.File
import javax.inject.Inject

class DetailViewModel @Inject constructor() : BaseViewModel() {
    private var repository: WeatherRepository? = null
    val loading = MutableLiveData<Boolean>()

    var context: Context? = null

    var dbHelper: DBHelper? = null
    var dbQueries: DBQueries? = null
    var directory_path = Environment.getExternalStorageDirectory().path + "/Backup/"
    var sqliteToExcel: SQLiteToExcel? = null

    var productList: ObservableList<Product> = ObservableArrayList()
    var positionSelect: Int = -1

    init {
        loading.value = false
        repository = WeatherRepository(BaseNetwork().providerWeatherApi())

        loadData()
    }

    fun onRefresh() {
        loadData()
    }

    @SuppressLint("CheckResult")
    fun loadData() {
        loading.postValue(false)

        productList.clear()
        dbQueries?.open()
        dbQueries?.readProduct()?.let { productList.addAll(it) }
        dbQueries?.close()

        loading.value = false
    }

    private fun handleResponse(response: ProductResponse) {
        loading.value = false
        productList.clear()
        productList.addAll(response.data)

    }

    private fun handleError(message: Throwable) {
        loading.value = false
        message.printStackTrace()
    }

    fun updateStockTakeQty(pos: Int, value: Int){
        if(productList.size > 0 && pos < productList.size ){
            productList.get(pos).stockTakeQty = value

            // update db
            dbQueries?.open()
            val product = Product(productList.get(pos).productCode ?: "", productList.get(pos).name
                    ?: "",
                    productList.get(pos).bookQty ?: 0, productList.get(pos).stockTakeQty ?: 0)
            dbQueries?.insertProduct(product)
            dbQueries?.close()
        }
    }


    fun updateProductName(pos: Int, value: String){
        if(productList.size > 0 && pos < productList.size ){
            productList.get(pos).name = value

            // update db
            dbQueries?.open()
            val product = Product(productList.get(pos).productCode ?: "", productList.get(pos).name
                    ?: "",
                    productList.get(pos).bookQty ?: 0, productList.get(pos).stockTakeQty ?: 0)
            dbQueries?.insertProduct(product)
            productList.clear()
            dbQueries?.readProduct()?.let { productList.addAll(it) }
            dbQueries?.close()
        }
    }

    var iscall = false
    fun createData(){
        if(!iscall) {
            iscall = true
            dbHelper = context?.let { DBHelper(it) };
            dbQueries = context?.let { DBQueries(it) };

            saveProduct("718037856308", "WD Blue")
            //saveProduct("8850029023113", "banh ngot")
        }
    }


    fun saveProduct(productCode: String, productName: String) {
        dbQueries?.open()
        val product = Product(productCode, productName, 10, 0)
        dbQueries?.insertProduct(product)
        productList.clear()
        dbQueries?.readProduct()?.let { productList.addAll(it) }
        dbQueries?.close()
    }

    fun export(){
        val f = File("/storage/emulated/0/Backup/users.xls")
        if (!f.parentFile.exists()) f.parentFile.mkdirs()
        if (!f.exists()) f.createNewFile()
        // Export SQLite DB as EXCEL FILE
        Log.d("export", directory_path)
        sqliteToExcel = SQLiteToExcel(context, DBHelper.DB_NAME, directory_path)
        sqliteToExcel?.exportAllTables("users.xls", object : SQLiteToExcel.ExportListener {
            override fun onStart() {}
            override fun onCompleted(filePath: String) {
                Log.d("expor", "Successfully Exported")
                Toast.makeText(context, "Successfully Exported", Toast.LENGTH_LONG).show()
            }

            override fun onError(e: Exception) {
                Log.d("expor", "error Exported" + e.toString())
                Toast.makeText(context, "error Exported" + e.toString(), Toast.LENGTH_LONG).show()
            }
        })
    }
}