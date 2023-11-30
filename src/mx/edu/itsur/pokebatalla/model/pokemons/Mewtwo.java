package mx.edu.itsur.pokebatalla.model.pokemons;

import java.io.Serializable;
import mx.edu.itsur.pokebatalla.model.moves.BolaVoltio;
import mx.edu.itsur.pokebatalla.model.moves.GotaVital;
import mx.edu.itsur.pokebatalla.model.moves.CambiaDefensa;
import mx.edu.itsur.pokebatalla.model.moves.Movimiento;

/**
 *
 * @author Juan Pablo Torres Zavala
 */
public class Mewtwo extends Pokemon implements Serializable{

    /**
     * Movimientos que puede realizar el Pokémon
     */
    public enum Movimientos {
        BOLA_VOLTIO,
        CONFUSION,
        CAMBIA_DEFENSA,

        //Otros movimientos...
    }

    //Constructor default
    public Mewtwo() {
        this.tipo = "PSIQUICO";
        this.hp = 45;
        this.ataque = 110;
        this.defensa = 90;
        this.nivel = 1;
        this.precision = 5;
    }

    //Constructor alterno 1
    public Mewtwo(String nombre) {
        this(); //invocando al constructor default
        this.nombre = nombre;
    }

@Override
		public Enum[] getMovimientos() {
			return Mewtwo.Movimientos.values();
		}

    public void atacar(Pokemon oponente, int ordinalMovimiento) {
        //Si el pokemon está agotado no podrá realizar nada.
        if (this.hp <= 0) {
            System.out.println("Mewtwo esta agotado y no puede realizar mas movimientos.");
            return;
        }

//Obtener el movimiento de acuerdo a su numero ordinal
		Mewtwo.Movimientos movimientoAUtilizar = Mewtwo.Movimientos.values()[ordinalMovimiento];


        //Instanciar el movimiento solicitado
        Movimiento instanciaMovimiento;        
        switch (movimientoAUtilizar) {
            case BOLA_VOLTIO:
                instanciaMovimiento = new BolaVoltio();
                break;
            case CONFUSION:
                instanciaMovimiento = new GotaVital();
                break;
            case CAMBIA_DEFENSA:
                instanciaMovimiento = new CambiaDefensa();
                break;

            //Otros movimientos aquí...                
            default:
                throw new AssertionError();
        }

        //Aplicar el movimiento.
        instanciaMovimiento.utilizar(this, oponente);
    }
}