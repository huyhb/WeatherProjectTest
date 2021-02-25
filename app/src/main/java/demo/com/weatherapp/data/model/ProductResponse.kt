package demo.com.weatherapp.data.model

import com.google.gson.annotations.SerializedName

class ProductResponse(
        @SerializedName("inventoryCode") val inventoryCode: String,
        @SerializedName("data") val data: List<Product>
)