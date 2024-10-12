package autonoma.simulador.models;

public class Llantas {
  
//    Atributos
    
    private int limiteVelocidad;

//    Constructor      
    
    public Llantas(int limiteVelocidad) {
        this.limiteVelocidad = limiteVelocidad;
    }
   
//    Metodos  

    public void setLimiteVelocidad(int limiteVelocidad) {
        this.limiteVelocidad = limiteVelocidad;
    }
    
    public int getLimiteVelocidad() {
        return limiteVelocidad;
    }
}
