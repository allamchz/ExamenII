package cgi.una.ac.cr.examenii.entidad;

import java.io.Serializable;

/**
 * Created by allamchaves on 5/25/18.
 */

public class Cambio implements Serializable {

    private int id;
    private int cambio;

    public Cambio() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCambio() {
        return cambio;
    }

    public void setCambio(int cambio) {
        this.cambio = cambio;
    }
}
