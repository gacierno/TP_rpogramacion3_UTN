
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
public class MyCollection<T extends IIdentificables>{
    List<T> list;

    public MyCollection(List<T> list) {
        this.list = list;
    }

    public MyCollection() {
        this.list=new ArrayList<T>();
    }
    
     public void alta(T object){
        if(buscarPorId(object.getId())==null){
            list.add(object);
        }
    }
    public void baja(int id){
        try{
        list.remove(buscarPorId(id));
        }catch(Exception e){
            throw e;
        }
    }
    public void listar(){
        for(T o:list){
            System.out.println(o);
        }
    }
    public T buscarPorId(int id){
        T result=null;
        for(T l:list){
            if(l.getId()==id){
                result=l;
            }
        }
        return result;
    }
    public void modificar(T Object, int id){
        if(buscarPorId(id)!=null){
            list.set(id, Object);
        }
    }

}
