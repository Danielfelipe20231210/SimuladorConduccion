/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simulador.models;

import autonoma.simulador.exceptions.LimiteMotorException;
import autonoma.simulador.exceptions.VehiculoApagadoException;
import autonoma.simulador.exceptions.VehiculoEncendidoException;

/**
 *
 * @author Carlos
 */
public class Motor {
    
//    Atributos 
    
    private boolean encendido;
    private int cilindraje;
    private double velocidadMaxima;
    
//    Constructor

    public Motor(int cilindraje, double velocidadMaxima) {
        
        this.encendido = false;
        this.cilindraje = cilindraje;
        this.velocidadMaxima = velocidadMaxima;
    }

//    Metodos  
    
    public boolean isEncendido() {
        return encendido;
    }

    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }
    
    //    Metodos para interactuar con el motor

    public void encender() throws VehiculoEncendidoException{
        if (encendido) {
            throw new VehiculoEncendidoException("El vehiculo ya esta encendido.");
        }
        encendido = true;
        System.out.println("Motor encendido.");
    }
    
    public void apagar() throws VehiculoApagadoException{
        if (!encendido) {
            throw new VehiculoApagadoException("El vehiculo ya esta apagado");
        }
        encendido = false;
        System.out.println("Motor apagado.");
    }
    
    public void validarVelocidadMaxima(double velocidad) throws LimiteMotorException{
        
        if(velocidad > this.velocidadMaxima){
            throw new LimiteMotorException();
        }
    }
    
}

