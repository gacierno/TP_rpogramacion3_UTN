public class Locador extends Cliente{

    public Locador(String sexo, String dni,String nombre, String apellido, Domicilio domicilio, String telefono, String email, String observacion) {
        super(sexo, dni,nombre, apellido, domicilio, telefono, email, observacion);
    }

    @Override
    public String toString() {
        return "Locador " + super.toString();
    }
    
}
