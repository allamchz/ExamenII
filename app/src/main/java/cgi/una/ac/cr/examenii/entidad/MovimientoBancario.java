package cgi.una.ac.cr.examenii.entidad;

import android.content.ContentValues;

import java.util.Calendar;
import java.util.Date;

import cgi.una.ac.cr.examenii.contract.MovimientoBancarioContract;

/**
 * Created by allamchaves on 5/24/18.
 * Registra un movimiento bancario puede ser negativo (Retiro) o positivo ()
 */

public class MovimientoBancario {

    private long _id;
    private Cuenta cuenta;
    private double monto;
    private Date fecha;
    private String descripcion;


    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        String fechaString = year+"-"+month+"-"+day;



        values.put(MovimientoBancarioContract.MovimientoBancarioEntry.CUENTA, cuenta.get_id());
        values.put(MovimientoBancarioContract.MovimientoBancarioEntry.DESCRIPCION, descripcion);
        values.put(MovimientoBancarioContract.MovimientoBancarioEntry.MONTO, monto);
        values.put(MovimientoBancarioContract.MovimientoBancarioEntry.FECHA, fechaString);

        return values;
    }
}
