import java.io.Serializable;

public class Domicilio implements Serializable {
    /*
    *   -Calle
        -Numero
        -CodigoPostal
        -Ciudad
        -Provincia
        -Pais
    * */

    private String calle;
    private int numero;
    private String piso;
    private String departamento;
    private int codigoPostal;
    private String ciudad;
    private String provincia;
    private String pais;

    /*
    *
    *   CONSTRUCTORS
    *
    * */

    //  CREAR UNA DIRECCION VACIA PARA CREAR RAPIDAMENTE CONTRATOS SIN TENER QUE CARGAR DATOS
    public Domicilio() {
        this.setCalle("");
        this.setNumero(0);
        this.setPais("");
        this.setDepartamento("");
        this.setCodigoPostal(0);
        this.setCiudad("");
        this.setProvincia("");
        this.setProvincia("");
    }

    public Domicilio(String calle, int numero,String departamento, int codigoPostal, String ciudad, String provincia, String pais) {
        this.setCalle(calle);
        this.setNumero(numero);
        this.setDepartamento(departamento);
        this.setCodigoPostal(codigoPostal);
        this.setCiudad(ciudad);
        this.setProvincia(provincia);
        this.setProvincia(pais);
    }


    /*
     *
     *   SETTERS
     *
     * */

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    /*
     *
     *   GETTERS
     *
     * */

    public String getCalle() {
        return calle;
    }

    public int getNumero() {
        return numero;
    }

    public String getPiso() {
        return piso;
    }

    public String getDepartamento() {
        return departamento;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getPais() {
        return pais;
    }

    /*
     *
     *   TOSTRING
     *
     * */

    @Override
    public String toString() {
        String output = String.format(
                "{\tCalle :\t%s,\tNumero :\t%d,\tPiso :\t%s\t}",
                this.getCalle(), this.getNumero(), getPiso()
        );
        return output;
    }
}