import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class ServiceSaveFile<T>{

    public ServiceSaveFile( String fileName, List<T> data ){
        try {
            this.saveData( fileName, data );
        }catch ( Exception e ){
            System.out.println( e );
        }

    }

    // load from a file
    private void saveData( String fileName, List<T> data )  throws Exception {

        if ( data != null && fileName != null && !fileName.isEmpty() ){

            FileOutputStream fileOutputStream = null;
            ObjectOutputStream objectOutputStream = null;

            try
            {
                //crea un fichero para persistir el objeto
                fileOutputStream = new FileOutputStream(fileName.concat(".file"));
                objectOutputStream = new ObjectOutputStream(fileOutputStream);

                //escribe el objeto serializado a un archivo
                for (T obj : data){
                    objectOutputStream.writeObject(obj);
                }
            }
            catch (IOException e){
                throw new IOException("Error al intentar escribir en el archivo.");
            }
            catch (Exception e){
                throw new Exception("Error, hubo un problema al intentar persistir los datos.");
            }
            finally {
                if (objectOutputStream != null){
                    objectOutputStream.flush();
                    objectOutputStream.close();
                }
            }
        }
        else {
            throw new IOException("Error, no es posible persistir una coleccion de objetos sin Inicializar.");
        }
    }






}
