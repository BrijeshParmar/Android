package com.ict.genesis.surathackathon;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Genesis on 23/09/2017.
 */

public class UserDataHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;

    // Database Name
    private static final String DATABASE_NAME = "UserDB.db";

    // Contacts table name
    private static final String TABLE_USERS = "users";


    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_MNO = "mno";
    private static final String KEY_GEN = "gender";
    private static final String KEY_ADR = "address";
    private static final String KEY_PASS = "password";



    public UserDataHandler(Context context) {
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_USERTABLE="CREATE TABLE " +TABLE_USERS+"("+KEY_NAME+" TEXT PRIMARY KEY, " + KEY_EMAIL+ " TEXT,"+KEY_MNO+" TEXT,"+KEY_GEN+" TEXT,"+KEY_ADR+" TEXT,"+KEY_PASS+" TEXT"+")";
        sqLiteDatabase.execSQL(CREATE_USERTABLE);

    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addUser(User user){
        SQLiteDatabase db=this.getReadableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_NAME,user.get_pass());
        values.put(KEY_EMAIL,user.get_email());
        values.put(KEY_MNO,user.get_mno());
        values.put(KEY_GEN,user.get_gender());
        values.put(KEY_ADR,user.get_adr());
        values.put(KEY_PASS,user.get_pass());

        db.insert(TABLE_USERS,null,values);
        db.close();
    }

    public int getUsersCount() {
        String countQuery = "SELECT  * FROM " + TABLE_USERS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int cnt=cursor.getCount();
        cursor.close();
        return cnt;
    }
    User getUser(String email) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_USERS, new String[] { KEY_NAME,
                        KEY_EMAIL, KEY_MNO,KEY_GEN,KEY_ADR,KEY_PASS }, KEY_EMAIL + "=?",
                new String[] { String.valueOf(email) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        User user= new User(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5));
        // return contact
        return user;
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<User>();
        String selectQuery = "SELECT  * FROM " + TABLE_USERS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.set_name(cursor.getString(0));
                user.set_email(cursor.getString(1));
                user.set_mno(cursor.getString(2));
                user.set_gender(cursor.getString(3));
                user.set_adr(cursor.getString(4));
                user.set_pass(cursor.getString(5));
                userList.add(user);
            } while (cursor.moveToNext());
        }
        return userList;
    }
}
