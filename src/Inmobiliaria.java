
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
    private List<Inmueble> inmuebles;
    private List<Cliente> clientes;

    public Inmobiliaria(List<Inmueble> inmuebles, List<Cliente> clientes) {
        this.inmuebles = inmuebles;
        this.clientes = clientes;
    }

    public Inmobiliaria() {
        this.inmuebles=(List<Inmueble>) new MyCollection<Inmueble>();
        this.clientes=(List<Cliente>) new MyCollection<Cliente>();
    }

    public List<Inmueble> getInmuebles() {
        return inmuebles;
    }

    public void setInmuebles(List<Inmueble> inmuebles) {
        this.inmuebles = inmuebles;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public String toString() {
        return "Inmobiliaria{" + "inmuebles=" + inmuebles + ", clientes=" + clientes + '}';
    }
    
    
    
    
   
}
