package com.example.labexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "labdb";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String createSQL = "CREATE TABLE tbl(id INTEGER PRIMARY KEY,name TEXT,address TEXT)";

        sqLiteDatabase.execSQL(createSQL);

    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME);

        onCreate(sqLiteDatabase);
    }

    public boolean insertData(int id, String name, String address) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", id);
        contentValues.put("name", name);
        contentValues.put("address", address);

        db.insert("tbl", null, contentValues);
        db.close();
        return true;
    }


    public boolean updateData(int id,String name,String address){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("address",address);

        db.update("tbl",contentValues,"id=?",new String[]{String.valueOf(id)});
        db.close();
        return true;
    }

    public Cursor selectData() {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM tbl";
        Cursor cursor = db.rawQuery(sql, null);
        return cursor;
    }
}
