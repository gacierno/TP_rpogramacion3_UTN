import java.io.IOException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asd
 */
public class OperacionesInmobiliarias {
    public Inmobiliaria inmobiliaria;
    public OperacionesInmobiliarias(){
        inmobiliaria=new Inmobiliaria();
    }
    
    public void MenuPrincipal(){
        
        Scanner sc=new Scanner(System.in);
        boolean check=false;
        while(check==false){
        System.out.println("Programa de administracion de alquileres\n\n");
        System.out.println("1-Clientes\n2-Inmuebles\n3-Operaciones\n4-Exit");
        int opcion=sc.nextInt();
        switch(opcion){
            case 1:
                MenuClientes();
                break;
            case 2:
                MenuInmuebles();
                break;  
            case 3:
                MenuOperaciones();
                break;
            case 4:
                check=true;
                break;
            default:
                System.out.println("No existe esa opcion");
                break;
        }
        }
    }
    
    private void MenuClientes(){
        Scanner sc=new Scanner(System.in);
        boolean check=false;
        while(check==false){
            System.out.println("CLIENTES\n\n");
            System.out.println("1-Ver Listado de clientes\n2-Alta Cliente\n3-Baja Cliente\n4-Modificar Cliente\n5-Buscar Cliente\n6-Exit");
            int opcion=sc.nextInt();
            switch(opcion){
                case 1:
                    try{
                        inmobiliaria.listarClientes();
                    }catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 2:
                    inmobiliaria.altaCliente();
                    break;
                case 3:
                    inmobiliaria.bajaCliente();
                    break;
                case 4:
                    System.out.println("FALTA MODIFICAR");
                    break;
                case 5:
                    System.out.println(inmobiliaria.buscarCliente());
                    break;
                case 6:
                    check=true;
                    break;
                default:
                    System.out.println("No existe esa opcion");
                    break;
            }
        }
        try{
            ServiceSaveFile<Cliente> saveCliente = new ServiceSaveFile<Cliente>( "clientes.dat", this.inmobiliaria.getClientes() );
        }catch ( Exception e ){
            throw e;
        }
    }
    
      private void MenuInmuebles(){
         Scanner sc=new Scanner(System.in);
          boolean check=false;
        while(check==false){
            System.out.println("INMUEBLES\n\n");
            System.out.println("1-Ver Listado de Inmuebles\n2-Alta Inmueble\n3-Baja Inmueble\n4-Modificar Inmueble\n5-Buscar Inmueble\n6-Exit");
            int opcion=sc.nextInt();
            switch(opcion){
                case 1:
                    try{
                    inmobiliaria.listarInmuebles();
                    }catch(Exception e){
                        System.out.println(e);
                    }
                    break;
                case 2:
                    inmobiliaria.altaInmueble();
                    break;
                case 3:
                    inmobiliaria.bajaInmueble();
                    break;
                case 4:
                    System.out.println("FALTA MODIFICAR");
                    break;
                case 5:
                    System.out.println(inmobiliaria.buscarInmueble());
                    break;
                case 6:
                    check=true;
                    break;
                default:
                    System.out.println("No existe esa opcion");
                    break;
            }

        }
        try{
            ServiceSaveFile<Inmueble> saveInmueble = new ServiceSaveFile<Inmueble>( "inmuebles.dat", this.inmobiliaria.getInmuebles() );
        }catch ( Exception e ){
            throw e;
        }

    }
      
      private void MenuOperaciones(){
        Scanner sc=new Scanner(System.in);
        boolean check=false;
        while(check==false){
            System.out.println("Operaciones\n\n");

            System.out.println("1-Ver Listado de Operaciones\n2-Alta Operacion\n3-Baja Operacion\n4-Modificar Operacion\n5-Buscar Operacion\n6-Ver Morosos del mes\n7-Pagar Alquiler de este mes\n8-Pagar alquiler\n9-Exit");

            int opcion=sc.nextInt();
            switch(opcion){
                case 1:
                    try{
                    inmobiliaria.listarOperaciones();
                    }catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 2:
                    try{
                    inmobiliaria.altaOperacion();
                    }catch(Exception e){
                        System.out.println(e);
                    }
                    break;
                case 3:
                    inmobiliaria.bajaOperacion();
                    break;
                case 4:
                    System.out.println("FALTA MODIFICAR");
                    break;
                case 5:

                    try{
                    Alquiler operacion=(Alquiler)inmobiliaria.buscarOperacion();
                    System.out.println(operacion);
                    operacion.listarCuotas();
                    }catch(Exception e){
                        System.out.println(e);
                    }
                    break;                    

                case 6:
                    try{
                    inmobiliaria.listarMorosos();
                    }catch(Exception e){
                        System.out.println(e);
                    }
                    break;
                case 7:
                    try{

                    inmobiliaria.PagarAlquilerDelMes();

                    }catch(Exception e){
                        System.out.println(e);
                    }
                    break;
                case 8:

                    try{
                    inmobiliaria.listarOperaciones();
                    System.out.println("Elija el alquiler que desea pagar");
                    int id=sc.nextInt();
                    ((Alquiler)inmobiliaria.getOperaciones().buscarPorId(id)).listarCuotas();
                    System.out.println("Elija cuota que desea pagar");
                    int num=sc.nextInt();
                    inmobiliaria.PagarAlquilerById(id,num);
                    }catch(Exception e){
                        System.out.println(e);
                    }
                    break;
                case 9:

                    check=true;
                    break;
                default:
                    System.out.println("No existe esa opcion");
                    break;
            }
        }

          try{
              ServiceSaveFile<Operacion> saveOperacion = new ServiceSaveFile<Operacion>( "operaciones.dat", this.inmobiliaria.getOperaciones() );
          }catch ( Exception e ){
              throw e;
          }

    }
    
}
