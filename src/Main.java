import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Domicilio output = new Domicilio();
        System.out.println( output );

        Cliente cliente = new Cliente( "M", "28293509", "Apellido", output, "223223223", "ecqwecewqc@afaefea.com", "" );
        System.out.println(cliente);
    }
}
