
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
    
    public void alta(T object) throws Exception{  
        try{      
         buscarPorId(object.getId());
         throw new Exception("Error, ese id ya se encuentra en la lista");
        }catch(NullPointerException e){
            list.add(object);            
        }catch(Exception e){
            throw e;
        }
    }

    public void baja(int id) throws Exception{
        try{
        buscarPorId(id).setActivo(false);
        }catch(Exception e){
            throw new Exception("Error, ese id no esta disponible para dar de baja");
        }
    }
           
    
    public void listar() throws Exception{
        try{
        if(list.isEmpty())            
          throw new NullPointerException("La lista esta vacia");
        
        for(T o:list){
            if(o.isActivo()==true){             
             System.out.println("==========================================================================================================================\n"+
                                o.getId()+"- "+o+
                                "\n==========================================================================================================================");
            }
        }           
        }catch (NullPointerException e){
            throw e;
        } catch (Exception e){
            throw new Exception("Hubo un inconveniente con la lista");
        }
    }
      public void listarInactivas() throws Exception{
        try{
        if(list.isEmpty())            
          throw new NullPointerException("La lista inactiva esta vacia");
        
        for(T o:list){
             if(o.isActivo()==false){             
             System.out.println("==========================================================================================================================\n"+
                                o.getId()+"- "+o+
                                "\n==========================================================================================================================");
            }
        }           
        }catch (NullPointerException e){
            throw e;
        } catch (Exception e){
            throw new Exception("Hubo un inconveniente con la lista");
        }
    }
    
    public void buscarParaActivarId(int id) throws Exception{
        try{
        T result = null;

        for( T l : list ){
            if( l.getId()==id && l.isActivo()==false){
                l.setActivo(true);
                result=l;
            }
        }
        if(result==null){
            throw new NullPointerException("No se encontro ese id para activar");
        }
        }catch (NullPointerException e){            
            throw e;
        }catch(Exception e){
            throw e;
        }
    }

    public T buscarPorId(int id) throws Exception{
        try{
        T result = null;

        for( T l : list ){
            if( l.getId()==id && l.isActivo()==true){
                result=l;
            }
        }
        if(result==null){
            throw new NullPointerException("No se encontro ese id");
        }
        return result;
        }catch (NullPointerException e){            
            throw e;
        }catch(Exception e){
            throw e;
        }
    }

    public void modificar(T Object, int id) throws Exception{
        try{
        if(buscarPorId(id)!=null){
            list.set(id, Object);
        }
        }catch(Exception e){
            throw e;
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
        return "" + list;
    }

}
