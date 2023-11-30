package mx.edu.itsur.pokebatalla.fileManager;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import mx.edu.itsur.pokebatalla.model.battles.Batalla;

/**
 *
 * @author Juan Pablo Torres Zavala
 */
public class Manager {
  public static final String NOMBRE_PARTIDA = "Combat";

    public static void part1(Batalla poke) {
        try (ObjectOutputStream escritorDeObjetos = new ObjectOutputStream(new FileOutputStream( NOMBRE_PARTIDA))) 
        {
            escritorDeObjetos.writeObject(poke);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Batalla part2() {
        Batalla poke = null;
        try (ObjectInputStream lectorDeObjetos = new ObjectInputStream(new FileInputStream(NOMBRE_PARTIDA))) 
        {
            poke = (Batalla) lectorDeObjetos.readObject();
        } catch (EOFException e) {
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return poke;
    }

    public static void part3() {
    File file = new File(NOMBRE_PARTIDA);
    if (file.exists()) {
        file.delete();
        System.out.println("La partida fue eliminada");
    }
}  
}
