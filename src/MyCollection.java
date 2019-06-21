
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
public class MyCollection <T extends IIdentificables> {
    List<T> list;

    public MyCollection(List<T> list) {
        this.list = list;
    }

    public MyCollection() {
    }

    
    
    
     public void alta(T object){
        if(!list.contains(object)){
            list.add(object);
        }
    }
    public void baja(int id){
        int cont=0;
        for(T o:list){
            if(o.getId()==id){
                list.remove(cont);
            }
            cont++;
        }
    } 
}
