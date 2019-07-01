import java.time.LocalDate;
import java.util.Date;

public class Main {
    public static void main(String[] args) {       
        /*
        Domicilio domicilio = new Domicilio();

        Locador locador1 = new Locador("Masculino","39256994","Pafundi",domicilio, "2234218309","asd@gmail.com","");
        Locador locador2 = new Locador("Masculino","39256994","Perez",domicilio, "2234218309","asd@gmail.com","");
        Locador locador3 = new Locador("Masculino","39256994","Lopez",domicilio, "2234218309","asd@gmail.com","");
        Locador locador4 = new Locador("Masculino","39256994","Suarez",domicilio, "2234218309","asd@gmail.com","");

        Locatario locatario1 = new Locatario(2000,"Masculino","39256994","Pafundi",domicilio, "2234218309","asd@gmail.com","");
        Locatario locatario2 = new Locatario(2000,"Masculino","39256994","Suarez",domicilio, "2234218309","asd@gmail.com","");
        Locatario locatario3 = new Locatario(2000,"Masculino","39256994","Perez",domicilio, "2234218309","asd@gmail.com","");
        Locatario locatario4 = new Locatario(2000,"Masculino","39256994","Suarez",domicilio, "2234218309","asd@gmail.com","");
        
        NomenclaturaCatastral nomcas = new NomenclaturaCatastral();
        Duplex inmueble1 = new Duplex(domicilio,"Casa 2 ambientes",nomcas);
        
        Alquiler alquiler1 = new Alquiler(12,30,24,LocalDate.of(2019,6,10), 2000,inmueble1);
        alquiler1.listarCuotas();
        alquiler1.pagarCuota();
        alquiler1.listarCuotas();
        */
        
        OperacionesInmobiliarias op=new OperacionesInmobiliarias();
        op.MenuPrincipal();
        
        

    }
}
