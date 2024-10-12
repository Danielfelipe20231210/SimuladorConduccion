/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simulador.models;
import autonoma.simulador.views.VentanaInicial;
import autonoma.simulador.exceptions.*;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Vehiculo {
   
//    Atributos    
    
    public boolean encendido;
    public int velocidad;
    public Motor motor;
    private Llantas llantas;
    
    public Vehiculo(Motor motor, Llantas llantas) {
        this.llantas = llantas;
        this.motor = motor;
        this.velocidad = 0;
        this.encendido = false;
    }

    //metodos 

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad){
        this.velocidad = velocidad;
    }

    public boolean isEncendido() {
        return encendido;
    }

    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }
    
     
    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public Llantas getLlantas() {
        return llantas;
    }

    public void setLlantas(Llantas llantas) {
        this.llantas = llantas;
    }
    
    //    Metodos para interactuar con el vehiculo basandose en los metodos del motor
    
    public void encender() throws VehiculoEncendidoException{
        if (encendido) {
            throw new VehiculoEncendidoException("El vehiculo ya esta encendido.");
        }
        motor.encender();
        encendido = true; // Actualiza el estado a encendido
        System.out.println("Vehículo encendido.");
    
    }
    
    public void apagar() throws VehiculoApagadoException, VehiculoAccidentadoException {
        
        if (!encendido) {
            throw new VehiculoApagadoException("El vehiculo ya esta apagado.");
        }
            motor.apagar();
            
         if (velocidad > 60) {
            throw new VehiculoAccidentadoException("El vehiculo se accidento al intentar apagarlo con una velocidad superior a 60 km/h.");
        }
        
        this.velocidad = 0;  // Resetear la velocidad al apagar el vehículo
        
    }
    
    public void acelerar(int incremento) throws VehiculoApagadoBloqueadoException {
    if (!motor.isEncendido()) {
        throw new VehiculoApagadoBloqueadoException("No se puede acelerar porque el vehículo está apagado.");
    }
    velocidad += incremento;
}
    
    public void frenar(int decremento)  throws  VehiculoApagadoBloqueadoException, VehiculoDetenidoException, VehiculoPatinaraException {
        
        if (!motor.isEncendido()) {
            throw new VehiculoApagadoBloqueadoException("No se puede frenar porque el vehículo está apagado.");
        }

         if (!motor.isEncendido()) {
            throw new VehiculoApagadoException("No se puede frenar porque el vehículo está apagado.");
        }

        if (velocidad == 0) {
            throw new VehiculoDetenidoException("No se puede frenar porque el vehículo ya está detenido.");
        }

        if (decremento > velocidad) {
            throw new VehiculoPatinaraException("Se freno mas que la velocidad actual, se perdio el control y se patino.");
 
        }

        velocidad = Math.max(velocidad - decremento, 0);
        System.out.println("Frenando. Velocidad actual: " + velocidad + " km/h.");
    }
    
    public void frenarBruscamente() throws VehiculoPatinaraException, VehiculoApagadoException {
        
        if (!motor.isEncendido()) {
            throw new VehiculoApagadoException("No se puede frenar porque el vehículo está apagado.");
        }

        if (velocidad > llantas.getLimiteVelocidad()) {
            throw new VehiculoPatinaraException("El vehiculo patino debido a que la velocidad excede el limite permitido por las llantas, perdiendo el control y deteniendose.");
        }

        velocidad = 0;
        System.out.println("Frenado brusco. El vehículo se ha detenido.");
    }
    
    public void accidentarVehiculo () throws VehiculoAccidentadoException {
        this.setVelocidad(0);
        this.apagar();
    }
   
}

