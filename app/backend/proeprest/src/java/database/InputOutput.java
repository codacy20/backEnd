/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amir
 */
public class InputOutput implements Serializable{


/** JDK 7+. */  
  public InputOutput(){
      
  }

  final static String FILE_NAME = "C:\\Users\\Amir\\Desktop\\new.png";
  final static String OUTPUT_FILE_NAME = "C:\\Users\\Amir\\Desktop\\new2";
  
  public byte[] readSmallBinaryFile(String aFileName) throws IOException {
    Path path = Paths.get(aFileName);
    return Files.readAllBytes(path);
  }
  
  public void writeSmallBinaryFile(byte[] aBytes,String paths) throws IOException {
    Path path = Paths.get(paths);
    Files.write(path, aBytes); //creates, overwrites
  }
  
  private static void log(Object aMsg){
    System.out.println(String.valueOf(aMsg));
  }
  
  public static byte[] serialize(Object obj) throws IOException {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    ObjectOutputStream os = new ObjectOutputStream(out);
    os.writeObject(obj);
    return out.toByteArray();
    }
  public static Object deserialize(byte[] data) throws IOException, ClassNotFoundException {
        ByteArrayInputStream in = new ByteArrayInputStream(data);
        ObjectInputStream is = new ObjectInputStream(in);
        return is.readObject();
    }
  
}
