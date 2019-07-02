
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

        this.inmuebles = new MyCollection<>();
        this.clientes = new MyCollection<>();
        this.operaciones = new MyCollection<>();

        try {

            ServiceLoadFile<Inmueble> _inmuebles = new ServiceLoadFile<>( "inmuebles.dat" );
            this.inmuebles = _inmuebles.getData();

            ServiceLoadFile<Cliente> _clientes = new ServiceLoadFile<>( "clientes.dat" );
            this.clientes = _clientes.getData();

            ServiceLoadFile<Operacion> _operaciones = new ServiceLoadFile<>( "operaciones.dat" );
            this.operaciones= _operaciones.getData();

        }catch ( Exception e ){
            throw e;
        }


    }

    /*
    *   GETTERS
    * */
    public MyCollection<Inmueble> getInmuebles() {
        return this.inmuebles;
    }
    public MyCollection<Cliente> getClientes() {
        return clientes;
    }
    public MyCollection<Operacion> getOperaciones() {
        return this.operaciones;
    }

    /*
    *   SETTERS
    * */
    public void setInmuebles(MyCollection<Inmueble> inmuebles) {
        this.inmuebles = inmuebles;
    }
    public void setClientes(MyCollection<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public String toString() {
        return "Inmobiliaria{" + "inmuebles=" + inmuebles + ", clientes=" + clientes + '}';
    }
    private Inmueble cargarDatosInmueble(Inmueble inmueble){      
        Scanner sc=new Scanner(System.in);
        inmueble.setDomicilio(this.AgregarDomicilio());
        System.out.println("Descripcion:");       
        inmueble.setDescripcion(sc.nextLine());
        inmueble.setNomCatastral(this.AgregarNomenclaturaCatastral());
        if(inmueble instanceof Departamento){
             System.out.println("Cochera:");
             ((Departamento)inmueble).setCochera(sc.nextLine());
        }
        return inmueble;
    }
    
    public void altaInmueble(){
         System.out.println("1-Duplex 2-PH 3-Casa 4-Lote 5-Departamento");
         Scanner sc=new Scanner(System.in);
         int tipo=sc.nextInt();
         if(tipo>0&&tipo<4){    
        Inmueble inmueble = null;
        switch(tipo) {
            case 1:
              inmueble=new Duplex();
              break;
            case 2:
              inmueble=new PH();
              break;
            case 3:
              inmueble=new Casa();
              break;
            case 4:
              inmueble= new Lote();
              break;
            case 5:               
                 inmueble= new Departamento();
                break;              
            default:
              // code block
          }
        if(inmueble!=null){
        inmuebles.alta(this.cargarDatosInmueble(inmueble));
        }
         }
         else{
              System.out.println("Error, opcion no existente");
         }
    }
    
    public void modificarInmueble(int id){
        try{
        Scanner sc=new Scanner(System.in);
        Inmueble inmueble=this.inmuebles.buscarPorId(id);
            System.out.println("Seguro desdea modificar este inmueble?(si/no)\n"+inmueble);
            if(sc.nextLine().equals("si")){            
                this.cargarDatosInmueble(inmueble);
                this.inmuebles.modificar(inmueble, id);
            }
        }catch(Exception e){
            throw e;
        }
    }

    
    private Domicilio AgregarDomicilio(){
        Scanner sc= new Scanner(System.in);
        
        System.out.println("Calle: ");
        String calle=sc.nextLine();
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
        System.out.println("Pais:");
        String pais=sc.nextLine();
        
        return new Domicilio(calle,numero,departamento,codPostal,ciudad,provincia,pais);
    }

    private NomenclaturaCatastral AgregarNomenclaturaCatastral(){        
        Scanner sc= new Scanner(System.in);
        System.out.println("Circunscripcion:");
        int circunscripcion=sc.nextInt();        
        sc.nextLine();
        System.out.println("Seccion:");
        char seccion=sc.nextLine().charAt(0);
        System.out.println("Manzana");
        String manzana=sc.nextLine();
        System.out.println("Parcela");
        int parcela=sc.nextInt();
       
        return new NomenclaturaCatastral(circunscripcion,seccion,manzana,parcela);        
    }

    private Cliente cargarDatosCliente(Cliente cliente){
        Scanner sc=new Scanner(System.in);
        System.out.println("Sexo:");
        cliente.setSexo(sc.nextLine());
        System.out.println("DNI:");
        cliente.setDni(sc.nextLine());
        System.out.println("Nombre:");
        cliente.setNombre(sc.nextLine());
        System.out.println("Apellido:");
        cliente.setApellido(sc.nextLine());
        cliente.setDomicilio(this.AgregarDomicilio());
        System.out.println("Telefono:");
        cliente.setTelefono(sc.nextLine());
        System.out.println("Email:");
        cliente.setEmail(sc.nextLine());
        System.out.println("Observacion:");
        cliente.setObservacion(sc.nextLine());
        
        if(cliente instanceof Locatario){     
            System.out.println("Sueldo:");
            ((Locatario)cliente).setSueldo(sc.nextDouble());
        }
        if(cliente instanceof Garante){
            System.out.println("Sueldo:");
            ((Garante)cliente).setSueldo(sc.nextDouble());
        }
        return cliente;
    }
    
    public void altaCliente(){
         Scanner sc =new Scanner(System.in);
        System.out.println("Tipo De Cliente: 1-Locador 2-Locatario 3-Garante");        
        int tipo=sc.nextInt();
        if(tipo>0&&tipo<6){     
        Cliente cliente = null;
        switch(tipo) {
            case 1:
              cliente=new Locador();
              break;
            case 2:               
              cliente=new Locatario();
              break;
            case 3:              
              cliente=new Garante();
              break;                    
            default:
              break;
          }
        if(cliente!=null){   
        cliente=this.cargarDatosCliente(cliente);
        clientes.alta(cliente);        
        }
        }
        else{            
          System.out.println("Error, opcion no existente");
        }
    }
    
     public void modificarCliente(int id){
        try{
        Scanner sc=new Scanner(System.in);
        Cliente cliente=this.clientes.buscarPorId(id);
            System.out.println("Seguro desea modificar este cliente?(si/no)\n"+cliente);
        if(sc.nextLine().equals("si")){
            this.cargarDatosCliente(cliente);
            this.clientes.modificar(cliente, id);
        }
        }catch(Exception e){
            throw e;
        }
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
        try{
        return inmuebles.buscarPorId(pedirId());
        }catch(Exception e){
            throw e;
        }
    }
   
     public void modificarCuotaDeAlquiler() throws Exception{
        try{
         this.listarOperaciones();
        Alquiler alquiler= (Alquiler)this.buscarOperacion();
        alquiler.ModificarCuota();
        
        }catch(Exception e){
            throw e;
        }
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
                if(cuotaDelMes>=0&&cuotaDelMes<=((Alquiler) o).getDuracion()){
                if(!((Alquiler) o).getCuotas().list.get(cuotaDelMes-1).isPagado()){
                    System.out.println(o.getId()+"- "+((Alquiler) o).getLocatarios()); 
                }
                }
             }
        }
        }catch (NullPointerException e){
             throw new Exception(e.getMessage().concat(" Operaciones"));  
        }catch(Exception e){
            throw e;
        }
    }
    
    public void PagarAlquilerDelMes() throws Exception{
        try{
            this.listarMorosos();
            if(!((Alquiler)operaciones.buscarPorId(pedirId())).pagarCuota()){
                System.out.println("Error, no corresponde pagar la cuota de este mes. Revise la lista de morosos o elija la opcion pagar alquiler para pagar otras cuotas");
            }
        }catch(Exception e){
            throw e;
        }
    }
     public void PagarAlquilerById(int id, int num) throws Exception{
        try{
            if(!((Alquiler)operaciones.buscarPorId(id)).pagarCuotaByNum(num)){
                System.out.println("Error, No se encontro ese numero de cuota en ese alquiler");
            }
        }catch(Exception e){
            throw e;
        }
    }
   
}
