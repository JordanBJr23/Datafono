
package datafono;


public class Persona {
    private String cedula;
    private String nombre;
    private String apellido;
    private String telefono;
    private String mail;

    public Persona(String cedula, String nombre, String apellido, String telefono, String mail) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.mail = mail;
    }
    public String dameTuNombre(){
        return nombre + " " + apellido;
    }
    
    
}
