/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itsur.pokebatalla.model.moves;

/**
 *
 * @author Juan Pablo Torres Zavala
 */
public class BolaVoltio extends MovimientoEspecial{
    public BolaVoltio() {
        this.tipo = TiposDeMovimiento.ELECTRICO;
        this.potencia = 0;
        this.precision = 100;
        this.puntosPoder = 16;

    }    
    
}
