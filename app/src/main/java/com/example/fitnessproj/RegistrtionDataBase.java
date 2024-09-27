package com.example.fitnessproj;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class RegistrtionDataBase {
    SQLiteDatabase database;
    public RegistrtionDataBase(Context context)
    {
        database = context.openOrCreateDatabase("reg.db",Context.MODE_PRIVATE,null);
        database.execSQL(
                "CREATE TABLE IF NOT EXISTS logins (" +
                        "id integer primary key autoincrement," +
                        "login text not null unique," +
                        "pass text not null)");
    }
    public void newUser (User user)
    {
        database.execSQL(
                String.format("INSERT INTO logins VALUES (null,'%s','%s')",
                        user.getUsername(), user.getPass()));
    }
    public User getUser (String login, String pass)
    {
        User user =null;
        Cursor cursor = database.rawQuery(
                String.format("SELECT * FROM logins WHERE login ='%s' and pass ='%s'",
                        login, pass),null);
        if (cursor.moveToNext())
            user = new User(cursor.getInt(0),
                    cursor.getString(1),cursor.getString(2));
        return user;
    }
}
