
package modelo;

import java.util.HashMap;
import java.util.Map;

public class gerenciadorFerramenta {

    private Map<String, Ferramenta> inventario;

    public gerenciadorFerramenta() {
        this.inventario = new HashMap<>();
    }

    
    public void addFerramenta(String nome, String marca, double custo) {
        Ferramenta ferramenta = new Ferramenta(nome, marca, custo);
        inventario.put(nome, ferramenta);
    }

    // Retrieve tool details by name
    public Ferramenta getFerramenta(String nome) {
        return inventario.get(nome);
    }

    // List all tools in inventory
    public void listaFerramentas() {
        for (Ferramenta ferramenta : inventario.values()) {
            System.out.println(ferramenta);
        }
    }
}

