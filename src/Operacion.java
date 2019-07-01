/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asd
 */
public abstract class Operacion implements IIdentificables{
    private Inmueble inmueble;

    public Operacion(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

 

    @Override
    public abstract int getId() ;

    @Override
    public String toString() {
        return "inmueble=" + inmueble ;
    }

    
}
