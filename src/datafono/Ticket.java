
package datafono;


public class Ticket {
    private String nombre;
    private double montoTotal;
    private double montoPorCuota;

    public Ticket(String nombre, double montoTotal, double montoPorCuota) {
        this.nombre = nombre;
        this.montoTotal = montoTotal;
        this.montoPorCuota = montoPorCuota;
    }

    @Override
    public String toString() {
        return "Ticket{" + "nombre=" + nombre + ", montoTotal=" + montoTotal + ", montoPorCuota=" + montoPorCuota + '}';
    }
    
    
    
}
