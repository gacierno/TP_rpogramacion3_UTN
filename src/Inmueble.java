/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author usuario
 */
public abstract class Inmueble implements IIdentificables{
    private int id;
    private static int contId;
    private Domicilio domicilio;
    private String descripcion;
    private NomenclaturaCatastral nomCatastral;

    public Inmueble(){}
    public Inmueble(Domicilio domicilio, String descripcion, NomenclaturaCatastral nomCatastral) {
        this.contId++;
        this.id = id;
        this.domicilio = domicilio;
        this.descripcion = descripcion;
        this.nomCatastral = nomCatastral;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
}
