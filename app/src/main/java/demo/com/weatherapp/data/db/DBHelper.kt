package demo.com.weatherapp.data.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DBHelper : SQLiteOpenHelper {

    private var context: Context? = null

    constructor(context: Context): super(context, DB_NAME, null, DB_VERSION){
        this.context = context
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(DBConstants.CREATE_PRODUCT_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + DBConstants.PRODUCT_TABLE)
    }

    companion object {
        var DB_NAME = "sqlite2ExcelDemo"
        private const val DB_VERSION = 2
    }
}