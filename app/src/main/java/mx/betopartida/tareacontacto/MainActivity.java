package mx.betopartida.tareacontacto;

import android.app.DatePickerDialog;
import android.app.Dialog;
//import android.app.DialogFragment;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private static int anio=1980;
    private static int mes=0;
    private static int dia=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextInputEditText fecha = (TextInputEditText) findViewById(R.id.txtFecha);
        fecha.setText(getResources().getString(R.string.fechaInicial));

        Button boton = (Button) findViewById(R.id.btnSiguiente);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MuestraDatos.class);
                TextView tv=(TextView) findViewById(R.id.txtNombre);
                intent.putExtra(getResources().getString(R.string.pnombre),tv.getText().toString());
                tv=(TextView) findViewById(R.id.txtFecha);
                intent.putExtra(getResources().getString(R.string.pfecha),tv.getText().toString());
                tv=(TextView) findViewById(R.id.txtTelefono);
                intent.putExtra(getResources().getString(R.string.ptelefono),tv.getText().toString());
                tv=(TextView) findViewById(R.id.txtEmail);
                intent.putExtra(getResources().getString(R.string.pemail),tv.getText().toString());
                tv=(TextView) findViewById(R.id.txtDesc);
                intent.putExtra(getResources().getString(R.string.pdescripcion),tv.getText().toString());

                startActivity(intent);

            }
        });
    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year    = anio;
            int month   = mes;
            int day     = dia;

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            anio=year;
            mes=month;
            dia=day;
            String texto=dia+"/"+(mes+1)+"/"+anio;

            TextInputEditText fecha = (TextInputEditText) getActivity().findViewById(R.id.txtFecha);
            fecha.setText(texto);
        }
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
/*
    public void mostrarDatos() {
        Button boton = (Button) findViewById(R.id.btnSiguiente);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MuestraDatos.class);
                intent.putExtra("@string/pnombre",findViewById(R.id.txtNombre).toString());
                intent.putExtra("@string/pfecha",findViewById(R.id.txtFecha).toString());
                intent.putExtra("@string/ptelefono",findViewById(R.id.txtTelefono).toString());
                intent.putExtra("@string/pemail",findViewById(R.id.txtEmail).toString());
                intent.putExtra("@string/pdescripcion",findViewById(R.id.txtDesc).toString());
                startActivity(intent);
            }
        });
    }
    */
}
