
import java.io.Serializable;
import java.util.ArrayList;
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
public class MyCollection<T extends IIdentificables> implements Serializable {
    List<T> list;

    public MyCollection(List<T> list) {
        this.list = list;
    }

    public MyCollection() {
        this.list=new ArrayList<T>();
    }
    
    public void alta(T object){
      //  if(buscarPorId(object.getId())==null){
            list.add(object);
      //  }
    }

    public void baja(int id){
        try{
        list.remove(buscarPorId(id));
        }catch(Exception e){
            throw e;
        }
    }
    public void listar() throws Exception{
        try{
            if(list.isEmpty()) throw new NullPointerException("La lista esta vacia");

            String output = "";
            for( T obj : list ){
                output += "==========================================================================================================================\n";
                output += obj + "\n";
            }
            output += "==========================================================================================================================\n";
            String looped = String.format( output );
            System.out.println(looped);
        }catch (NullPointerException e){
            throw e;
        } catch (Exception e){
            throw new Exception("Hubo un inconveniente con la lista");
        }
    }

    public T buscarPorId(int id){
        try{
        T result = null;

        for( T l : list ){
            if( l.getId()==id ){
                result=l;
            }
        }
        return result;
        }catch (Exception e){            
            throw e;
        }
    }

    public void modificar(T Object, int id){
        if(buscarPorId(id)!=null){
            list.set(id, Object);
        }
    }

    public int size(){
        return list.size();
    }

    public T get( int i ){
        return list.get(i);
    }

    @Override
    public String toString() {
        String output = "";
        for( T obj : list ){
            output += "--------------------------------------------------------------------------------------------------------------------------\n";
            output += obj + "\n";
        }
        output += "--------------------------------------------------------------------------------------------------------------------------\n";
        String looped = String.format( output );
        return looped;
    }



}
