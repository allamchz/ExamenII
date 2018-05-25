package cgi.una.ac.cr.examenii;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

import cgi.una.ac.cr.examenii.entidad.MovimientoBancario;
import cgi.una.ac.cr.examenii.service.MovimientoBancarioService;

/**
 * Created by allamchaves on 5/24/18.
 */

public class MovimientoBancarioListAdapter extends ArrayAdapter<MovimientoBancario> implements View.OnClickListener{
    private ArrayList<MovimientoBancario> dataSet;
    Context mContext;



    public MovimientoBancarioListAdapter(ArrayList<MovimientoBancario> data, Context context) {
        super(context, R.layout.list_movimiento_bancario, data);
        this.dataSet = data;
        this.mContext=context;

    }

    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        MovimientoBancario  dataModel=(MovimientoBancario)object;

        /**
         * Se tiene que llamar la actividad MovimientoBancarioActivity
         * y mostrar la entidad seleccionada de consulta
         */

    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        MovimientoBancario dataModel = getItem(position);

        if (convertView == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            convertView = vi.inflate(R.layout.list_movimiento_bancario ,null);
        }

        TextView descripcion= (TextView) convertView.findViewById(R.id.listDescripcion);
        TextView monto= (TextView)convertView.findViewById(R.id.listMonto);
        TextView  fecha= (TextView)convertView.findViewById(R.id.listFecha);


        descripcion.setText(dataModel.getDescripcion());
        monto.setText(String.valueOf(dataModel.getMonto()));
        Calendar cal = Calendar.getInstance();
        cal.setTime(dataModel.getFecha());
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        fecha.setText(year+"-"+month+"-"+day);
        convertView.setOnClickListener(this);
        convertView.setTag(position);


        return convertView;
    }
}
