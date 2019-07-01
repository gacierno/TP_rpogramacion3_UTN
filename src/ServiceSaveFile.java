import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class ServiceSaveFile<T extends IIdentificables>{

    public ServiceSaveFile( String fileName, MyCollection<T> data ){
        try {
            this.saveData( fileName, data );
        }catch ( Exception e ){
            System.out.println( e );
        }

    }

    // load from a file
    private void saveData( String fileName, MyCollection<T> data )  throws Exception {

        if ( data != null && fileName != null && !fileName.isEmpty() ){

            FileOutputStream fileOutputStream = null;
            ObjectOutputStream objectOutputStream = null;

            try
            {
                //crea un fichero para persistir el objeto
                fileOutputStream = new FileOutputStream( fileName );
                objectOutputStream = new ObjectOutputStream( fileOutputStream );

                //escribe el objeto serializado a un archivo

                for ( int i = 0; i < data.size(); i++){
                    objectOutputStream.writeObject( data.get(i) );
                }
            }
            catch ( NullPointerException e){
                throw new NullPointerException("puntero nulo");
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
