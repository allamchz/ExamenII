package cgi.una.ac.cr.examenii.dbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import cgi.una.ac.cr.examenii.contract.MovimientoBancarioContract;

/**
 * Created by allamchaves on 5/24/18.
 */

public class MovimientoBancarioDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "MovimientoBancarios.db";

    public MovimientoBancarioDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        /**
         * Completar de maneda adecuada la creación de la base de datos
         */
        sqLiteDatabase.execSQL("CREATE TABLE " + MovimientoBancarioContract.MovimientoBancarioEntry.TABLE_NAME + " ("
                + MovimientoBancarioContract.MovimientoBancarioEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + MovimientoBancarioContract.MovimientoBancarioEntry.CUENTA + " INTEGER,"+
                MovimientoBancarioContract.MovimientoBancarioEntry.MONTO + " REAL NOT NULL,"
                + MovimientoBancarioContract.MovimientoBancarioEntry.DESCRIPCION + " TEXT NOT NULL,"
                + MovimientoBancarioContract.MovimientoBancarioEntry.FECHA + " DATE NOT NULL,"
                + " UNIQUE (" + MovimientoBancarioContract.MovimientoBancarioEntry._ID + "))");



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {


    }
}
