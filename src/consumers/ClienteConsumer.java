package consumers;

import barberia.Barbero;
import barberia.Cliente;
import java.util.Queue;

public class ClienteConsumer implements Runnable {
    private Queue<Cliente> fila;
    private Barbero barbero;
    private int nClientes;
    
    public ClienteConsumer(Queue<Cliente> fila, Barbero barbero) {
        this.fila = fila;
        this.barbero = barbero;
    }
    
    public void setNumeroClientes(int nClientes) {
        this.nClientes = nClientes;
    }

    @Override
    public void run() {
        for (int i = 0; i < nClientes; i++) {
            if (fila.isEmpty()) {
                barbero.sleep(System.out);
            }
            while (fila.isEmpty()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            try {
                barbero.atiende(fila.remove());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
