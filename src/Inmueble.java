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
    private boolean activo=false;

    public Inmueble(){
         this.setId();
         activo=true;
    }
    
    public Inmueble(Domicilio domicilio, String descripcion, NomenclaturaCatastral nomCatastral) {      
        this.setId();
        this.domicilio = domicilio;
        this.descripcion = descripcion;
        this.nomCatastral = nomCatastral;
        activo=true;
    }
   
      private void setId(){
        lastId ++;
        this.id = lastId;
    }
    public int getId() {
        return id;
    }   

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
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
        String output = String.format(
                "\tID:\t%d," +
                "\tDomicilio:\t%s,",
                getId(), getDomicilio().getCalle()+" "+getDomicilio().getNumero()
        );
        return output;
    }

     public String mostrarTodo() {
        String output = String.format(
                "==========================================================================================================================\n"+
                "\tInmueble: %s,\n" +
                "\tID:\t%d,\n" +
                "\tDomicilio:\t%s,\n" +
                "\tNomenclatura:\t%s,\n"+
                "==========================================================================================================================",
                this.getClass().getName(),getId(), getDomicilio().mostrarTodo(),getNomCatastral()
        );
        return output;
    }

}
