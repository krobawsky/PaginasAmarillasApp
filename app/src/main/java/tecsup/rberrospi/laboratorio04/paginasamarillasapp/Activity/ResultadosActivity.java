package tecsup.rberrospi.laboratorio04.paginasamarillasapp.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import tecsup.rberrospi.laboratorio04.paginasamarillasapp.Datos.EmpresaAdapter;
import tecsup.rberrospi.laboratorio04.paginasamarillasapp.R;

public class ResultadosActivity extends AppCompatActivity {

    TextView cateogoria;
    ListView lv;
    String valor;

    int[] ids = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    String[] rubros = { "Comidas", "rubro2", "rubro3", "rubro4", "rubro5", "rubro6", "rubro7", "rubro8", "rubro9", "rubro10"};
    String[] nombres = {"Pizza Hut", "Nombre2", "Nombre3", "Nombre4", "Nombre5", "Nombre6", "Nombre7", "Nombre8", "Nombre9", "Nombre10"};
    String[] direcciones = {"Real Plaza Centro Civico, Av. Garcilaso de la Vega 1337, Cercado de Lima 15001", "direccion2", "direccion3", "direccion4", "direccion5", "direccion6", "direccion7", "direccion8", "direccion9", "direccion10"};
    String[] telefonos = {"(01) 5055001", "909090902", "909090903", "909090904", "909090905", "909090906", "909090907", "909090908", "909090909", "909090900"};
    String [] correos = {"pizzahut@gmail.com", "correo2", "correo3", "correo4", "correo5", "correo6", "correo7", "correo8", "correo9", "correo10"};
    String [] url = {"https://www.pizzahut.com.pe/Online/Home/Home", "http://www.info2.com", "http://www.info3.com", "http://www.info4.com", "http://www.info5.com", "http://www.info6.com", "http://www.info7.com", "http://www.info8.com", "http://www.info9.com", "http://www.info10.com"};;
    int[] logos = {R.drawable.img_empresa1, R.drawable.bg_anuncio, R.drawable.bg_anuncio, R.drawable.bg_anuncio, R.drawable.bg_anuncio, R.drawable.bg_anuncio, R.drawable.bg_anuncio, R.drawable.bg_anuncio, R.drawable.bg_anuncio, R.drawable.bg_anuncio};
    String[] infos = {"Desde la increíble experiencia de su sabor hasta su delicioso aspecto y rico olor. Hemos venido haciendo pizza por más de 40 años y nuestra pasión es la base para todo lo que hacemos.", "info2", "info3", "info4", "info5", "info6", "info7", "info8", "info9", "info10"};;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        cateogoria = (TextView) findViewById(R.id.text);
        valor = getIntent().getExtras().getString("value");
        cateogoria.setText("0 resultados para " + valor + " en Perú");

        lv = (ListView) findViewById(R.id.idListView);
        EmpresaAdapter adapter = new EmpresaAdapter(this, nombres, direcciones, telefonos, logos);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v, int posicion, long id) {

                Intent intent = new Intent(ResultadosActivity.this, DetalleActivity.class);
                intent.putExtra("id", ids[posicion]);
                intent.putExtra("rubro", rubros[posicion]);
                intent.putExtra("nombre", nombres[posicion]);
                intent.putExtra("direccion", direcciones[posicion]);
                intent.putExtra("telefono", telefonos[posicion]);
                intent.putExtra("correo", correos[posicion]);
                intent.putExtra("url", url[posicion]);
                intent.putExtra("logo", logos[posicion]);
                intent.putExtra("info", infos[posicion]);
                startActivity(intent);
            }
        });
    }



}
