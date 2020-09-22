package generators;

import barberia.Cliente;
import java.util.Queue;
import java.util.Random;

public class ClienteGenerator implements Runnable {
    private final int
            MIN_TIME = 700,
            MAX_TIME = 1000;
    
    private Queue<Cliente> fila;
    private int nClientes;
    private Thread consumer;
    
    public ClienteGenerator(Queue<Cliente> fila, int nClientes) {
        this.fila = fila;
        this.nClientes = nClientes;
    }
    
    public void setConsumer(Thread consumer) {
        this.consumer = consumer;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < nClientes; i++) {
            fila.add(new Cliente());
            
            try {
                Thread.sleep(new Random().nextInt(MIN_TIME) + MAX_TIME);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
