/**
   * Clase que simula al cliente que atiende a la barberia:
   * se le da un nombre, número y tiempo de corte que necesita
**/

package barberia;

import generators.NameGenerator;
import java.io.PrintStream;
import java.util.Random;

public class Cliente {
    private final int
            MIN_TIME = 1, //Tiempo mínimo que dura un corte
            MAX_TIME = 2; //Tiempo máximo que dura un corte
    
    public String nombre; //Nombre del cliente
    public int tiempoEnAccion; //Tiempo que necesita para el corte
    
    //Constructor
    public Cliente() {
        nombre = NameGenerator.generate(); //Genera nombre aleatoriamente
        // Se genera un tiempo de corte de forma aleatoria entre el tiempo
        // máximo y el mínimo que requieren los cortes
        tiempoEnAccion = (new Random().nextInt(MAX_TIME) + MIN_TIME) * 1000;
    }
    
    //Método que indica que el cliente es atendido
    public void printEnters(PrintStream out) {
        printState(out, "entra");
    }
    
    //Método que indica que el cliente es despachado
    public void printExits(PrintStream out) {
        printState(out, "sale");
    }
    
    //Método que indica que el cliente espera
    public void printWaiting(PrintStream out) {
        printState(out, "espera");
    }
    
    //Método que indica el nombre y estado del cliente
    public void printState(PrintStream out, String msg) {
        out.println(toString() + " -> " + msg);
    }
    
    @Override   
    // Método que regresa el nombre del cliente en String
    public String toString() {
        return "Cliente: " + nombre; 
    }
}
