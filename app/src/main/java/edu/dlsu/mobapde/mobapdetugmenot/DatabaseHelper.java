package edu.dlsu.mobapde.mobapdetugmenot;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Sean Paragas on 12/14/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper
{

    public static final String SCHEMA = "record";
    public static final int VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, SCHEMA, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /*
        * CREATE TABLE game (
        *   _id INTEGER PRIMARY KEY AUTOINCREMENT,
        *   difficulty TEXT ,
        *   result TEXT,
        *   timeLeft TEXT
        * );
        * */

        String sql = "CREATE TABLE " + Game.TABLE_NAME + " ("
                + Game.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Game.COLUMN_DIFFICULTY + " TEXT,"
                + Game.COLUMN_RESULT + " TEXT,"
                + Game.COLUMN_TIMELEFT + " TEXT"
                + ");";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + Game.TABLE_NAME + ";";
        db.execSQL(sql);
        onCreate(db);
    }

    public long addGame(Game game)
    {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Game.COLUMN_DIFFICULTY, game.getDifficulty();
        contentValues.put(Game.COLUMN_RESULT, game.getResult());
        contentValues.put(Game.COLUMN_TIMELEFT, game.getTime());

        long id = db.insert(Game.TABLE_NAME, null, contentValues);
        return id;
    }

    public int getWins()
    {
        int wins = 0;
        Cursor c = getReadableDatabase().query(Game.TABLE_NAME, null, null, null, null, null, null);
        c.moveToFirst();
        while(!c.isAfterLast())
        {
            if(c.getString(c.getColumnIndex(Game.COLUMN_RESULT)).equalsIgnoreCase("W"));
                wins++;
            c.moveToNext();
        }

        return wins;
    }

    public int getLosses()
    {
        int losses = 0;
        Cursor c = getReadableDatabase().query(Game.TABLE_NAME, null, null, null, null, null, null);
        c.moveToFirst();
        while(!c.isAfterLast())
        {
            if(c.getString(c.getColumnIndex(Game.COLUMN_RESULT)).equalsIgnoreCase("L"));
            losses++;
            c.moveToNext();
        }

        return losses;
    }

    public String getFastestTime()
    {
        String time = "";

        Cursor c = getReadableDatabase().query(Game.TABLE_NAME, null, null, null, null, null, null);
        c.moveToFirst();
        while(!c.isAfterLast())
        {
            // if time left is more than currently stored value in 'time'
                // update 'time'

            c.moveToNext();
        }

        return time;
    }

}
