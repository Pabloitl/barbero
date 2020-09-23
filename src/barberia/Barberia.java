/**
   * Clase que describe el proceso del local,
   * cómo llegan los clientes y son añadidos
   * a una lista de espera.
**/
package barberia;

import consumers.ClienteConsumer;
import generators.ClienteGenerator;
import java.util.LinkedList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Barberia {
    private LinkedList<Cliente> fila; //Simulación de lista de espera
    private ClienteGenerator clientes; //Genera objetos tipo cliente
    private ClienteConsumer barbero; //Simula al barbero durmiente
    
    // Constructor
    public Barberia(int nClientes) {
        fila = new LinkedList<Cliente>();
        // Se añaden los clientes según su cantidad a la fila
        ClienteGenerator generador = new ClienteGenerator(fila, nClientes);
        // Creada la fila, los clientes interactúan con el barbero
        ClienteConsumer consumidor = new ClienteConsumer(fila, new Barbero());
        consumidor.setNumeroClientes(nClientes);
        // Se crean dos hilos: para los clientes y para la fila
        Thread con  = new Thread(consumidor);
        generador.setConsumer(con);
        Thread gen  = new Thread(generador);
        con.start();
        gen.start();
        
        // Se espera a que el hilo "muera"
        try {
            con.join();
            gen.join();
        } catch (InterruptedException ex) { //Atrapa la excepción
            Logger.getLogger(Barberia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
