package tecsup.rberrospi.laboratorio04.paginasamarillasapp.Datos;

import java.util.ArrayList;
import java.util.List;

import tecsup.rberrospi.laboratorio04.paginasamarillasapp.R;

public class EmpresaRepository {

    private static EmpresaRepository _INSTANCE = null;

    private EmpresaRepository(){}

    public static EmpresaRepository getInstance(){
        if(_INSTANCE == null)
            _INSTANCE = new EmpresaRepository();
        return _INSTANCE;
    }

    private List<Empresa> nombre = new ArrayList<>();
    private List<Empresa> direccion = new ArrayList<>();
    private List<Empresa> telefono = new ArrayList<>();


    public List<Empresa> getDatos() {
        return this.nombre;
    }


    Empresa empresa1 = new Empresa(123, "rubro", "nombre", "direccion", 9394823,"correo","link", R.drawable.bg_anuncio,"info");
    Empresa empresa2 = new Empresa(123, "rubro", "nombre", "direccion", 9394823,"correo","link",R.drawable.bg_anuncio,"info");
    Empresa empresa3 = new Empresa(123, "rubro", "nombre", "direccion", 9394823,"correo","link",R.drawable.bg_anuncio,"info");

}
