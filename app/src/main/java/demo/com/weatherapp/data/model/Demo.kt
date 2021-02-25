package demo.com.weatherapp.data.model

import java.io.Serializable

class Demo()  : Serializable {
    var _tittle: String? = null
    var _date: String? = null
    var _note: String? = null
    var _staff: String? = null
    var _status: String? = null


    constructor(tittle: String ,date: String, note: String, staff: String, status: String): this() {
        this._tittle = tittle
        this._date = date
        this._note = note
        this._staff = staff
        this._status = status
    }

    var tittle: String?
        get() = _tittle
        set(value) {
            this._tittle = value
        }


    var date: String?
        get() = _date
        set(value) {
            this._date = value
        }

    var note: String?
        get() = _note
        set(value) {
            this._note = value
        }

    var staff: String?
        get() = _staff
        set(value) {
            this._staff = value
        }

    var status: String?
        get() = _status
        set(value) {
            this._status = value
        }
}