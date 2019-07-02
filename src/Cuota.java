
import java.io.Serializable;
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
public class Cuota implements IIdentificables, Serializable {
    private int id;
    private static int contId = 0;
    private int numero;
    private double valor;
    private boolean pagado;
    private String observaciones;

    public Cuota(int numero, double valor) {
        this.setId();
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

    public void setId(){
        contId ++;
        this.id = contId;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    public void modificarValor(double num){
        this.setValor(num);
    }
    public void Pagar(){
        this.pagado=true;
    }
    ///faltaria modificar observacion

    @Override
    public String toString() {
        return "Cuota{" + "id=" + id + ", numero=" + numero + ", valor=" + valor + ", pagado=" + pagado + ", observaciones=" + observaciones + '}';
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public boolean isActivo() {
       return true;
    }

    @Override
    public void setActivo(boolean bool) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
