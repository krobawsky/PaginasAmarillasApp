package tecsup.rberrospi.laboratorio04.paginasamarillasapp.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import tecsup.rberrospi.laboratorio04.paginasamarillasapp.R;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextView;
    String valor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String [] categorias = {"Automóviles","Motocicletas","Restaurantes","Hoteles","Rentas","Florerias","Mercados",
                "Alimentos","Bebidas","Domicilios","Construcción","Maquinaria", "Servicios", "Videos", "Transporte"};

        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, categorias);
        autoCompleteTextView.setAdapter(adapter);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(MainActivity.this, ResultadosActivity.class);
                valor = autoCompleteTextView.getText().toString();
                intent.putExtra("value", valor);
                startActivity(intent);
            }
        });
    }

    public void Buscar(View view){
        Intent intent = new Intent(MainActivity.this, ResultadosActivity.class);
        valor = autoCompleteTextView.getText().toString();
        intent.putExtra("value", valor);
        startActivity(intent);
    }
}
