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
public class NomenclaturaCatastral implements Serializable {
    private int circunscripcion;
    private char seccion;
    private String manzana;
    private int parcela;

    public NomenclaturaCatastral(){}
    
    public NomenclaturaCatastral(int circunscripcion, char seccion, String manzana, int parcela) {
        this.circunscripcion = circunscripcion;
        this.seccion = seccion;
        this.manzana = manzana;
        this.parcela = parcela;
    }

    public int getCircunscripcion() {
        return circunscripcion;
    }

    public void setCircunscripcion(int circunscripcion) {
        this.circunscripcion = circunscripcion;
    }

    public char getSeccion() {
        return seccion;
    }

    public void setSeccion(char seccion) {
        this.seccion = seccion;
    }

    public String getManzana() {
        return manzana;
    }

    public void setManzana(String manzana) {
        this.manzana = manzana;
    }

    public int getParcela() {
        return parcela;
    }

    public void setParcela(int parcela) {
        this.parcela = parcela;
    }

    @Override
    public String toString() {
        String output = String.format(
            "Circunscripcion= %s, Seccion= %s, Manzana= %s, Parcela= %s",
            getCircunscripcion(), getSeccion(), getManzana(), getParcela()
        );
        return output;

    }
   
}
