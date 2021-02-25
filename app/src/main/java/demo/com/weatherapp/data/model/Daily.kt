package demo.com.weatherapp.data.model

import com.google.gson.annotations.SerializedName

class Daily(
        @SerializedName("summary") val summary: String,
        @SerializedName("icon") val icon: String,
        @SerializedName("data") val data: List<DataDaily>
)

class DataDaily(
        @SerializedName("time") val time: Long,
        @SerializedName("summary") val summary: String,
        @SerializedName("sunriseTime") val sunriseTime: Long,
        @SerializedName("sunsetTime") val sunsetTime: Long,
        @SerializedName("icon") val icon: String,
        @SerializedName("precipIntensity") val precipIntensity: Double,
        @SerializedName("precipProbability") val precipProbability: Double,
        @SerializedName("temperature") val temperature: Double,
        @SerializedName("temperatureHigh") val temperatureHigh: Double,
        @SerializedName("temperatureLow") val temperatureLow: Double,
        @SerializedName("apparentTemperature") val apparentTemperature: Double,
        @SerializedName("dewPoint") val dewPoint: Double,
        @SerializedName("humidity") val humidity: Double,
        @SerializedName("pressure") val pressure: Double,
        @SerializedName("windSpeed") val windSpeed: Double,
        @SerializedName("windGust") val windGust: Double,
        @SerializedName("windBearing") val windBearing: Int,
        @SerializedName("cloudCover") val cloudCover: Double,
        @SerializedName("uvIndex") val uvIndex: Int,
        @SerializedName("visibility") val visibility: Double,
        @SerializedName("ozone") val ozone: Double,
        @SerializedName("precipType") val precipType: String
)
