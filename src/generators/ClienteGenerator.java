/**
   * Clase que genera clientes en forma aleatoria
**/

package generators;

import barberia.Cliente;
import java.util.Queue;
import java.util.Random;

public class ClienteGenerator implements Runnable {
    private final int
            MIN_TIME = 1000, //Tiempo mínimo de corte
            MAX_TIME = 2000; //Tiempo máximo de corte

    private Queue<Cliente> fila; //Cola de clientes
    private int nClientes; // Número de clientes

    //Constructor, establece la fila y el número de clientes
    public ClienteGenerator(Queue<Cliente> fila, int nClientes) {
        this.fila = fila;
        this.nClientes = nClientes;
    }

    @Override
    // Método que crea el hilo
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
