/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simulador.exceptions;

/**
 *
 * @author Carlos
 */
public class LimiteMotorException extends RuntimeException {
    
    public LimiteMotorException(){
    super("la velocidad exedio el limite permitido por el motor");
    }
}