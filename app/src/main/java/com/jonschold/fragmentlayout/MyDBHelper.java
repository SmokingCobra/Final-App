package com.jonschold.fragmentlayout;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

class MyDBHandler extends SQLiteOpenHelper {
    //definitions of the the database
    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "band";
    private static final String DATABASE_TABLE = "locations";
    private static final String KEY_TASK_ID = "_id";
    private static final String KEY_NAME = "location_name";
    private static final String KEY_LAT = "latitude";
    private static final String KEY_LON = "longitude";
    int taskCount;

    public MyDBHandler (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //call back method to launch layout, establish the attribute reference
    //starts the database
    @Override
    public void onCreate(SQLiteDatabase db) {
        String table = "CREATE TABLE " + DATABASE_TABLE + "("
                + KEY_TASK_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_NAME + " TEXT, "
                + KEY_LAT + " TEXT, "
                + KEY_LON + " TEXT" + ")";
        db.execSQL(table);
        taskCount =0;
    }

    //
    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        //drop a table
        database.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);

        //create a table
        onCreate(database);

    }


    public void addLocation(BandLocation bandLocation) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_NAME, bandLocation.getName());

        values.put(KEY_LAT, bandLocation.getLat());

        values.put(KEY_LON, bandLocation.getLon());

        // INSERT THE ROW IN THE TABLE
        db.insert(DATABASE_TABLE, null, values);
        taskCount++;

        // CLOSE THE DATABASE CONNECTION
        db.close();
    }

    public List<BandLocation> getAllLocations() {

        //GET ALL THE TASK ITEMS ON THE LIST
        List<BandLocation> locationList = new ArrayList<BandLocation>();

        //SELECT ALL QUERY FROM THE TABLE
        String selectQuery = "SELECT  * FROM " + DATABASE_TABLE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // LOOP THROUGH THE Locations
        if (cursor.moveToFirst()) {
            do {
                BandLocation location = new BandLocation();
                location.set_id(cursor.getInt(0));
                location.setName(cursor.getString(1));
                location.setLat(cursor.getString(2));
                location.setLon(cursor.getString(3));
                locationList.add(location);
            } while (cursor.moveToNext());
        }

        cursor.close();
        // RETURN THE LIST OF TASKS FROM THE TABLE
        return locationList;
    }

    public void clearAll(List<BandLocation> list) {
        //GET ALL THE LIST TASK ITEMS AND CLEAR THEM
        list.clear();

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DATABASE_TABLE, null, new String[]{});
        db.close();
    }

}
