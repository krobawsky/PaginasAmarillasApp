package tecsup.rberrospi.laboratorio04.paginasamarillasapp.Datos;

public class Empresa {

    private int id;
    private String rubro;
    private String nombre;
    private String direccion;
    private int telefono;
    private String correo;
    private String url;
    private int logo;
    private String info;

    @Override
    public String toString() {
        return "empresas{" +
                "id=" + id +
                ", rubro='" + rubro + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono=" + telefono +
                ", correo='" + correo + '\'' +
                ", url='" + url + '\'' +
                ", logo=" + logo +
                ", info='" + info + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Empresa(int id, String rubro, String nombre, String direccion, int telefono, String correo, String url, int logo, String info) {
        this.id = id;
        this.rubro = rubro;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.url = url;
        this.logo = logo;
        this.info = info;
    }

    public Empresa(){

    }

}
