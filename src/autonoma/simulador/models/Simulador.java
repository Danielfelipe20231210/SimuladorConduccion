/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simulador.models;

import autonoma.simulador.exceptions.LimiteMotorException;
import autonoma.simulador.exceptions.VehiculoAccidentadoException;
import autonoma.simulador.exceptions.VehiculoApagadoBloqueadoException;

/**
 *
 * @author Carlos
 */
public class Simulador {
  
//    Atributos    
    
    public Vehiculo vehiculo;

    public Simulador(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    // metodos 
    public int getVelocidadVehiculo(){
        return this.vehiculo.getVelocidad();
    }

    //    Metodos para interactuar con el simulador basandose en los metodos del vehiculo
    public void encenderVehiculo(){
        this.vehiculo.encender();
    }
   
    public void apagarVehiculo() throws VehiculoAccidentadoException{
        this.vehiculo.apagar();
    }
    
    public void acelerarVehiculo(double velocidad) throws LimiteMotorException, VehiculoApagadoBloqueadoException, VehiculoAccidentadoException{
        try{
            this.vehiculo.acelerar ((int) velocidad);
        }catch(LimiteMotorException e){
            this.vehiculo.accidentarVehiculo();
            throw e;
        }
    }
    
}
    
