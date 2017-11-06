package org.androidtown.altteulacountbook;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by DASOM on 2017-11-04.
 */

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    //income 은 boolean type 입니다. 0 또는 1 만 입력
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE accountBook (_id INTEGER PRIMARY KEY AUTOINCREMENT, price INTEGER, history TEXT, income INTEGER, date TEXT, note TEXT)");
    }
    //_id,price,hitory,input,date,note

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }


    public void inSert(int price,String his,int income, String date, String note ){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO accountBook VALUES(null,"+price+",'"+his+"',"+income+",'"+date+"','"+note+"');");
        db.close();
    }

    public void inSert(DBData data){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO accountBook VALUES(null,"+data.getPrice()+",'"+data.getHistory()+"',"+data.getIncome()+",'"+data.getDate()+"','"+data.getNote()+"');");
        db.close();
    }

    public void upDate(int id,int price,String his,boolean income, String date, String note){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE accountBook " +
                "SET price = "+price+", history = '"+his+"', input = "+income+", date = '"+date+"', note= '"+note+"' " +
                "WHERE _id = "+id+";");
        db.close();
    }

    public void upDate(DBData data){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE accountBook " +
                "SET price = "+data.getPrice()+", history = '"+data.getHistory()+"', input = "+data.getIncome()+", date = '"+data.getDate()+"', note= '"+data.getNote()+"' " +
                "WHERE _id = "+data.getId()+";");
        db.close();
    }

    public void deLete(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM accountBook WHERE _id = "+id+";");
        db.close();
    }

    public void deLete(DBData data){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM accountBook WHERE _id = "+data.getId()+";");
        db.close();
    }

    public DBData[] selectAll(){
        SQLiteDatabase db = getReadableDatabase();
        DBData[] data;
        Cursor cursor = db.rawQuery("SELECT * FROM accountBOOK",null);
        data = new DBData[cursor.getCount()];
        /*for(int i = 0 ; cursor.moveToNext();i++){
            data[i].setData(cursor);
        }*/
        for(int i=0;cursor.moveToNext();i++){
            data[i]=new DBData(cursor);
        }
        return data;
    }
}
