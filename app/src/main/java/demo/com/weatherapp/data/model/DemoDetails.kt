package demo.com.weatherapp.data.model

import java.io.Serializable

class DemoDetails()  : Serializable {
    var _vitri:Int? = null
    var _nhapma: String? = null
    var _tenhang: String? = null
    var _soluongquet: Int? = null
    var _soluong: Int? = null

    constructor(viTri: Int, nhapMa: String, tenHang: String, soLuongQuet: Int, soLuong: Int):this(){
        this._vitri = viTri
        this._nhapma = nhapMa
        this._tenhang = tenHang
        this._soluongquet = soLuongQuet
        this._soluong = soLuong
    }

    var viTri: Int?
        get() = this._vitri
        set(value) {
            this._vitri = value
        }
    var nhapMa: String?
        get() = this._nhapma
        set(value) {
            this._nhapma = value
        }
    var tenHang: String?
        get() = this._tenhang
        set(value) {
            this._tenhang = value
        }
    var soLuongQuet: Int?
        get() = this._soluongquet
        set(value) {
            this._soluongquet = value
        }
    var soLuong: Int?
        get() = this._soluong
        set(value) {
            this._soluong = value
        }

}