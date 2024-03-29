/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;

/**
 *
 * @author asd
 */
public abstract class Operacion implements IIdentificables, Serializable {
    static private int lastId = 0;
    private int id;
    private Inmueble inmueble;
    private boolean activo;

    public Operacion(){
        this.setId();
        this.activo=true;
    }
    public Operacion(Inmueble inmueble) {
        this.setId();
        this.inmueble = inmueble;
        this.activo=true;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    
    
    private void setId(){
        lastId ++;
        this.id = lastId;
    }
    
    
    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

 
    @Override
       public int getId() {
           return this.id;
       }

    @Override
    public String toString() {
        return "inmueble=" + inmueble ;
    }

    
}
