
package datafono;


public class Datafono {
    public static final double RECARGO_POR_CUOTA = 0.03;
    public static final int MIN_CANT_CUOTAS = 1;
    public static final int MAX_CANT_COUTAS = 6;
    // Metodo que retorna un ticket
    // En este metodo se efectua  un pago recibiendo como parametros una tarjeta de credito el monto que se
//    desea abonar y en la cantidad de cuotas que lo desea abonar
    public Ticket efectuarPago(TarjetaDeCredito tarjeta, double montoAbonar, int cantidadCuotas){
        // El ticket se inicializa en null mientras no se cumplan una series de condiciones no se podra efectuar
//        un pago y por lo tanto no se podra generar un ticket
        Ticket elTicket = null;
        // La primera condicion nos lleva a un metodo que va a validar si la tarjeta,
//        el monto a abonar y la cantidad de cuotas son validas 
        if (datosValidos(tarjeta, montoAbonar, cantidadCuotas)) {
            // una vezz que se haya validado vamos a calcular el monto que se va a descalfar del
            //saldo de la tarjeta
            double montoFinal = montoAbonar + montoAbonar * recargoPorCuota(cantidadCuotas);
            // este tendra un recargo de acuerdo a las cuotas que se pidan
           
            //En esta condicion verificamos si la tarjeta tiene el saldo disponible
            // esto con un  metodo que contiene la misma tarjeta
            if (tarjeta.saldoDisponible(montoFinal)) {
//                al cumplir esa condicion vamos a realizar otro metodo que contiene la tarjeta y ese 
//                ese es descontar el monto final
                
                tarjeta.descontar(montoFinal);
                
                // en este caso le pedimos a la tarjeta que nos de el titular para asi poder mandarselo al ticket
                String cliente = tarjeta.dameTitular();
                
                // aqui calculamos el monto por cuota
                double montoPorCuota = montoFinal / cantidadCuotas;
                // al final generamos el ticket con esto parametros
                elTicket = new Ticket(cliente, montoFinal, montoPorCuota);
            }
        }
        return elTicket;
    }
    
    private boolean datosValidos(TarjetaDeCredito tarjeta,double montoAbonar, int cantCuotas){
        return tarjeta!= null &&  montoAbonar > 0 && (cantCuotas >= MIN_CANT_CUOTAS && cantCuotas <= MAX_CANT_COUTAS) ;
    }
    
    private double recargoPorCuota(int cantidadDecuotas){
        return (cantidadDecuotas - 1) * RECARGO_POR_CUOTA;
    }
    
}
