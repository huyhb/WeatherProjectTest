package demo.com.weatherapp.data.model

import com.google.gson.annotations.SerializedName

class InventoryResponse(
        @SerializedName("timezone") val timezone: String,
        @SerializedName("data") val data: List<Inventory>
)