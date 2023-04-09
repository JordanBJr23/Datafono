
package datafono;


public class Main {

    public static void main(String[] args) {
        Datafono datafono = new Datafono();
        Persona persona = new Persona("118490205", "Jordan", "Martinez", "63125137", "jordan@gmail.com");
        TarjetaDeCredito tarjeta = new TarjetaDeCredito("BCR", "123456789101112", 15000, EntidadFinanciera.VISA, persona);
        
        
        System.out.println("Tarjeta antes del pago");
        System.out.println(tarjeta);
        
        System.out.println("Tarjeta tras el pago");
        Ticket ticket =  datafono.efectuarPago(tarjeta, 10000, 5);
        System.out.println(ticket);
        
        System.out.println("Tarjeta despues del pago");
        System.out.println(tarjeta);
    }
    
}
