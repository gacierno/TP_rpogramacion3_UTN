
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
public class Alquiler extends Operacion implements IIdentificables, Serializable {
    private int id;
    private int contId;
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
        this.id=contId++;
        this.tipoAumento = tipoAumento;
        this.porcentajeAumento = porcentajeAumento;
        this.duracion = duracion;
        this.fechaInicio = fechaInicio;/// Se puede crear un LocalDate.now() para que se cree automaticamente, pero a modo de practica se va a utilizar datos ficticios
        this.valorInicial = valorInicial;
        this.cuotas=new MyCollection();
        this.establecerCuotas();
        this.locatarios=new MyCollection();
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
    public void establecerCuotas(){
        int cont;
        double _valorInicial=this.getValorInicial();
        for(cont=1;cont<=this.duracion;cont++){
            cuotas.alta(new Cuota(cont,((cont/this.getTipoAumento())+1)*_valorInicial));
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
                   System.out.println("asd");
               }
               check=true;
           }
       }
       return check;
    }
    ///Hace la diferencia entre la fecha actual y la fecha de inicio para saber la cuota que corresponde este mes. 
    public int ObtenerNumCuota(){
        return 1+(fechaInicio.getMonthValue()-LocalDate.now().getMonthValue())+((LocalDate.now().getYear()-fechaInicio.getYear())*12);
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
        return "Alquiler{" + "id=" + id + ", locadores=" + locadores + ", locatarios=" + locatarios + ", garantes=" + garantes + ", duracion=" + duracion + ", fechaInicio=" + fechaInicio + ", valorInicial=" + valorInicial + '}';
    }

    @Override
    public int getId() {
        return this.id;
    }
    
    
    
}
