package cgi.una.ac.cr.examenii;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

import cgi.una.ac.cr.examenii.entidad.Cuenta;
import cgi.una.ac.cr.examenii.entidad.MovimientoBancario;
import cgi.una.ac.cr.examenii.service.MovimientoBancarioService;

public class MainActivity extends AppCompatActivity {
    ArrayList dataModels;
    MovimientoBancarioService movimientoService;
    ListView listView;
    MovimientoBancarioListAdapter adapter;
    Cuenta cuenta;
    TextView txtSaldo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        cuenta = new Cuenta();
        cuenta.set_id(1);
        cuenta.setNumero("22004-444-22");
        cuenta.setSaldo(100000000);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        txtSaldo =(TextView)findViewById(R.id.labelSaldoMonto);
        DecimalFormat df = new DecimalFormat("₡###,###,###.##");
        txtSaldo.setText(df.format(cuenta.getSaldo()));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, MovimientoBancarioActivity.class);
                intent.putExtra("cuenta",cuenta );
                startActivity(intent);
            }
        });

        listView=(ListView)findViewById(R.id.listMovimientos);
        movimientoService = new MovimientoBancarioService(this);

        View header = getLayoutInflater().inflate(R.layout.header_movimiento_bancario, null);
        listView.addHeaderView(header);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                MovimientoBancario dataModel= (MovimientoBancario)dataModels.get(position);


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onResume(){


        dataModels=(ArrayList) movimientoService.findAll();
        adapter= new MovimientoBancarioListAdapter(dataModels,getApplicationContext());
        listView.setAdapter(adapter);
        listView.invalidateViews();
        super.onResume();


    }
}
