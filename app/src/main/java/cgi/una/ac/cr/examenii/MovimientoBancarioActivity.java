package cgi.una.ac.cr.examenii;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;

import cgi.una.ac.cr.examenii.entidad.Cuenta;
import cgi.una.ac.cr.examenii.entidad.MovimientoBancario;
import cgi.una.ac.cr.examenii.service.MovimientoBancarioService;

public class MovimientoBancarioActivity extends AppCompatActivity {

    /**
     * La instancia de cuenta debe venir cargada desde la activiad
     * MainActivity
     */
    Cuenta cuenta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movimiento_bancario);
        cuenta =(Cuenta) getIntent().getSerializableExtra("cuenta");

        TextView cuentaTxt= (TextView)findViewById(R.id.txtCuenta);
        cuentaTxt.setText(cuenta.getNumero());


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
