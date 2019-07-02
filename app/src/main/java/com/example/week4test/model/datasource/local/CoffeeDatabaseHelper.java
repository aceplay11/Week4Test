package com.example.week4test.model.datasource.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.week4test.model.datasource.coffee.CoffeeResponse;

import static com.example.week4test.model.datasource.local.DatabaseContract.DatabaseConstants.DATABASE_NAME;
import static com.example.week4test.model.datasource.local.DatabaseContract.DatabaseConstants.DATABASE_VERSION;
import static com.example.week4test.model.datasource.local.DatabaseContract.DatabaseConstants.FIELD_DESC;
import static com.example.week4test.model.datasource.local.DatabaseContract.DatabaseConstants.FIELD_ID;
import static com.example.week4test.model.datasource.local.DatabaseContract.DatabaseConstants.FIELD_IMAGE;
import static com.example.week4test.model.datasource.local.DatabaseContract.DatabaseConstants.FIELD_NAME;
import static com.example.week4test.model.datasource.local.DatabaseContract.DatabaseConstants.TABLE_NAME;

public class CoffeeDatabaseHelper extends SQLiteOpenHelper {

    public CoffeeDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createQuery = "CREATE TABLE " + TABLE_NAME + " ("
                + FIELD_ID + " TEXT PRIMARY KEY, "
                + FIELD_NAME + " TEXT, "
                + FIELD_DESC + " TEXT, "
                + FIELD_IMAGE + " TEXT)";
        sqLiteDatabase.execSQL(createQuery);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }

    public void insertCoffee(CoffeeResponse coffeeResponse) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        if (coffeeResponse != null) {
            String name = coffeeResponse.getName();
            String id = coffeeResponse.getId();
            String desc = coffeeResponse.getDesc();
            String image = coffeeResponse.getImageUrl();

            contentValues.put(FIELD_NAME, name);
            contentValues.put(FIELD_ID, id);
            contentValues.put(FIELD_DESC, desc);
            contentValues.put(FIELD_IMAGE, image);

            database.insert(TABLE_NAME, null, contentValues);
        }
    }

    public CoffeeResponse getCoffee(String passedID) {
        CoffeeResponse returnCoffee = null;
        if (passedID != null && !passedID.isEmpty()) {
            SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

            String query = "SELECT * FROM " + TABLE_NAME
                    + " WHERE " + FIELD_NAME + " = \"" + passedID + "\"";
            Cursor cursor = sqLiteDatabase.rawQuery(query, null);
            if (cursor.moveToFirst()) {
                String name = cursor.getString(cursor.getColumnIndex(FIELD_NAME));
                String id = cursor.getString(cursor.getColumnIndex(FIELD_ID));
                String desc = cursor.getString(cursor.getColumnIndex(FIELD_DESC));
                String image = cursor.getString(cursor.getColumnIndex(FIELD_IMAGE));

                returnCoffee = new CoffeeResponse(name, id, desc, image);
            }
            cursor.close();
        }

        return returnCoffee;
    }
}
