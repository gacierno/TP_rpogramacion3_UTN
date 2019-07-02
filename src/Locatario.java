public class Locatario extends Cliente{
    private double sueldo;

    public Locatario(double sueldo, String sexo, String dni,String nombre, String apellido, Domicilio domicilio, String telefono, String email, String observacion) {
        super(sexo, dni,nombre, apellido, domicilio, telefono, email, observacion);
        this.sueldo = sueldo;
    }
public Locatario(){
    
}
    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        String output = String.format(
                "Locatario : {\n" +
                        super.toString() + ",\n" +
                        "\tSueldo :\t%.2f\n" +
                "}",
                getSueldo()
        );
        return output;
    }
    
}
