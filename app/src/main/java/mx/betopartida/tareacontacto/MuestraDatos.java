package mx.betopartida.tareacontacto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MuestraDatos extends AppCompatActivity {

    /*
    private String nombre;
    private String telefono;
    private String email;
    private String descripcion;
    private String fecha;
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muestra_datos);


        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString(getResources().getString(R.string.pnombre));
        if(nombre.equals("")) nombre="Sin nombre";
        String telefono = parametros.getString(getResources().getString(R.string.ptelefono));
        String email = parametros.getString(getResources().getString(R.string.pemail));
        String descripcion = parametros.getString(getResources().getString(R.string.pdescripcion));
        String fecha = parametros.getString(getResources().getString(R.string.pfecha));
        /*
        int dia = parametros.getString(getResources().getInteger(R.string.pdia));
        int mes = parametros.getString(getResources().getInteger(R.string.pdia));
        int anio = parametros.getString(getResources().getInteger(R.string.pdia));
        */
        TextView tvNombre = (TextView) findViewById(R.id.lblNombre);
        tvNombre.setText(nombre);

        TextView tvFecha = (TextView) findViewById(R.id.lblFecha);
        tvFecha.setText(fecha);

        TextView tvTelefono = (TextView) findViewById(R.id.lblTelefono);
        tvTelefono.setText(telefono);

        TextView tvEmail = (TextView) findViewById(R.id.lblEmail);
        tvEmail.setText(email);

        TextView tvDescripcion = (TextView) findViewById(R.id.lblDescripcion);
        tvDescripcion.setText(descripcion);


        Button boton = (Button) findViewById(R.id.btnEditar);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

}
