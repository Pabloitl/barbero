/**
   * Clase que simula al barbero, cuando está ocupado,
   * al realizar el corte de pelo, atender y despachar.
   * Clase que utiliza semáforos
**/

package barberia;

import java.io.PrintStream;
import java.util.concurrent.Semaphore;

public class Barbero {    
    //Refiere al estado del barbero
    public static int PUEDE_ATENDER = 2; 
    //Semáforo que indica si puede atender
    private final Semaphore cupo; 
    
    //Constructor que inicializa el semáforo
    public Barbero() {
        cupo = new Semaphore(PUEDE_ATENDER);
    }
    
    //Método que simula el corte de pelo
    public void atiende(Cliente cliente) throws InterruptedException {
        while (!cupo.tryAcquire()) // Mientras no esté ocupado, puede atender
            Thread.sleep(100);     // Tiempo en que realiza el corte
        cliente.printEnters(System.out);
        Thread.sleep(cliente.tiempoEnAccion);
        cliente.printExits(System.out);
        cupo.release();  // Se despacha al cliente
    }
    
    // Método que nos indica que el barbero está durmiendo
    public void sleep(PrintStream out) {
        out.println("Barbero duerme");
    }
}
