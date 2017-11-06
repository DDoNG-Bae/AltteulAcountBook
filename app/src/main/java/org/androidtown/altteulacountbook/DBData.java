package org.androidtown.altteulacountbook;


import android.database.Cursor;

/**
 * Created by DASOM on 2017-11-04.
 */
//_id INTEGER PRIMARY KEY AUTOINCREMENT, price INTEGER, history TEXT, income INTEGER, date TEXT, note TEXT
public class DBData {
    int id;
    int price;
    String history;
    int income;
    String date;
    String note;

    public DBData(){}

    public DBData(int id, int price, String history, int income, String date, String note){
        this.id=id;
        this.price=price;
        this.history=history;
        this.income=income;
        this.date=date;
        this.note=note;
    }

    public DBData(Cursor cursor){
        this.id=cursor.getInt(0);
        this.price=cursor.getInt(1);
        this.history=cursor.getString(2);
        this.income=cursor.getInt(3);
        this.date=cursor.getString(4);
        this.note=cursor.getString(5);
    }

    public void setData(int id, int price, String history, int income, String date, String note){
        this.id=id;
        this.price=price;
        this.history=history;
        this.income=income;
        this.date=date;
        this.note=note;
    }
    //cursor.getInt(0),cursor.getInt(1),cursor.getString(2),cursor.getInt(3),cursor.getString(4),cursor.getString(5)
    public void setData(Cursor cursor){
        this.id=cursor.getInt(0);
        this.price=cursor.getInt(1);
        this.history=cursor.getString(2);
        this.income=cursor.getInt(3);
        this.date=cursor.getString(4);
        this.note=cursor.getString(5);
    }

    public String getDataString(){
        String string = "아이디 : "+id+" / 가격 : "+price+" / 내역 : "+history+" / 수입/지출 : "+income+" / 날짜 : "+date+" / 메모 : "+note+"\n";
        return string;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


}