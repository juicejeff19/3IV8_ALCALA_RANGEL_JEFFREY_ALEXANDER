/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializacion;
import conexionSQL.ConexionSQL;
import formularios.Sistema;
import java.io.*;
import java.sql.Connection;
import java.util.*;

/**
 *
 * @author juice_pjuorme
 */
public class ArchivoJ implements Serializable{
/*esta clase contendra el metodo para guardar, sin embargo considero que
    un metodo de lectura seria contra-producente en mi programa,
    ya que cuenta con guardado en la nube gracias a MySQL
    */
     ConexionSQL cc = new ConexionSQL();
    Connection con=cc.conexion();

 
    void serializar(ArrayList<DatosSerial> listaseriar){
        try{
            FileOutputStream out = new FileOutputStream("lista.txt");
            ObjectOutputStream objout = new ObjectOutputStream(out);
            objout.writeObject(listaseriar);
            objout.close();
        
        }catch(Exception e){
        
        }
    }
    
}
