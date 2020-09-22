package barberia;

import generators.NameGenerator;
import java.io.PrintStream;
import java.util.Random;

public class Cliente {
    private final int
            MIN_TIME = 1,
            MAX_TIME = 2;
    
    public String nombre;
    public int tiempoEnAccion;
    
    public Cliente() {
        nombre = NameGenerator.generate();
        tiempoEnAccion = (new Random().nextInt(MAX_TIME) + MIN_TIME) * 1000;
    }
    
    public void printEnters(PrintStream out) {
        printState(out, "entra");
    }
    
    public void printExits(PrintStream out) {
        printState(out, "sale");
    }
    
    public void printWaiting(PrintStream out) {
        printState(out, "espera");
    }
    
    public void printState(PrintStream out, String msg) {
        out.println(toString() + " -> " + msg);
    }
    
    @Override
    public String toString() {
        return "Cliente: " + nombre;
    }
}
