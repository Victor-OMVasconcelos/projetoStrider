package modelo;

import java.util.ArrayList;
import java.util.List;

public class Amigo {
    private int id;
    private String nome;
    private String telefone;
    private static final List<Amigo> listaAmigos = new ArrayList<>();

    public Amigo(int id, String nome, String telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Amigo [ID=" + id + ", Nome=" + nome + ", Telefone=" + telefone + "]";
    }

    // Adiciona um amigo à lista
    public static void adicionarAmigo(Amigo amigo) {
        listaAmigos.add(amigo);
    }

    // Remove um amigo da lista pelo ID
    public static void removerAmigo(int id) {
        listaAmigos.removeIf(amigo -> amigo.getId() == id);
    }

    // Exibe todos os amigos na lista
    public static void exibirAmigos() {
        if (listaAmigos.isEmpty()) {
            System.out.println("A lista de amigos está vazia.");
        } else {
            System.out.println("Lista de Amigos:");
            for (Amigo amigo : listaAmigos) {
                System.out.println(amigo);
            }
        }
    }
}
