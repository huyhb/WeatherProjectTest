package demo.com.weatherapp.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Product() : Serializable {
    var _productid: Int? = null
    @SerializedName("productCode")
    var _productCode: String? = null
    @SerializedName("name")
    var _name: String? = null
    @SerializedName("bookQty")
    var _bookQty: Int? = null
    @SerializedName("stockTakeQty")
    var _stockTakeQty: Int? = null

    constructor(productCode: String, name: String, bookQty: Int, stockqty: Int): this() {

        this._productCode = productCode
        this._name = name
        this._bookQty = bookQty
        this._stockTakeQty = stockqty
    }

    constructor(id: Int ,productCode: String, name: String, bookQty: Int, stockqty: Int): this() {
        this._productid = id
        this._productCode = productCode
        this._name = name
        this._bookQty = bookQty
        this._stockTakeQty = stockqty
    }

    val prodctId: Int?
        get() = _productid

    var productCode: String?
        get() = _productCode
        set(value) {
            this._productCode = value
        }

    var name: String?
        get() = _name
        set(value) {
            this._name = value
        }

    var bookQty: Int?
        get() = _bookQty
        set(value) {
            this._bookQty = value
        }

    var stockTakeQty: Int?
        get() = _stockTakeQty
        set(value) {
            this._stockTakeQty = value
        }

}