package cgi.una.ac.cr.examenii;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import cgi.una.ac.cr.examenii.entidad.Cuenta;
import cgi.una.ac.cr.examenii.entidad.MovimientoBancario;
import cgi.una.ac.cr.examenii.service.MovimientoBancarioService;

public class MovimientoBancarioActivity extends AppCompatActivity {

    /**
     * La instancia de cuenta debe venir cargada desde la activiad
     * MainActivity
     */
    Cuenta cuenta;
    List<Cuenta> cuentas =  new ArrayList<Cuenta>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movimiento_bancario);
        cuenta =(Cuenta) getIntent().getSerializableExtra("cuenta");

        TextView cuentaTxt= (TextView)findViewById(R.id.txtCuenta);
        cuentaTxt.setText(cuenta.getNumero());


        /**
         * Se cargan las cuentas de destino. Fijas para el ejemplo
         **/
        cuentas.add(new Cuenta(1,100,"737-333-333", "Juan Ramón"));
        cuentas.add(new Cuenta(2,100,"834-384-304","Linda Chavez"));
        cuentas.add(new Cuenta(3,100,"264-405-293","Pedro Guerra"));
        cuentas.add(new Cuenta(4,100,"163-343-123","Julio Zamora"));

        ArrayAdapter<Cuenta> adapter = new ArrayAdapter<Cuenta>(
                this, android.R.layout.simple_spinner_item, cuentas);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) findViewById(R.id.comboDestino);
        sItems.setAdapter(adapter);



    }

    public void guardar(View view) {
        TextView descripcion= (TextView) findViewById(R.id.txtDetalle);
        TextView monto= (TextView)findViewById(R.id.txtMonto);


        MovimientoBancarioService movimientoService = new MovimientoBancarioService(getApplicationContext());
        MovimientoBancario movimiento= new MovimientoBancario();

        movimiento.setDescripcion(descripcion.getText().toString());
        Calendar myCal = Calendar.getInstance();
        movimiento.setFecha(myCal.getTime());
        movimiento.setMonto(Float.valueOf(monto.getText().toString()));
        movimiento.setCuenta(cuenta);
        movimientoService.create(movimiento);
        finish();
    }
}
