import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceLoadFile<T> {

    private List<T> data;

    /*
    *   CONSTRUCTOR
    * */
    public void ServiceLoadFile( String fileName ){
        this.data = new ArrayList<T>();

        try {
            this.data = this.setData( fileName );
        }catch ( Exception e ){
            System.out.println( e );
        }

    }

    /*
    *   getter
    * */
    public List<T> getData(){
        return this.data;
    }

    /*
    *   setter
    * */
    // load from a file
    private ArrayList<T> setData( String fileName ) throws Exception {

        ArrayList<T> dataOut = new ArrayList<T>();

        if( fileName != null && !fileName.isEmpty() ){
            FileInputStream fis = null;
            try{
                fis = new FileInputStream( fileName );
                ObjectInputStream oi = new ObjectInputStream( fis );

                T item = null;

                do {
                    item = (T)oi.readObject();
                    dataOut.add( item );
                }while( item != null);

                oi.close();

            }catch (EOFException e){
                //Dejo continuar, porque quiere decir que llegue al final del archivo.
            }
            catch (IOException e){
                throw new IOException("Error al intentar leer en el archivo, verifique que el nombre del archivo coincida con el de escritura,.");
            }
            catch (Exception e){
                throw new Exception("Error, hubo un problema al intentar leer/convertir los datos. No se persistieron correctamente o el tipo de dato no secorrecponde, vuelva a intentarlo.");
            }
            finally {
                if (fis != null) fis.close();
            }

        }else {
            throw new IOException("Error, no es posible abrir el archivo con el nombre ingresado.");
        }

        return dataOut;
    }



}
