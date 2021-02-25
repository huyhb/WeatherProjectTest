package demo.com.weatherapp.data.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import demo.com.weatherapp.data.model.Product
import java.util.*

class DBQueries {

    private var context: Context? = null
    private var database: SQLiteDatabase? = null
    private var dbHelper: DBHelper? = null

    constructor(context: Context){
        this.context = context
    }

    @Throws(SQLException::class)
    fun open(): DBQueries {
        dbHelper = context?.let { DBHelper(it) }
        database = dbHelper!!.writableDatabase
        return this
    }

    fun close() {
        dbHelper?.close()
    }

    // Users
    fun insertProduct(product: Product): Boolean {
        val values = ContentValues()
        values.put(DBConstants.PRODUCT_CODE, product.productCode)
        values.put(DBConstants.PRODUCT_NAME, product.name)
        values.put(DBConstants.BOOK_QTY, product.bookQty)
        values.put(DBConstants.STOCK_TAKE_QTY, product.stockTakeQty)
        product.productCode?.let {
            if(findItemExist(it)) {
                return database!!.update(DBConstants.PRODUCT_TABLE, values, DBConstants.PRODUCT_CODE,  null) > -1
            } else {
                return database!!.insert(DBConstants.PRODUCT_TABLE, null, values) > -1
            }
        }
        return database!!.insert(DBConstants.PRODUCT_TABLE, null, values) > -1
    }

    private fun findItemExist(code: String):Boolean{
        try {
            var cursor: Cursor? = null
            database = dbHelper?.readableDatabase
            Log.d("indItemExist", DBConstants.EXIST_QUERY + code )
            cursor = database?.rawQuery(DBConstants.EXIST_QUERY + code, null)
            cursor?.let {
                if (it.count > 0) {
                   return true
                }

                cursor.close()
            }

        } catch (e: Exception) {
            Log.v("Exception", e.message)
            return false
        }
        return false
    }

    fun readProduct(): ArrayList<Product> {
        val list: ArrayList<Product> = ArrayList<Product>()
        try {
            var cursor: Cursor? = null
            database = dbHelper?.readableDatabase
            cursor = database?.rawQuery(DBConstants.SELECT_QUERY, null)
            list.clear()
            cursor?.let {
                if (it.count > 0) {
                    if (it.moveToFirst()) {
                        do {
                            val productId = it.getInt(cursor.getColumnIndex(DBConstants.PRODUCT_ID))
                            val productCode = it.getString(cursor.getColumnIndex(DBConstants.PRODUCT_CODE))
                            val productName = it.getString(cursor.getColumnIndex(DBConstants.PRODUCT_NAME))
                            val productBook = it.getInt(cursor.getColumnIndex(DBConstants.BOOK_QTY))
                            val productStock = it.getInt(cursor.getColumnIndex(DBConstants.STOCK_TAKE_QTY)   )
                            val product = Product( productId, productCode, productName, productBook, productStock)
                            list.add(product)
                        } while (cursor.moveToNext())
                    }
                }

                cursor.close()
            }

        } catch (e: Exception) {
            Log.v("Exception", e.message)
        }
        return list
    }
}