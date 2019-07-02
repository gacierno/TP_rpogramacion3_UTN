/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author usuario
 */
public class Casa extends Inmueble{
    public Casa(){
        
    }
    public Casa(Domicilio domicilio, String descripcion, NomenclaturaCatastral nomCatastral) {
        super(domicilio, descripcion, nomCatastral);
    }

    @Override
    public String toString() {
        String output = String.format(
                "Casa : {\n" +
                    super.toString() +
                "}"
        );
        return output;
    }

        
}
