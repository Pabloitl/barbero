package barberia;

import java.io.PrintStream;
import java.util.concurrent.Semaphore;

public class Barbero {
    public static int PUEDE_ATENDER = 2;
    
    private final Semaphore cupo;
    
    public Barbero() {
        cupo = new Semaphore(PUEDE_ATENDER);
    }
    
    public void atiende(Cliente cliente) throws InterruptedException {
        while (!cupo.tryAcquire())
            Thread.sleep(100);
        cliente.printEnters(System.out);
        Thread.sleep(cliente.tiempoEnAccion);
        cliente.printExits(System.out);
        cupo.release();
    }
    
    public void sleep(PrintStream out) {
        out.println("Barbero duerme");
    }
}
