package demo.com.weatherapp.data.db

internal object DBConstants {
    const val PRODUCT_TABLE = "product"
    const val PRODUCT_ID = "product_id"
    const val PRODUCT_CODE = "product_code"
    const val PRODUCT_NAME = "product_name"
    const val BOOK_QTY = "book_qty"  //bookQty
    const val STOCK_TAKE_QTY = "stock_take_qty" //stockTakeQty

    const val CREATE_PRODUCT_TABLE = ("CREATE TABLE IF NOT EXISTS " + PRODUCT_TABLE + " ("
            + PRODUCT_ID + " INTEGER PRIMARY KEY,"
            + PRODUCT_CODE + " TEXT,"
            + PRODUCT_NAME + " TEXT,"
            + BOOK_QTY + " INTEGER,"
            + STOCK_TAKE_QTY + " INTEGER)")

    const val SELECT_QUERY = "SELECT * FROM " + PRODUCT_TABLE

    const val EXIST_QUERY = "SELECT " + PRODUCT_CODE + " FROM " + PRODUCT_TABLE + " WHERE " + PRODUCT_CODE + "="
}