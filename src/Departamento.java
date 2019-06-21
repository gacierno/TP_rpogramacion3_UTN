/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 */
public class Departamento extends Inmueble{
    private String Cochera;

    public Departamento(String Cochera, Domicilio domicilio, String descripcion, NomenclaturaCatastral nomCatastral) {
        super(domicilio, descripcion, nomCatastral);
        this.Cochera = Cochera;
    }

    

    public String getCochera() {
        return Cochera;
    }

    public void setCochera(String Cochera) {
        this.Cochera = Cochera;
    }

    @Override
    public String toString() {
        return super.toString()+"Departamento{" + "Cochera=" + Cochera + '}';
    }
    
}
