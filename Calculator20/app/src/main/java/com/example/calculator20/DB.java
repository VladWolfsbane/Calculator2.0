package com.example.calculator20;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DB extends SQLiteOpenHelper {

    public static final String DATA_TABLE = "DATA_TABLE";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_EQUATION = "EQUATION";
    public static final String COLUMN_RESULT = "RESULT";

    public DB(@Nullable Context context) {
        super(context, "data.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + DATA_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_EQUATION + " TEXT, " + COLUMN_RESULT + " TEXT)";

        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addOne(Model model){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_EQUATION, Model.getEquation());
        cv.put(COLUMN_RESULT, Model.getResult());

        long insert = db.insert(DATA_TABLE,null,cv);
        if (insert == -1){
            return false;
        }
        else {
            return true;
        }
    }

    public List<Model> getAllData(){
        List<Model> returnList = new ArrayList<>();

        String queryString = "SELECT * FROM " + DATA_TABLE;

        SQLiteDatabase thisDB = this.getReadableDatabase();
        Cursor cursor = thisDB.rawQuery(queryString,null);

        if (cursor.moveToFirst()){
            do {
                int dataID = cursor.getInt(0);
                String eq = cursor.getString(1);
                String rst = cursor.getString(2);

                Model newModel = new Model(dataID,eq,rst);
                returnList.add(newModel);

            } while (cursor.moveToNext());
        }
        else {

        }

        cursor.close();
        thisDB.close();

        return returnList;
    }
}
