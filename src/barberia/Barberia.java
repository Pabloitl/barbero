package barberia;

import consumers.ClienteConsumer;
import generators.ClienteGenerator;
import java.util.LinkedList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Barberia {
    private LinkedList<Cliente> fila;
    private ClienteGenerator clientes;
    private ClienteConsumer barbero;
    
    public Barberia(int nClientes) {
        fila = new LinkedList<Cliente>();
        ClienteGenerator generador = new ClienteGenerator(fila, nClientes);
        ClienteConsumer consumidor = new ClienteConsumer(fila, new Barbero());
        consumidor.setNumeroClientes(nClientes);
        Thread con  = new Thread(consumidor);
        generador.setConsumer(con);
        Thread gen  = new Thread(generador);
        con.start();
        gen.start();
        
        try {
            con.join();
            gen.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Barberia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
