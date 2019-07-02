/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;

/**
 *
 * @author usuario
 */
public abstract class Inmueble implements IIdentificables, Serializable {

   static private int lastId = 0;
    private int id;
    private Domicilio domicilio;
    private String descripcion;
    private NomenclaturaCatastral nomCatastral;

    public Inmueble(){
         this.setId();
    }
    
    public Inmueble(Domicilio domicilio, String descripcion, NomenclaturaCatastral nomCatastral) {      
        this.setId();
        this.domicilio = domicilio;
        this.descripcion = descripcion;
        this.nomCatastral = nomCatastral;
    }
   
      private void setId(){
        lastId ++;
        this.id = lastId;
    }
    public int getId() {
        return id;
    }   

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public NomenclaturaCatastral getNomCatastral() {
        return nomCatastral;
    }

    public void setNomCatastral(NomenclaturaCatastral nomCatastral) {
        this.nomCatastral = nomCatastral;
    }

    @Override
    public String toString() {
        return  ", domicilio=" + domicilio + ", descripcion=" + descripcion + ", nomCatastral=" + nomCatastral;
    }    
    
    
}
