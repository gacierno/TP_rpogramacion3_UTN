import java.time.LocalDate;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Domicilio output = new Domicilio();
        System.out.println( output );
        
        Inmueble inmueble=new Inmueble();
        Alquiler alquiler1=new Alquiler(12,30,24,LocalDate.of(2019,6,10), 2000,inmueble,"10/10");
        alquiler1.listarCuotas();
        alquiler1.pagarCuota();
        alquiler1.listarCuotas();
    }
}
