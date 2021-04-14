package com.example.register;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDataBase extends SQLiteOpenHelper {
    public static final String CREATE_PEOPLE = "create table people ("
            +"id integer primary key autoincrement, "
            + "Name text, "
            + "Number text, "
            + "Age integer, "
            + "Address text,"
            + "Colleage text)";
    private Context mContext;
    public MyDataBase(Context context,String name,SQLiteDatabase.CursorFactory factory,int version){
        super(context,name,factory,version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PEOPLE);
        Toast.makeText(mContext,"创建成功！",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
