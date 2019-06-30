public class Cliente implements IIdentificables {
    static private int lastId = 0;
    private int id;
    private String sexo;
    private String dni;
    private String apellido;
    private Domicilio domicilio;
    private String telefono;
    private String email;
    private String observacion;

    public Cliente(String sexo, String dni, String apellido, Domicilio domicilio, String telefono, String email, String observacion) {
        this.setSexo(sexo);
        this.setDni( dni );
        this.setApellido( apellido );
        this.setDomicilio( domicilio );
        this.setTelefono( telefono );
        this.setEmail( email );
        this.setObservacion( observacion );
    }

    //  setters
    private void setId(){
        lastId ++;
        this.id = lastId;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

   

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    //getters

    public int getId(){ return this.id; }

    @Override
    public String toString() {
        return "Cliente{" + "sexo=" + sexo + ", dni=" + dni + ", apellido=" + apellido + ", domicilio=" + domicilio + ", telefono=" + telefono + ", email=" + email + ", observacion=" + observacion + '}';
    }
    
    
}
