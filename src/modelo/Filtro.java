
package modelo;


public class Filtro {
    private String ninscripcion;
    private String nombre;
    private String propietario;
    private int edad;
    private String raza;
     private String estado;
    private boolean existencia;

public Filtro(){
}
       public Filtro(String ninscripcion, String nombre, String propietario, int edad, String raza, boolean existencia) {
        this.ninscripcion =ninscripcion ;
        this.nombre = nombre;
        this.propietario = propietario;
        this.edad = edad;
        this.raza = raza;
        this.existencia = existencia;
    }
       
       public Filtro(String nombre, String propietario, int edad, String raza, boolean existencia) {
        this.nombre = nombre;
        this.propietario = propietario;
        this.edad = edad;
        this.raza = raza;
        this.existencia = existencia;
    }
       
       public Filtro( String propietario, int edad, String raza, boolean existencia) {
        this.propietario = propietario;
        this.edad = edad;
        this.raza = raza;
        this.existencia = existencia;
    }

    public String getNinscripcion() {
        return ninscripcion;
    }

    public void setNinscripcion(String ninscripcion) {
        this.ninscripcion = ninscripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isExistencia() {
        return existencia;
    }

    public void setExistencia(boolean existencia) {
        this.existencia = existencia;
    }
       public boolean getExistencia(){
           return existencia;
       }
}






