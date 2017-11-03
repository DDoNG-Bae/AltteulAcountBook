package org.androidtown.altteulacountbook;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Date;

/**
 * Created by DASOM on 2017-11-03.
 */

public class DBHelper extends SQLiteOpenHelper {


    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public String getDatabaseName() {
        return super.getDatabaseName();
    }

    @Override
    public void setWriteAheadLoggingEnabled(boolean enabled) {
        super.setWriteAheadLoggingEnabled(enabled);
    }

    @Override
    public SQLiteDatabase getWritableDatabase() {
        return super.getWritableDatabase();
    }

    @Override
    public SQLiteDatabase getReadableDatabase() {
        return super.getReadableDatabase();
    }

    @Override
    public synchronized void close() {
        super.close();
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE ACCOUNTBOOK (_id INTEGER PRIMARY KEY AUTOINCREMENT, price INTEGER, history TEXT, input INTEGER, date TEXT, note TEXT");
    }
    /*CREATE TABLE ACCOUNTBOOK (_id INTEGER PRIMARY KEY AUTOINCREMENT, price INTEGER, history TEXT, input INTEGER, date TEXT, note TEXT*/

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    public  void insert(int price, String history, boolean input, Date date,String note ){
        SQLiteDatabase db = getWritableDatabase();
        int tmp=0;
        if(input)
            tmp=1;
        String dateS = date.toString();
        db.execSQL("INSERT INTO ACCOUNTBOOK VALUES(null,"+price+",'"+history+"',"+tmp+",'"+dateS+"','"+note+"');");
        db.close();
    }
    /*INSERT INTO ACCOUNTBOOK VALUES(null,price,'history',tmp,'dateS','note');*/

    //history TEXT, price INTEGER, input INTEGER, date TEXT, note TEXT
    public void update(int id, int price, String history, boolean input, Date date,String note ){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE ACCOUNTBOOK " +
                "SET price = "+price+", history = '"+history+"', input = "+input+", date = '"+date+"', note= '"+note+"' " +
                "WHERE id == "+id+";");
    }
    /*UPDATE ACCOUNTBOOK
      SET price=INT, history= 'STRING',input=INT,date='STRING',note='STRING'
      WHERE id==id;
     */

    public DBData[] getData(){
        SQLiteDatabase db = getReadableDatabase();
        DBData[] data;
        Cursor cursor = db.rawQuery("SELECT *"+
                                    "FROM ACCOUNTBOOK"
                                    ,null);
        int count = cursor.getCount();
        data = new DBData[count];

        for(int i=0;i<count;i++){
            data[i]=new DBData(cursor.getInt(0),cursor.getInt(1),cursor.getString(2),cursor.getInt(3),cursor.getString(4),cursor.getString(5));//id,price,hitory,input,date,note
        }

        return data;
    }
}
