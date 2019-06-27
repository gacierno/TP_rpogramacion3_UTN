
import java.util.List;

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
    private int id;
    private int contId;
    private List<Locador> locadores;
    private List<Locatario> locatarios;
    private List<Garante> garantes;
    private List<Cuota> cuotas;
    private int tipoAumento;//12-Anual 6-Semestral
    private int porcentajeAumento;
    private int duracion;
    private String fechaInicio;
    private double valorInicial;

    public Alquiler(int tipoAumento, int porcentajeAumento, int duracion, String fechaInicio, double valorInicial, Inmueble inmueble, String fecha) {
        super(inmueble, fecha);
        this.id=contId++;
        this.tipoAumento = tipoAumento;
        this.porcentajeAumento = porcentajeAumento;
        this.duracion = duracion;
        this.fechaInicio = fechaInicio;
        this.valorInicial = valorInicial;
        this.cuotas=establecerCuotas();
    }

  


    public List<Locador> getLocadores() {
        return locadores;
    }

    public void setLocadores(List<Locador> locadores) {
        this.locadores = locadores;
    }

    public List<Locatario> getLocatarios() {
        return locatarios;
    }

    public void setLocatarios(List<Locatario> locatarios) {
        this.locatarios = locatarios;
    }

    public List<Garante> getGarantes() {
        return garantes;
    }

    public void setGarantes(List<Garante> garantes) {
        this.garantes = garantes;
    }

    public List<Cuota> getCuotas() {
        return cuotas;
    }

    public void setCuotas(List<Cuota> cuotas) {
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

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public List<Cuota> establecerCuotas(){
        int cont;
        double valorInicial=this.getValorInicial();
        for(cont=0;cont<=this.duracion;cont++){
            this.cuotas.add(new Cuota(cont,(int)(cont/this.getTipoAumento())*valorInicial));
        }
        return this.cuotas;
    } 
    
    
}
