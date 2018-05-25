package cgi.una.ac.cr.examenii.contract;

import android.provider.BaseColumns;

/**
 * Created by allamchaves on 5/24/18.
 */

public class MovimientoBancarioContract {

    public static abstract class MovimientoBancarioEntry implements BaseColumns {
        public static final String TABLE_NAME = "movimientoBancario";

        public static final String _ID = "_id";
        public static final String CUENTA = "cuenta";
        public static final String MONTO = "monto";
        public static final String FECHA = "fecha";
        public static final String DESCRIPCION = "descripcion";

    }
}

