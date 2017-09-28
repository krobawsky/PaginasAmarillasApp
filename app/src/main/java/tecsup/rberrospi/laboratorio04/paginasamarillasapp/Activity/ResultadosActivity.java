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
    String[] rubros = {
            "Comidas",
            "Comidas",
            "Comidas",
            "Comidas",
            "Educación",
            "Educación",
            "Educación",
            "Automóviles",
            "Entretenimiento",
            "Hoteles"};
    String[] nombres = {
            "Pizza Hut",
            "China Wok",
            "Pollo John",
            "Norky's",
            "Icpna",
            "Senati",
            "Tecsup",
            "Toyota",
            "PlayStation",
            "Sheraton"};
    String[] direcciones = {
            "Real Plaza Centro Civico, Av. Garcilaso de la Vega 1337, Cercado de Lima 15001",
            "Centro Comercial Jockey Plaza, Av. Javier Prado Este 4200, Santiago de Surco 15023",
            "Av. Del parque sur. Ciudad Delicias, Chihuahua, Mexico",
            "General Garzón 1280, Jesús María 15072",
            "Av. Angamos Oeste 160, Miraflores 15074",
            "Alfredo Mendiola 3540, Independencia 15311",
            "Santa Anita, Avenida Cascanueces 2221, Lima 15011",
            "Av. Santo Toribio N° 173, Vía Central N° 125, Lima, Perú, Cercado de Lima",
            "Tienda 4-09, Centro Comercial Arenales, Av Arenales 1759, Cercado de Lima",
            "Av Paseo de la República 170, Cercado de Lima 15001"};
    String[] telefonos = {
            "(01) 5055001",
            "(01) 4342397",
            "+52 639 147 2714",
            "(01) 4330457",
            "(01) 7067000",
            "(01) 2089999",
            "(01) 3173900",
            "(01) 6111000",
            "(01) 2795444",
            "(01) 3155000"};
    String [] correos = {
            "pizzahut@gmail.com",
            "chinawok@gmail.com",
            "@pollo.john.delicias",
            "norkys@gmail.com",
            "icpna@gmail.com",
            "senati@gmail.com",
            "tecsup@gmail.com",
            "toyotaperu@gmail.com",
            "playstation@gmail.com",
            "sheratonlima@gmail.com"};
    String [] url = {
            "https://www.pizzahut.com.pe/Online/Home/Home",
            "http://www.chinawok.com.pe/",
            "https://www.facebook.com/pg/pollo.john.delicias/about/?ref=page_internal",
            "http://norkys.pe/",
            "http://www.icpna.edu.pe/",
            "http://www.senati.edu.pe/web/",
            "http://www.tecsup.edu.pe/home/",
            "https://www.toyotaperu.com.pe/",
            "https://www.playstation.com/es-pe/",
            "www.sheratonlima.com/es"};;
    int[] logos = {
            R.drawable.img_empresa1,
            R.drawable.img_chinawok,
            R.drawable.img_pollo,
            R.drawable.img_pollon,
            R.drawable.img_icpna,
            R.drawable.img_senati,
            R.drawable.img_tecsup,
            R.drawable.img_toyota,
            R.drawable.img_playstation,
            R.drawable.img_sheraton};
    String[] infos = {
            "Desde la increíble experiencia de su sabor hasta su delicioso aspecto y rico olor. Hemos venido haciendo pizza por más de 40 años y nuestra pasión es la base para todo lo que hacemos.",
            "China Wok es una empresa peruana de comida rápida, dedicada al rubro de la gastronomía peruano-china.",
            "Variedad de productos de pollo, frescos y congelados, asi como sus riquicimos platillos.",
            "Ven con tu familia y disfruta del más delicioso Pollo a la Brasa del Perú, y de las mejores parrillas.",
            "La enseñanza del idioma inglés se basa en un sistema metodológico especialmente desarrollado que articula la extensa experiencia institucional del ICPNA con las mejores prácticas metodológicas  en el campo de la enseñanza del inglés como lengua extranjera.",
            ":v",
            "Tecsup es una organización educativa privada sin fines de lucro, dedicada a formar y capacitar profesionales, así como brindar servicios de consultoría, investigación y aplicación de tecnología.",
            "Toyota Motor Corporation, simplemente llamado Toyota, es un fabricante de automóviles japonés con sede en Toyota, Japón.",
            "Desafía los límites de los juegos con las consolas de videojuegos PlayStation. Conoce la gama de consolas PS4, PS Vita y goza de la mejor experiencia.",
            "El Sheraton Lima Hotel & Convention Center, conocido simplemente como Hotel Sheraton es un hotel de 5 estrellas ubicado en el Paseo de los Héroes Navales, primera cuadra del Paseo de la República en pleno centro de Lima, capital del Perú."};;

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
