public class Locatario extends Cliente{
    private double sueldo;

    public Locatario(double sueldo, String sexo, String dni, String apellido, Domicilio domicilio, String localidad, String telefono, String email, String observacion) {
        super(sexo, dni, apellido, domicilio, telefono, email, observacion);
        this.sueldo = sueldo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    
}
