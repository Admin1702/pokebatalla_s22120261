/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itsur.pokebatalla.model.battles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import mx.edu.itsur.pokebatalla.fileManager.Manager;
import mx.edu.itsur.pokebatalla.model.battles.Entrenador;
import mx.edu.itsur.pokebatalla.model.pokemons.Pokemon;

/**
 *
 * @author Juan Pablo Torres Zavala
 */
public class Batalla implements Serializable{
    //Atributos
   protected Entrenador entrenador1;
    protected Entrenador entrenador2;
    protected int turno = 1;
    protected boolean batallaFinalizada = false;

    private boolean primerAtaqueRealizado = false;

    public Batalla(Entrenador entrenador1, Entrenador entrenador2) {
        this.entrenador1 = entrenador1;
        this.entrenador2 = entrenador2;
    }
    public boolean ganador() {
        return (entrenador1.estaDerrotado() || entrenador2.estaDerrotado());
    }

    public void guardarProgreso() {
        Manager.part1(this);
    }
    public void desarrollarBatalla() {
        System.out.println(" Bienvenidos a la Pokeatalla ");
        System.out.println("---------------------------- ");
        System.out.println("La Batalla sera entre...");
        System.out.println(entrenador1.getNombre() + "    contra  " + entrenador2.getNombre());

        System.out.println("");
do{
    try{
        seleccionarPokemon(entrenador1);
    }catch(IndexOutOfBoundsException e) {
         System.out.println("Verifica bien, solo puedes elegir entre:  " + entrenador1.getPokemonsCapturados().size());
                entrenador1.setPokemonActual(null);
    }
        } while (entrenador1.getPokemonActual() == null);

        do {
            try {
                seleccionarPokemon(entrenador2);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Verifica bien, solo puedes elegir entre:  " + entrenador2.getPokemonsCapturados().size());
                entrenador2.setPokemonActual(null);
            }
        } while (entrenador2.getPokemonActual() == null);

        while (!batallaFinalizada) {
            Entrenador entrenadorAtacante = (turno == 1) ? entrenador1 : entrenador2;
            Entrenador oponente = (turno == 1) ? entrenador2 : entrenador1;

            System.out.println("El turno sera de: " + entrenadorAtacante.getNombre());

           
            if (entrenadorAtacante.getPokemonActual() == null || entrenadorAtacante.getPokemonActual().getHp() <= 0) {
                cambiarPokemon(entrenadorAtacante);
            }
           
            if (oponente.getPokemonActual() == null) {
                System.out.println("El oponente no ha a seleccionado un pokemon");
                return;
            }

  
            seleccionarAtaque(entrenadorAtacante, oponente.getPokemonActual());

            Pokemon pokemonEnTurno = entrenadorAtacante.getPokemonActual();

            if (oponente.estaDerrotado()) {
                System.out.println("El oponente " + oponente.getNombre() + " fue derrotado");
                batallaFinalizada = true;
            } else {
              guardarProgreso(); 
                turno = (turno == 1) ? 2 : 1;
            }
        }
    }

    private void seleccionarPokemon(Entrenador Atac) {
System.out.println("Elige un pokemon " + Atac.getNombre());
      int idx = 1;
     
        for (Pokemon pokemon : Atac.getPokemonsCapturados()) {
            if (pokemon.getHp()<=0){
            System.out.println(idx + ".- " + pokemon.getClass().getSimpleName() + " hp: " + "0" + "  defensa: " + pokemon.getDefensa() + "  nivel: " + pokemon.getNivel());
            }
            else{
            System.out.println(idx + ".- " + pokemon.getClass().getSimpleName() + " hp: " + pokemon.getHp() + "  defensa: " + pokemon.getDefensa() + "  nivel: " + pokemon.getNivel());
            }
            idx++;
       }
        char auxLectura='0';
        try{
            auxLectura = (char) System.in.read();
            System.in.read ((new byte[System.in.available()]));
        }catch (Exception ex){
            ex.printStackTrace();
        }
        Pokemon seleccionarPokemon = Atac.getPokemonsCapturados()
                .get(Character.getNumericValue(auxLectura)-1);
        Atac.setPokemonActual(seleccionarPokemon);
    }

   
    private void seleccionarAtaque(Entrenador entrenadorAtacante, Pokemon oponente) {

        Pokemon pokemonActual =entrenadorAtacante.getPokemonActual();

        System.out.println("");
        System.out.println("Seleccione un ataque para " + pokemonActual.getClass().getSimpleName() + ":");

        int idx = 1;

        for (Enum movimiento : pokemonActual.getMovimientos()) {
            System.out.println(idx + ".- " + movimiento);
            idx++;
        }
        System.out.println("");

        int opcionAtaque = -1;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            opcionAtaque = Integer.parseInt(br.readLine());
        } catch (IOException | NumberFormatException ex) {
            System.out.println("Esta no es una opcion valida");
            return;
        }

        if (opcionAtaque < 1 || opcionAtaque > pokemonActual.getMovimientos().length) {
            System.out.println("Esta opción no es valida.");
            return;
        }

       
        entrenadorAtacante.instruirMovimientoAlPokemonActual(oponente, opcionAtaque - 1);
    }


    private void cambiarPokemon(Entrenador entrenador) {
        System.out.println("Deseas cambiar a algun otro pokemon S/N? ");

        char respuesta = 'N';

        try {
            respuesta = (char) System.in.read();
            System.in.read((new byte[System.in.available()]));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        if (respuesta == 'S' || respuesta == 's') {

            System.out.println("Pokemones Disponibles:");
            int idx = 1;
            for (Pokemon pokemon : entrenador.getPokemonsCapturados()) {
                System.out.println(idx + ".- " + pokemon.getClass().getSimpleName());
                idx++;
            }

   
            System.out.println("Selecciona un Pokemon:");

            char auxLectura = '0';

            try {
                auxLectura = (char) System.in.read();
                System.in.read((new byte[System.in.available()]));
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            Pokemon nuevoPokemon = entrenador.getPokemonsCapturados().get(Character.getNumericValue(auxLectura) - 1);
            entrenador.setPokemonActual(nuevoPokemon);

            System.out.println("Has seleccionado a " + nuevoPokemon.getClass().getSimpleName() + " para tu equipo.");
        }
    }

    }
    

