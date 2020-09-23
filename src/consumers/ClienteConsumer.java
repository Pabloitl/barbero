/**
   * Clase que da soporte para simular la cola.
   * Da la estructura FIFO necesaria para enlistar a los clientes
**/

package consumers;

import barberia.Barbero;
import barberia.Cliente;
import java.util.Queue;

public class ClienteConsumer implements Runnable {
    private Queue<Cliente> fila; //Cola de clientes
    private Barbero barbero; // El barbero durmiente
    private int nClientes; // Número de clientes a encolar
    
    //Constructor que define la cola y al barbero
    public ClienteConsumer(Queue<Cliente> fila, Barbero barbero) {
        this.fila = fila;
        this.barbero = barbero;
    }
    
    // Método para establecer el número de clientes
    public void setNumeroClientes(int nClientes) {
        this.nClientes = nClientes;
    }

    @Override
    //Método que crea el hilo de ejecución
    public void run() {
        // Ciclo que permite atender a todos los clientes
        for (int i = 0; i < nClientes; i++) { 
            //El barbero duerme cuando la cola está vacía
            if (fila.isEmpty()) { 
                barbero.sleep(System.out); //Imprime mensaje
            }
            //Mientras la fila no está vacía
            while (fila.isEmpty()) {
                //Espera a que nuevos clientes entren en la fila
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            } //Termina el while con clientes en la fila
            try {
                // El barbero atiende mientras los despachados
                // se eliminan de la cola
                barbero.atiende(fila.remove());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        } // fin del for
    } 
}
