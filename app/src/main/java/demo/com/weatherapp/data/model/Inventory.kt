package demo.com.weatherapp.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Inventory (
    @SerializedName("date") val _date: String,
    @SerializedName("type") val _type: String,
    @SerializedName("code") val _code: String,
    @SerializedName("status") val _status: String
) : Serializable {
    val date: String
        get() = _date

    val type: String
        get() = _type

    val code: String
        get() = _code

    val status: String
        get() = _status

}