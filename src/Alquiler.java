import java.time.LocalDate;
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
public class Alquiler extends Operacion{   
    private MyCollection<Locador> locadores;
    private MyCollection<Locatario> locatarios;
    private MyCollection<Garante> garantes;
    private MyCollection<Cuota> cuotas;
    private int tipoAumento;//12-Anual 6-Semestral
    private int porcentajeAumento;
    private int duracion;
    private LocalDate fechaInicio;
    private double valorInicial;
    
  
    public Alquiler(int tipoAumento, int porcentajeAumento, int duracion, LocalDate fechaInicio, double valorInicial, Inmueble inmueble) {
        super(inmueble);       
        this.tipoAumento = tipoAumento;
        this.porcentajeAumento = porcentajeAumento;
        this.duracion = duracion;
        this.fechaInicio = fechaInicio;/// Se puede crear un LocalDate.now() para que se cree automaticamente, pero a modo de practica se va a utilizar datos ficticios
        this.valorInicial = valorInicial;
        this.cuotas=new MyCollection();
        this.establecerCuotas();
        this.locatarios=new MyCollection();
        this.locadores=new MyCollection();
        this.garantes=new MyCollection();        
    }

  


    public MyCollection<Locador> getLocadores() {
        return locadores;
    }

    public void setLocadores(MyCollection<Locador> locadores) {
        this.locadores = locadores;
    }

    public MyCollection<Locatario> getLocatarios() {
        return locatarios;
    }

    public void setLocatarios(MyCollection<Locatario> locatarios) {
        this.locatarios = locatarios;
    }

    public MyCollection<Garante> getGarantes() {
        return garantes;
    }

    public void setGarantes(MyCollection<Garante> garantes) {
        this.garantes = garantes;
    }

    public MyCollection<Cuota> getCuotas() {
        return cuotas;
    }

    public void setCuotas(MyCollection<Cuota> cuotas) {
        this.cuotas = cuotas;
    }

    public int getTipoAumento() {
        return tipoAumento;
    }

    public void setTipoAumento(int tipoAumento) {
        this.tipoAumento = tipoAumento;
    }

    public int getPorcentajeAumento() {
        return porcentajeAumento;
    }

    public void setPorcentajeAumento(int porcentajeAumento) {
        this.porcentajeAumento = porcentajeAumento;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(double valorInicial) {
        this.valorInicial = valorInicial;
    }

    //Crea las cuotas y establece el valor segun el aumento estipulado
    private void establecerCuotas(){
        int cont;
        double _valorInicial=this.getValorInicial();
        for(cont=1;cont<=this.duracion;cont++){
            cuotas.alta(new Cuota(cont,((cont/(this.getTipoAumento()+1))+1)*_valorInicial));
        }
    }
    
    public void agregarLocador(Locador locador){
        locadores.alta(locador);
    }
    public void agregarLocatario(Locatario locatario){
        locatarios.alta(locatario);
    }
     public void agregarGarante(Garante garante){
        garantes.alta(garante);
    }
     public void quitarLocador(int id){
        locadores.baja(id);
    }
    public void quitarLocatario(int id){
        locatarios.baja(id);
    }
     public void quitarGarante(int id){
        garantes.baja(id);
    }
    public void listarCuotas() throws Exception{
        try{
            cuotas.listar();
        }catch (Exception e){
            throw e;
        }
    }
    ///obtiene la cuota que corresponde este mes.
    ///en caso de quere pagar una cuota que no es la actual, hay que modificar el atributo pagado desde el metodo modificarCuota.
    public boolean pagarCuota(){
      int numeroCuota=ObtenerNumCuota();
       boolean check=false;
       for(Cuota c:cuotas.list){
           if(c.getNumero()==numeroCuota){
               if(!c.isPagado()){
                   c.Pagar();
               }
               else{
                   System.out.println("El mes ya estaba pagado");
               }
               check=true;
           }
       }
       return check;
    }
    public boolean pagarCuotaByNum(int num){
      boolean check=false;
       for(Cuota c:cuotas.list){
           if(c.getNumero()==num){
               if(!c.isPagado()){
                   c.Pagar();
               }
               else{
                   System.out.println("El mes ya estaba pagado");
               }
            check=true;
           }
       }
       return check;
    }
    ///Hace la diferencia entre la fecha actual y la fecha de inicio para saber la cuota que corresponde este mes. 
    public int ObtenerNumCuota(){
        return 1+(LocalDate.now().getMonthValue()-fechaInicio.getMonthValue())+((fechaInicio.getYear()-LocalDate.now().getYear())*12);
    }
    ///Si vamos a usar interfaz grafica quiza esto se podria armar de otro modo, lo djeo pendiente...
    
    /*public void ModificarCuota(int id){
        Scanner sc=new Scanner(System.in);
        Cuota cuota=cuotas.buscarPorId(id);
        if(cuota!=null){            
            System.out.println("Que desdea modificar de la cuota?/n1-Valor\n2-");
        }
    }*/

    @Override
    public String toString() {
        String output = String.format(
                "==========================================================================================================================\n"+
                "Aluiler : {\n" +
                        super.toString() + "\n" +
                        "%s,\n" +
                        "%s,\n" +
                        "%s,\n" +
                        "Duracion :\t%s,\n" +
                        "Fecha de inicio :\t%s,\n" +
                        "Valor Inicial :\t%f\n" +
                "}\n"+
                "==========================================================================================================================",
                getLocadores().toString(), getLocatarios().toString(), getGarantes().toString(), getDuracion(), getFechaInicio(),getValorInicial()
        );
        return output;
    }

  
    public void ModificarCuota() throws Exception{
        try{
            System.out.println("Selecciona la cuota que desee modificar: ");
            getCuotas().listar();
            Scanner sc=new Scanner(System.in);
            Cuota cuota=getCuotas().buscarPorId(sc.nextInt());
            System.out.println("Seguro desdea modificar esta cuota?(si/no)\n"+cuota);
            sc.nextLine();
            if(sc.nextLine().equals("si")){                             
                System.out.println("Agregar observaciones: ");               
                cuota.setObservaciones(sc.nextLine());             
                System.out.println("Valor de la cuota:");
                cuota.setValor(sc.nextDouble());
                System.out.println("La cuenta se encuentra paga? (si/no)");
                sc.nextLine();
                String pagado=sc.nextLine();
                if(pagado.equals("si")){
                cuota.setPagado(true);
                }else{
                    cuota.setPagado(false);
                }
            }
        }catch(Exception e){
            throw e;
        }
    }

   
    
    
    
}
