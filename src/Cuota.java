
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
public class Cuota {
    private int id;
    private static int contId;
    private int numero;
    private double valor;
    private boolean pagado;
    private List<String> observaciones;

    public Cuota(int numero, double valor) {
        this.id=this.contId++;
        this.numero = numero;
        this.valor = valor;
        this.pagado = false;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public List<String> getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(List<String> observaciones) {
        this.observaciones = observaciones;
    }
    
    public void modificarValor(double num){
        this.setValor(num);
    }
    public void Pagar(){
        this.pagado=true;
    }
    ///faltaria modificar observacion
    
}
