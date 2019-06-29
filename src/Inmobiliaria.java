
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 */
public class Inmobiliaria{
    private MyCollection<Inmueble> inmuebles;
    private MyCollection<Cliente> clientes;
    private MyCollection<Operacion> operaciones; 
  

    public Inmobiliaria() {       
    }

    public MyCollection<Inmueble> getInmuebles() {
        return inmuebles;
    }

    public void setInmuebles(MyCollection<Inmueble> inmuebles) {
        this.inmuebles = inmuebles;
    }

    public MyCollection<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(MyCollection<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public String toString() {
        return "Inmobiliaria{" + "inmuebles=" + inmuebles + ", clientes=" + clientes + '}';
    }
    
    public void altaInmueble(Inmueble inmueble){
        inmuebles.alta(inmueble);
    }
    public void altaCliente(Cliente cliente){
        clientes.alta(cliente);
    }
    public void altaOperacion(Operacion operacion){
        operaciones.alta(operacion);
    }
    public void buscarInmueble(int id){
        inmuebles.buscarPorId(id);
    }
    public void buscarCliente(int id){
        clientes.buscarPorId(id);
    }
    public void buscarOperacion(int id){
        operaciones.buscarPorId(id);
    }
      public void bajaInmueble(int id){
        inmuebles.baja(id);
    }
    public void bajaCliente(int id){
        clientes.baja(id);
    }
    public void bajaOperacion(int id){
        operaciones.baja(id);
    }
    public void listarInmuebles(){
        inmuebles.listar();
    }
    public void listarClientes(){
        clientes.listar();
    }
    public void listarOperaciones(){
        operaciones.listar();
    }
    //Busca los inquilinos que tienen la cuota de este mes impaga y los muestra
    public void listarMorosos(){
        for(Operacion o:operaciones.list){
            if(o instanceof Alquiler){
                int cuotaDelMes=((Alquiler) o).ObtenerNumCuota();
                if(!((Alquiler) o).getCuotas().list.get(cuotaDelMes-1).isPagado()){
                    System.out.println(((Alquiler) o).getLocatarios()); 
                }
             }
        }
    }
    
   
}
