package com.horil.quizhub.DBHelpers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.horil.quizhub.QuizViewHandlers.QuizActGK;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DBHelperForC_Two extends SQLiteOpenHelper {
    private static String DB_NAME = "category_two.sqlite";
    public static int failed = 0;
    public String[] Answerlist = new String[]{"a", "a", "a", "a", "a", "a", "a", "a"};
    private String DB_PATH;
    private final Context context;
    private SQLiteDatabase db;

    public DBHelperForC_Two(Context context) {
        super(context, DB_NAME, null, 1);
        this.context = context;
        this.DB_PATH = "/data/data/" + context.getPackageName() + "/" + "databases/";
    }

    public void createDataBase() throws IOException {
        if (checkDataBase()) {
            this.context.deleteDatabase(DB_NAME);
            copyDataBase();
            return;
        }
        getReadableDatabase();
        try {
            copyDataBase();
        } catch (IOException e) {
            throw new Error("Error copying database");
        }
    }

    private boolean checkDataBase() {
        return new File(this.DB_PATH + DB_NAME).exists();
    }

    private void copyDataBase() throws IOException {
        InputStream myInput = this.context.getAssets().open(DB_NAME);
        OutputStream myOutput = new FileOutputStream(this.DB_PATH + DB_NAME);
        byte[] buffer = new byte[1024];
        while (true) {
            int length = myInput.read(buffer);
            if (length > 0) {
                myOutput.write(buffer, 0, length);
            } else {
                myOutput.flush();
                myOutput.close();
                myInput.close();
                return;
            }
        }
    }

    public Cursor getData() {

        // this.db = SQLiteDatabase.openDatabase(this.DB_PATH + DB_NAME, null,  SQLiteDatabase.OPEN_READWRITE);
        this.db = SQLiteDatabase.openDatabase(this.DB_PATH + DB_NAME, null, SQLiteDatabase.OPEN_READWRITE);
        return this.db.rawQuery("SELECT * FROM Questions WHERE ID = " + QuizActGK.Questionnumber, null);
    }

    public void onCreate(SQLiteDatabase db) {
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
