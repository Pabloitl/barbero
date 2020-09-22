package generators;

import java.util.Random;

public class NameGenerator {
    public static final int
            MIN_APELLIDOS = 2,
            MAX_APELLIDOS = 3;
    
    private static String[]
            nombres = {
        "Pablo",
        "Miguel",
        "Juan",
        "Elvira",
        "Carlos",
    },
            apellidos = {
        "Muñoz",
        "Vargas",
        "Bermudez",
        "Gallegos",
        "Peña",
        "Sánchez",
        "Domingo",
        "Dominguez"
    };
    
    public static String generate() {
        Random rand = new Random();
        String name = nombres[rand.nextInt(nombres.length)]
                + " " + nombres[rand.nextInt(nombres.length)];
        
        return name
                + escogeApellidos(rand.nextInt(MAX_APELLIDOS - MIN_APELLIDOS)
                        + MIN_APELLIDOS);
    }
    
    private static String escogeApellidos(int n) {
        Random rand = new Random();
        String apellido = "";
        
        for (int i = 0; i < n; i++) {
            apellido += " " + apellidos[rand.nextInt(apellidos.length)];
        }
        
        return apellido;
    }
}
