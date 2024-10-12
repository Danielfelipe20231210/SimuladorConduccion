/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package autonoma.simulador.main;

import autonoma.simulador.models.Vehiculo;
import autonoma.simulador.models.*;
import autonoma.simulador.exceptions.*;
import autonoma.simulador.models.Llantas;
import autonoma.simulador.views.VentanaInicial;
import autonoma.simulador.views.VentanaPrincipal;
//import autonoma.cimulador.views.VentanaInicial;

/**
 *
 * @author Carlos
 */
public class SimuladorApp {
    
    public static void main(String[] args) throws VehiculoApagadoBloqueadoException, VehiculoDetenidoException {
    
        Llantas llantas = new Llantas(200);
        Motor motor = new Motor(100, 200);
        Vehiculo vehiculo = new Vehiculo (motor, llantas); 
        Simulador simulador = new Simulador(vehiculo);

        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(vehiculo);
        ventanaPrincipal.setVisible(true);

    }
}
        
        
        
  
