package cgi.una.ac.cr.examenii.entidad;

import java.io.Serializable;
import java.util.List;

/**
 * Created by allamchaves on 5/24/18.
 * Almacena la cuenta de un cliente (propietario)
 */

public class Cuenta implements Serializable{

    private long _id;
    private double saldo;
    private  String numero;
    private String propietario;
    private List<MovimientoBancario > movimientoBancarioList;

    public Cuenta(){

    }
    public Cuenta(long _id, double saldo, String numero, String propietario) {
        this._id = _id;
        this.saldo = saldo;
        this.numero = numero;
        this.propietario = propietario;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public List<MovimientoBancario> getMovimientoBancarioList() {
        return movimientoBancarioList;
    }

    public void setMovimientoBancarioList(List<MovimientoBancario> movimientoBancarioList) {
        this.movimientoBancarioList = movimientoBancarioList;
    }

    @Override
    public String toString() {
        return numero + " "+ propietario;
    }
}
