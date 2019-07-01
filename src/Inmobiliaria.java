
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 */
public class Inmobiliaria{
    private MyCollection<Inmueble> inmuebles;
    private MyCollection<Cliente> clientes;
    private MyCollection<Operacion> operaciones; 
  

    public Inmobiliaria() {   
        inmuebles=new MyCollection();
        clientes=new MyCollection();
        operaciones=new MyCollection();
    }

    public MyCollection<Inmueble> getInmuebles() {
        return inmuebles;
    }

    public void setInmuebles(MyCollection<Inmueble> inmuebles) {
        this.inmuebles = inmuebles;
    }

    public MyCollection<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(MyCollection<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public String toString() {
        return "Inmobiliaria{" + "inmuebles=" + inmuebles + ", clientes=" + clientes + '}';
    }
    
    public void altaInmueble(){
        Scanner sc =new Scanner(System.in);
        System.out.println("Tipo De Inmueble: 1-Duplex 2-PH 3-Casa 4-Lote 5-Departamento");
        int tipo=sc.nextInt();
        Domicilio domicilio= this.AgregarDomicilio();
        System.out.println("Descripcion:");
        String descripcion=sc.nextLine();
        sc.nextLine();
        NomenclaturaCatastral nomCatastral= this.AgregarNomenclaturaCatastral();
        
        Inmueble inmueble = null;
        switch(tipo) {
            case 1:
              inmueble=new Duplex(domicilio, descripcion, nomCatastral);
              break;
            case 2:
              inmueble=new PH(domicilio, descripcion, nomCatastral);
              break;
            case 3:
              inmueble=new Casa(domicilio, descripcion, nomCatastral);
              break;
            case 4:
              inmueble= new Lote(domicilio, descripcion, nomCatastral);
              break;
            case 5:
                System.out.println("Cochera:");
                String cochera=sc.nextLine();
                sc.nextLine();
                 inmueble= new Departamento(cochera,domicilio, descripcion, nomCatastral);
                break;              
            default:
              // code block
          }
        if(inmueble!=null)
        inmuebles.alta(inmueble);
    }
    private Domicilio AgregarDomicilio(){
        Scanner sc= new Scanner(System.in);
        
        System.out.println("Calle: ");
        String calle=sc.nextLine();
        sc.nextLine();
        System.out.println("Numero:");
        int numero=sc.nextInt();
        System.out.println("Departamento:");
        String departamento= sc.nextLine();
        sc.nextLine();
        System.out.println("Codigo postal:");
        int codPostal=sc.nextInt();
        System.out.println("Ciudad");
        String ciudad=sc.nextLine();
        sc.nextLine();
        System.out.println("Provincia:");
        String provincia=sc.nextLine();
        sc.nextLine();
        System.out.println("Pais:");
        String pais=sc.nextLine();
        sc.nextLine();
        
        return new Domicilio(calle,numero,departamento,codPostal,ciudad,provincia,pais);
    }
    private NomenclaturaCatastral AgregarNomenclaturaCatastral(){        
        Scanner sc= new Scanner(System.in);
        System.out.println("Circunscripcion:");
        int circunscripcion=sc.nextInt();
        System.out.println("Seccion:");
        char seccion=sc.nextLine().charAt(0);
        sc.nextLine();
        System.out.println("Manzana");
        String manzana=sc.nextLine();
        sc.nextLine();
        System.out.println("Parcela");
        int parcela=sc.nextInt();
       
        return new NomenclaturaCatastral(circunscripcion,seccion,manzana,parcela);        
    }
    public void altaCliente(){
         Scanner sc =new Scanner(System.in);
        System.out.println("Tipo De Cliente: 1-Locador 2-Locatario 3-Garante");
        int tipo=sc.nextInt();
        System.out.println("Sexo:");
        String sexo=sc.nextLine();
        sc.nextLine();
        System.out.println("DNI:");
        String dni=sc.nextLine();
        System.out.println("Apellido");
        String apellido=sc.nextLine();    
        Domicilio domicilio= this.AgregarDomicilio();
        System.out.println("Telefono:");
        String telefono=sc.nextLine();
        sc.nextLine();
        System.out.println("Email:");
        String email=sc.nextLine();
        sc.nextLine();
        System.out.println("Observacion");
        String observacion=sc.nextLine(); 
        sc.nextLine();
        
        
        double sueldo;
        Cliente cliente = null;
        switch(tipo) {
            case 1:
              cliente=new Locador( sexo,  dni,  apellido,  domicilio,  telefono,  email,  observacion);
              break;
            case 2:
                System.out.println("Sueldo:");
                sueldo=sc.nextDouble();
              cliente=new Locatario(sueldo, sexo,  dni,  apellido,  domicilio,  telefono,  email,  observacion);
              break;
            case 3:
                System.out.println("Sueldo:");
                sueldo=sc.nextDouble();
              cliente=new Garante(sueldo, sexo,  dni,  apellido,  domicilio,  telefono,  email,  observacion);
              break;                    
            default:
              // code block
          }
        if(cliente!=null)
        clientes.alta(cliente);
    }
    
    public void altaOperacion() throws Exception{
        try{
        Scanner sc=new Scanner(System.in);
        System.out.println("Tipo de Aumento (6 o 12 meses):");
        int tipoAumento=sc.nextInt();
        System.out.println("Porcentaje de Aumento:");
        int porcentajeAumento=sc.nextInt();
        System.out.println("Duracion de la operacion:");
        int duracion=sc.nextInt();
        System.out.println("Fecha de inicio");
        System.out.println("Año:");
        int año=sc.nextInt();
        System.out.println("Mes:");
        int mes=sc.nextInt();
        System.out.println("Dia");
        int dia=sc.nextInt();
        LocalDate fechaInicio=LocalDate.of(año,mes,dia);
        System.out.println("Valor Inicial");
        double valorInicial=sc.nextDouble();
        System.out.println("Seleccionar Inmueble segun Id: ");
        this.listarInmuebles();
        Inmueble inmueble=this.buscarInmueble();
        
        Alquiler alquiler= new Alquiler(tipoAumento,porcentajeAumento,duracion,fechaInicio,valorInicial,inmueble);
        
        
        
        System.out.println("Lista de clientes:\n\n");
        this.listarClientes();
        
        System.out.println("Elegir Locador");        
        Locador locador=(Locador)this.buscarCliente();
        alquiler.agregarLocador(locador);
        
        System.out.println("Elegir Locatario");
        Locatario locatario=(Locatario)this.buscarCliente();
        alquiler.agregarLocatario(locatario);
        
        System.out.println("Elegir Garante");
        Garante garante=(Garante)this.buscarCliente();
        alquiler.agregarGarante(garante);
        
        operaciones.alta(alquiler);
        }catch(NullPointerException e){
            throw e;
        }catch(Exception e){
            throw e;
        }
    }
    public Inmueble buscarInmueble(){
        return inmuebles.buscarPorId(pedirId());
    }
   
    
    private int pedirId(){
        System.out.println("id:");
        Scanner sc=new Scanner(System.in);
        int id=sc.nextInt();
        return id;
    }
    
    public Cliente buscarCliente(){
        
       return clientes.buscarPorId(pedirId());
    }
    public Operacion buscarOperacion(){        
        return operaciones.buscarPorId(pedirId());
    }
      public void bajaInmueble(){       
        inmuebles.baja(pedirId());
    }
    public void bajaCliente(){
        clientes.baja(pedirId());
    }
    public void bajaOperacion(){
        operaciones.baja(pedirId());
    }
    public void listarInmuebles() throws Exception{
        try{
        inmuebles.listar();
        }catch(Exception e){
            throw new Exception(e.getMessage().concat(" Inmuebles"));         
        }
    }
    public void listarClientes() throws Exception{
        try{
        clientes.listar();
        }catch(Exception e){
          throw new Exception(e.getMessage().concat(" Clientes"));  
        }
    }
    public void listarOperaciones() throws Exception{
        try{
        operaciones.listar();
        }catch(Exception e){
           throw new Exception(e.getMessage().concat(" Operaciones"));  
        }
    }
    //Busca los inquilinos que tienen la cuota de este mes impaga y los muestra
    public void listarMorosos() throws Exception{
        try{
        for(Operacion o:operaciones.list){
            if(o instanceof Alquiler){
                int cuotaDelMes=((Alquiler) o).ObtenerNumCuota();
                if(!((Alquiler) o).getCuotas().list.get(cuotaDelMes-1).isPagado()){
                    System.out.println(((Alquiler) o).getLocatarios()); 
                }
             }
        }
        }catch (NullPointerException e){
             throw new Exception(e.getMessage().concat(" Operaciones"));  
        }catch(Exception e){
            throw e;
        }
    }
    
    public void PagarAlquiler() throws Exception{
        try{
            this.listarMorosos();
            ((Alquiler)operaciones.buscarPorId(pedirId())).pagarCuota();
        }catch(Exception e){
            throw e;
        }
    }
    
   
}
