
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
    }
      
      private void MenuOperaciones(){
         Scanner sc=new Scanner(System.in);
          boolean check=false;
        while(check==false){
        System.out.println("Operaciones\n\n");
        System.out.println("1-Ver Listado de Operaciones\n2-Alta Operacion\n3-Baja Operacion\n4-Modificar Operacion\n5-Buscar Operacion\n6-Ver Morosos del mes\n7-PagarAlquiler\n8-Exit");
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
                System.out.println(inmobiliaria.buscarOperacion());
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
                inmobiliaria.PagarAlquiler();
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
    }
    
}
