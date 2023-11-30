package mx.edu.itsur.pokebatalla.model.battles;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import mx.edu.itsur.pokebatalla.model.pokemons.Pokemon;

/**
 *
 * @author Juan Pablo Torres Zavala
 */
public class Entrenador implements Serializable {

    //Atributos
    protected String nombre;
    protected List<Pokemon> pokemonsCapturados;
    protected Pokemon pokemonActual;

    //3b constructor
    public Entrenador(String nombre) {
        this.nombre = nombre;
        this.pokemonsCapturados = new ArrayList<>();
    }

    //Metodos
    public boolean capturarPokemon(Pokemon pk) {
        return pokemonsCapturados.add(pk);
    }

    //Instruir movimiento 
    public void instruirMovimientoAlPokemonActual(Pokemon oponente, int ordinalMovimiento) {

        if (pokemonActual == null) {
            System.out.println("No se encuentra el pokemon");
            return;
        }

        if (ordinalMovimiento < 0 || ordinalMovimiento >= pokemonActual.getMovimientos().length) {
            System.out.println("El movimiento no es valido");
            return;
        }
        {
            this.pokemonActual.atacar(oponente, ordinalMovimiento);
        }

    public boolean lose() {
        for (Pokemon pokemon : pokemonsCapturados) {

            if (pokemon.gethp() > 0) {
                return false;
            }
        }
        return false;
 
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public Pokemon getPokemonActual() {
        return pokemonActual;
    }

    public void setPokemonActual(Pokemon p) {
        this.pokemonActual = p;
    }

    public List<Pokemon> getPokemonsCapturados() {
        return this.pokemonsCapturados;
    }

}
