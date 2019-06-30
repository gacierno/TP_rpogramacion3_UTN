
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
                 inmueble= new Departamento(cochera,domicilio, descripcion, nomCatastral);
                break;              
            default:
              // code block
          }
        if(inmueble!=null)
        inmuebles.alta(inmueble);
    }
    public Domicilio AgregarDomicilio(){
        Scanner sc= new Scanner(System.in);
        
        System.out.println("Calle: ");
        String calle=sc.nextLine();
        System.out.println("Numero:");
        int numero=sc.nextInt();
        System.out.println("Departamento:");
        String departamento= sc.nextLine();
        System.out.println("Codigo postal:");
        int codPostal=sc.nextInt();
        System.out.println("Ciudad");
        String ciudad=sc.nextLine();
        System.out.println("Provincia:");
        String provincia=sc.nextLine();
        System.out.println("Pais:");
        String pais=sc.nextLine();
        
        return new Domicilio(calle,numero,departamento,codPostal,ciudad,provincia,pais);
    }
    public NomenclaturaCatastral AgregarNomenclaturaCatastral(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Circunscripcion:");
        int circunscripcion=sc.nextInt();
        System.out.println("Seccion:");
        char seccion=sc.nextLine().charAt(0);
        System.out.println("Manzana");
        String manzana=sc.nextLine();
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
        System.out.println("DNI:");
        String dni=sc.nextLine();
        System.out.println("Apellido");
        String apellido=sc.nextLine();        
        Domicilio domicilio= this.AgregarDomicilio();
        System.out.println("Telefono:");
        String telefono=sc.nextLine();
        System.out.println("Email:");
        String email=sc.nextLine();
        System.out.println("Observacion");
        String observacion=sc.nextLine();        
        
        
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
    
    public void altaOperacion(Operacion operacion){
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
        int id=sc.nextInt();
        Inmueble inmueble=inmuebles.buscarPorId(id);
        
        operaciones.alta(new Alquiler(tipoAumento,porcentajeAumento,duracion,fechaInicio,valorInicial,inmueble));
    }
    public void buscarInmueble(int id){
        inmuebles.buscarPorId(id);
    }
    public void buscarCliente(int id){
        clientes.buscarPorId(id);
    }
    public void buscarOperacion(int id){
        operaciones.buscarPorId(id);
    }
      public void bajaInmueble(int id){
        inmuebles.baja(id);
    }
    public void bajaCliente(int id){
        clientes.baja(id);
    }
    public void bajaOperacion(int id){
        operaciones.baja(id);
    }
    public void listarInmuebles(){
        inmuebles.listar();
    }
    public void listarClientes(){
        clientes.listar();
    }
    public void listarOperaciones(){
        operaciones.listar();
    }
    //Busca los inquilinos que tienen la cuota de este mes impaga y los muestra
    public void listarMorosos(){
        for(Operacion o:operaciones.list){
            if(o instanceof Alquiler){
                int cuotaDelMes=((Alquiler) o).ObtenerNumCuota();
                if(!((Alquiler) o).getCuotas().list.get(cuotaDelMes-1).isPagado()){
                    System.out.println(((Alquiler) o).getLocatarios()); 
                }
             }
        }
    }
    
   
}
