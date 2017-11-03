package org.androidtown.altteulacountbook;


import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by DASOM on 2017-11-03.
 */

public class DBData {
    int id;
    int price;
    String history;
    boolean input;
    Date date;
    String note;

    public DBData(int id, int price, String hitory, int input, String dateS, String note) {
        this.id = id;
        this.price = price;
        this.history = hitory;
        if (input == 0)
            this.input = false;
        else
            this.input = true;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        this.date = dateFormat.parse(dateS,pos);
        this.note=note;
    }
}
