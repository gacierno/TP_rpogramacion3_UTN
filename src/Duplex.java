/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 */
public class Duplex extends Inmueble{

    public Duplex() {
    }

    
    public Duplex(Domicilio domicilio, String descripcion, NomenclaturaCatastral nomCatastral) {
        super(domicilio, descripcion, nomCatastral);
    }

    @Override
    public String toString() {
        return super.toString()+"Duplex{" + '}';
    }
    
}
