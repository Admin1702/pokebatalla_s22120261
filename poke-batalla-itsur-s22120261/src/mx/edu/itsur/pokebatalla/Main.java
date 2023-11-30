/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mx.edu.itsur.pokebatalla;

import java.io.IOException;
import java.io.Serializable;
import mx.edu.itsur.pokebatalla.fileManager.Manager;
import mx.edu.itsur.pokebatalla.model.battles.Batalla;
import mx.edu.itsur.pokebatalla.model.battles.Entrenador;
import mx.edu.itsur.pokebatalla.model.pokemons.Arcanine;
import mx.edu.itsur.pokebatalla.model.pokemons.Bullbasaur;
import mx.edu.itsur.pokebatalla.model.pokemons.Pikachu;
import mx.edu.itsur.pokebatalla.model.pokemons.Charmander;
import mx.edu.itsur.pokebatalla.model.pokemons.Mewtwo;
import mx.edu.itsur.pokebatalla.model.pokemons.Vulpix;

/**
 *
 * @author Juan Pablo Torres Zavala
 */
public class Main implements Serializable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Batalla a = Manager.part2();

        if (a == null) {
            Mewtwo mew = new Mewtwo("Armando");
            Arcanine arcan = new Arcanine("Raul");
            Vulpix vulp = new Vulpix("Roberto");

            Entrenador n1 = new Entrenador("Lalo");
            n1.capturarPokemon(mew);
            n1.capturarPokemon(vulp);

            Entrenador n2 = new Entrenador("Alan");
            n2.capturarPokemon(arcan);
            n2.capturarPokemon(vulp);

            a = new Batalla(n1, n2);
        }
        a.desarrollarBatalla();

        if (a.ganador()) {
            System.out.println("Quieres iniciar una nueva partida?");

            char respuesta = 'N';
            try {
                respuesta = (char) System.in.read();
                System.in.read((new byte[System.in.available()]));
            } catch (IOException ex) {
                System.out.println("Los siento, hubo un error  "
                        + "porfavor intenta de nuevo.");
                ex.printStackTrace();
            }

            if (respuesta == 'S' || respuesta == 's') {
                // Borra el archivo de la partida guardada
                Manager.part3();
                //Pokemons 
                Pikachu pika = new Pikachu();
                Charmander charm = new Charmander();
                Bullbasaur bullb = new Bullbasaur();
                Mewtwo mew = new Mewtwo();
                Arcanine arcan = new Arcanine();
                Vulpix vulp = new Vulpix();

                Entrenador entre1 = new Entrenador("Juanito");
                entre1.capturarPokemon(mew);
                entre1.capturarPokemon(arcan);

                Entrenador entre2 = new Entrenador("Pepito");
                entre2.capturarPokemon(vulp);
                entre2.capturarPokemon(arcan);

                Batalla battle = new Batalla(entre1, entre2);
                battle.desarrollarBatalla();
            }
        }
    }
}

//BATALLA
//System.out.println("->Pikachu se encuentra con un Charmander y ataca:");     
//pika.atacar(charm, Pikachu.Movimientos.IMPACTRUENO);
//System.out.println("------------------------------------------------");
//ystem.out.println("->Charmander se molesta y responde. ");
//vcharm.atacar(pika, Charmander.Movimientos.ATAQUE_RAPIDO);
//   System.out.println("------------------------------------------------");
//System.out.println("->Bullbasaur se enoja porque atacaron a su amigo Pikachu y contrataca a Charmander:");
//bullb.atacar(charm, Bullbasaur.Movimientos.LATIGO);
//      System.out.println("------------------------------------------------");
//System.out.println("->Vulpix que se encuentra cerca del lugar donde esta ocurriendo la pokebatalla decide ir...");
//System.out.println("->Vulpix mira que Charmander esta peleando contra dos pokemones el solo, asi que decide unirse con el...");
//System.out.println("->Por lo tanto, Vulpix comienza a atacar a Pikachu:");
//vulp.atacar(pika, Vulpix.Movimientos.ONDA_IGNEA);
//System.out.println("------------------------------------------------");
//System.out.println("->Arcanine que tambien estaba cerca, decide ir...");
//System.out.println("->Y comienza a correr hacia donde esta sucediendo la pokebatalla.");
//System.out.println("->Arcanine como es tipo fuego, decide ayudar a Charmander y a Vulpix porque son de su mismo tipo...");
//System.out.println("->Asi que Arcanine ataca a Bullbasaur ya que mira que este es el que mas vida tiene:");
//arcan.atacar(bullb, Arcanine.Movimientos.TRITURAR);
//System.out.println("------------------------------------------------");
//System.out.println("->Mewtwo que estapostrado en lo alto de ua torre siente a lo lejos que esta sucediendo una pokebatalla, asi que se eleva y comienza a volar hacia el lugar...");
//System.out.println("->Cuando Mewtwo llega, mira a los 5 pokemones peleando.");
//System.out.println("->Mewtwo muy enojado por que no le gusta que los pokemones peleen, decide lanzar un ataque desde el cielo contra los pokemones que estan luchando:");
//mew.atacar(arcan, Mewtwo.Movimientos.BOLA_VOLTIO);
//System.out.println("------------------------------------------------");
//mew.atacar(pika, Mewtwo.Movimientos.BOLA_VOLTIO);
//System.out.println("------------------------------------------------");
//mew.atacar(charm, Mewtwo.Movimientos.BOLA_VOLTIO);
//System.out.println("------------------------------------------------");
//mew.atacar(bullb, Mewtwo.Movimientos.BOLA_VOLTIO);
//System.out.println("------------------------------------------------");
//mew.atacar(vulp, Mewtwo.Movimientos.BOLA_VOLTIO);
//System.out.println("------------------------------------------------");
//System.out.println("->Los pokemones caen al suelo por la fuerza del ataque que recibieron...");
//System.out.println("->Y ya muy debilitados y daniados se levantan y miran a Mewtwo flotando sobre ellos...");
//System.out.println("->Asi que deciden mejor retirarse de la batalla para recuperar sus energias.");//

