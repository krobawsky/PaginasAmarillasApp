package tecsup.rberrospi.laboratorio04.paginasamarillasapp.Activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import tecsup.rberrospi.laboratorio04.paginasamarillasapp.R;

public class DetalleActivity extends AppCompatActivity {

    TextView empresaRubro;
    TextView empresaNombre;
    TextView empresaDireccion;
    TextView empresaTelefono;
    ImageView empresaLogo;
    TextView empresaInfo;

    int id;
    String rubro;
    String nombre;
    String direccion;
    String telefono;
    String correo;
    String url;
    int logo;
    String info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        empresaRubro = (TextView) findViewById(R.id.idRubro);
        empresaNombre = (TextView) findViewById(R.id.idNombre);
        empresaDireccion = (TextView) findViewById(R.id.idDireccion);
        empresaTelefono = (TextView) findViewById(R.id.idTelefono);
        empresaLogo = (ImageView) findViewById(R.id.idImagen);
        empresaInfo = (TextView) findViewById(R.id.idInfo);

        id = getIntent().getExtras().getInt("id");
        rubro = getIntent().getExtras().getString("rubro");
        nombre = getIntent().getExtras().getString("nombre");
        direccion = getIntent().getExtras().getString("direccion");
        telefono = getIntent().getExtras().getString("telefono");
        correo = getIntent().getExtras().getString("correo");
        url = getIntent().getExtras().getString("url");
        logo = getIntent().getExtras().getInt("logo");
        info = getIntent().getExtras().getString("info");

        empresaRubro.setText(rubro);
        empresaNombre.setText(nombre);
        empresaDireccion.setText(direccion);
        empresaTelefono.setText(telefono);
        empresaLogo.setImageResource(logo);
        empresaInfo.setText(info);
    }

    public void goUrl(View v) {
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void goMail(View v) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, correo);
        emailIntent.putExtra(Intent.EXTRA_CC, correo);

        try {
            startActivity(Intent.createChooser(emailIntent, "Enviar email..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(DetalleActivity.this,
                    "No tienes clientes de email instalados.", Toast.LENGTH_SHORT).show();
        }
    }

    public void goSms(View v) {
        Intent sendIntent = new Intent(Intent.ACTION_VIEW);
        sendIntent.setType("vnd.android-dir/mms-sms");
        sendIntent.putExtra("address", telefono);
        sendIntent.putExtra("sms_body", "");
        startActivity(sendIntent);
    }

    public void goShare(View v){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, url);
        startActivity(Intent.createChooser(intent, "Share with"));
    }

    public void goCall(View v){
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);

        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    Integer.parseInt("123"));
        } else {
            startActivity(new Intent(Intent.ACTION_CALL).setData(Uri.parse("tel:"+ telefono)));
        }
    }

}
