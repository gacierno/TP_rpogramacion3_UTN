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
            System.out.println("1-Ver Listado de clientes\n2-Alta Cliente\n3-Baja Cliente\n4-Modificar Cliente\n5-Buscar Cliente\n6-Ver clientes inactivos\n7-Activar cliente pre existente\n8-Exit");
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
                    try{
                    this.inmobiliaria.listarClientes();
                    System.out.println("Seleccione el id del cliente que quiere modificar");                    
                    this.inmobiliaria.modificarCliente(sc.nextInt());
                    }catch(Exception e){
                        System.out.println(e);
                    }
                    break;
                case 5:
                    System.out.println(inmobiliaria.buscarCliente());
                    break;
                case 6:
                    try{
                    System.out.println("Clientes Inactivos;");
                     this.inmobiliaria.getClientes().listarInactivas();
                    }catch(Exception e){
                        System.out.println(e);
                    }
                     break;
                case 7:
                     try{
                    System.out.println("Id del cliente que desea reactivar:;");
                     this.inmobiliaria.getClientes().buscarParaActivarId(sc.nextInt());
                    }catch(Exception e){
                        System.out.println(e);
                    }
                     break;
                case 8:
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
            System.out.println("1-Ver Listado de Inmuebles\n2-Alta Inmueble\n3-Baja Inmueble\n4-Modificar Inmueble\n5-Buscar Inmueble\n6-Ver inmuebles inactivos\n7-Activar inmueble pre existente\n8-Exit");
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
                      try{
                    this.inmobiliaria.listarInmuebles();
                    System.out.println("Seleccione el id del inmueble que quiere modificar");                    
                    this.inmobiliaria.modificarInmueble(sc.nextInt());
                    }catch(Exception e){
                        System.out.println(e);
                    }
                    break;
                case 5:
                    System.out.println(inmobiliaria.buscarInmueble());
                    break;
                  case 6:
                    try{
                    System.out.println("Inmuebles Inactivos;");
                     this.inmobiliaria.getInmuebles().listarInactivas();
                    }catch(Exception e){
                        System.out.println(e);
                    }
                     break;
                case 7:
                     try{
                    System.out.println("Id del inmueble que desea reactivar:;");
                     this.inmobiliaria.getInmuebles().buscarParaActivarId(sc.nextInt());
                    }catch(Exception e){
                        System.out.println(e);
                    }
                     break;                    
                case 8:
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

            System.out.println("1-Ver Listado de Operaciones\n2-Alta Operacion\n3-Baja Operacion\n4-Modificar Cuota de alquiler\n5-Buscar Operacion\n6-Ver Morosos del mes\n7-Pagar Alquiler de este mes\n8-Pagar alquiler\n9-Ver operaciones inactivoas\n10-Activar operaciones pre existente\n11-Exit");

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
                    try{
                     this.inmobiliaria.modificarCuotaDeAlquiler();
                    }catch(Exception e){
                        System.out.println(e);
                    }
                        
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
                        try{
                        System.out.println("Operaciones Inactivas:");
                         this.inmobiliaria.getOperaciones().listarInactivas();
                        }catch(Exception e){
                            System.out.println(e);
                        }
                         break;
                    case 10:
                         try{
                        System.out.println("Id de la operacion que desea reactivar:");
                         this.inmobiliaria.getOperaciones().buscarParaActivarId(sc.nextInt());
                        }catch(Exception e){
                            System.out.println(e);
                        }

                case 11:
                    check=true;
                    break;
                default:
                    System.out.println("No existe esa opcion");
                    break;
            }
        }

          try{
              System.out.println(this.inmobiliaria.getOperaciones());
              ServiceSaveFile<Operacion> saveOperacion = new ServiceSaveFile<>( "operaciones.dat", this.inmobiliaria.getOperaciones() );
          }catch ( Exception e ){
              throw e;
          }

    }
    
}
