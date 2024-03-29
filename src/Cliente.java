import java.io.Serializable;

public class Cliente implements IIdentificables, Serializable {
    static private int lastId = 0;
    private int id;
    private String sexo;
    private String dni;
    private String nombre;
    private String apellido;
    private Domicilio domicilio;
    private String telefono;
    private String email;
    private String observacion;
    private boolean activo;

    
    public Cliente(){
        this.setId();
        this.activo=true;
    }
    public Cliente(String sexo, String dni,String nombre, String apellido, Domicilio domicilio, String telefono, String email, String observacion) {
        this.setId();
        this.setSexo(sexo);
        this.setDni( dni );
        this.setNombre(nombre);
        this.setApellido( apellido );
        this.setDomicilio( domicilio );
        this.setTelefono( telefono );
        this.setEmail( email );
        this.setObservacion( observacion );
        this.activo=true;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        String output = String.format(
                "\tID:\t%d, " +
                "\tNombre:\t%s, " +
                "\tApellido:\t%s, ",               
                getId(), getNombre(), getApellido()
        );
        return output;
    }
    
    public String mostrarTodo() {
        String output = String.format(
                "==========================================================================================================================\n"+
                "Cliente: %s\n" +
                "\tID:\t%d,\n" +
                "\tNombre:\t%s,\n" +
                "\tApellido:\t%s,\n" +
                "\tDomicilio:\t%s,\n" +
                "\tTelefono:\t%s,\n" +
                "\tEmail:\t%s\n"+
                "==========================================================================================================================",
                this.getClass().getName(),getId(), getNombre(), getApellido(), getDomicilio(),getTelefono(),getEmail()
        );
        return output;
    }
    
}
