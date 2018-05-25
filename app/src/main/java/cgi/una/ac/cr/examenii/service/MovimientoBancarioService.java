package cgi.una.ac.cr.examenii.service;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import cgi.una.ac.cr.examenii.contract.MovimientoBancarioContract;
import cgi.una.ac.cr.examenii.dbHelper.MovimientoBancarioDbHelper;
import cgi.una.ac.cr.examenii.entidad.MovimientoBancario;

/**
 * Created by allamchaves on 5/24/18.
 */

public class MovimientoBancarioService {
    Context context;
    MovimientoBancarioDbHelper movimientoBancarioDbHelper;

    public MovimientoBancarioService(Context context) {
        this.context = context;
        movimientoBancarioDbHelper = new MovimientoBancarioDbHelper(context);
    }


    public void create(MovimientoBancario movimiento) {
        SQLiteDatabase sqLiteDatabase = movimientoBancarioDbHelper.getWritableDatabase();

        sqLiteDatabase.insert(
                MovimientoBancarioContract.MovimientoBancarioEntry.TABLE_NAME,
                null,
                movimiento.toContentValues());
    }

    public List<MovimientoBancario> findAll() {
        SQLiteDatabase sqLiteDatabase = movimientoBancarioDbHelper.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.query(
                MovimientoBancarioContract.MovimientoBancarioEntry.TABLE_NAME,   // The table to query
                null,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                null               // The sort order
        );
        List<MovimientoBancario> movimientos = new ArrayList();
        MovimientoBancario movimientoBancario;
        while (cursor.moveToNext()) {
            movimientoBancario = new MovimientoBancario();
            movimientoBancario.set_id(cursor.getInt(cursor.getColumnIndexOrThrow(MovimientoBancarioContract.MovimientoBancarioEntry._ID)));

            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date;
            String dateString =cursor.getString(cursor.getColumnIndexOrThrow(MovimientoBancarioContract.MovimientoBancarioEntry.FECHA));
            try {
                date = format.parse(dateString);
            } catch (Exception e) {
                date = new Date();
                e.printStackTrace();
            }
            movimientoBancario.setFecha(date);
            movimientoBancario.setMonto(cursor.getFloat(cursor.getColumnIndexOrThrow(MovimientoBancarioContract.MovimientoBancarioEntry.MONTO)));
            movimientoBancario.setDescripcion(cursor.getString(cursor.getColumnIndexOrThrow(MovimientoBancarioContract.MovimientoBancarioEntry.DESCRIPCION)));
            movimientos.add(movimientoBancario);

        }

        return movimientos;

    }



}
