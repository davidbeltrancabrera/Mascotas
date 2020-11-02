package com.davidbeltran.mascotas;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ContactoActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editNombre;
    private EditText editMail;
    private EditText editDescripcion;
    private Button btEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(myToolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        TextView mTitle = (TextView) myToolbar.findViewById(R.id.toolbar_title);

        setSupportActionBar(myToolbar);
        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();
        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setDisplayShowTitleEnabled(false);


        editNombre = (EditText) findViewById(R.id.editNombre);
        editMail = (EditText) findViewById(R.id.editEmail);
        editDescripcion = (EditText) findViewById(R.id.editDescripcion);
        btEnviar = (Button) findViewById(R.id.btEnviar);
        btEnviar.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {

        String enviarcorreo = editMail.getText().toString();
        String enviarnombre = editNombre.getText().toString();
        String enviarmensaje = editDescripcion.getText().toString();

        // Defino mi Intent y hago uso del objeto ACTION_SEND
        Intent intent = new Intent(Intent.ACTION_SEND);

        // Defino los Strings Email, Asunto y Mensaje con la función putExtra
        intent.putExtra(Intent.EXTRA_EMAIL,
                new String[] { enviarcorreo });
        intent.putExtra(Intent.EXTRA_SUBJECT, enviarnombre);
        intent.putExtra(Intent.EXTRA_TEXT, enviarmensaje);

        // Establezco el tipo de Intent
        intent.setType("message/rfc822");

        // Lanzo el selector de cliente de Correo
        startActivity(
                Intent
                        .createChooser(intent,
                                "Elije un cliente de Correo:"));
    }
}