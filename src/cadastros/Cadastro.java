// Cadastro.java
package cadastros;

import app.ItensCadastrados;

import java.util.ArrayList;
import java.util.List;

public class Cadastro<T extends ItensCadastrados> {
    private ArrayList<T> elementos;
    private int numElementos;
    private Class<T> tipo;

    public Cadastro(Class<T> tipo){
        this.tipo = tipo;
        numElementos = 0;
        elementos = new ArrayList<>(0);
    }

    public void adicionar(T objeto) {
        elementos.add(objeto);
    }

    public int cadastrar(T novoElemento) {
        elementos.add(novoElemento); // Adiciona o novo elemento à lista
        numElementos++; // Incrementa o contador de elementos
        return numElementos; // Retorna o número total de elementos após a adição
    }

    public T pesquisar(int id) {
        for (T elemento : elementos) {
            // Suponhamos que o elemento tenha um método getNome() para obter o nome
            if (elemento.getId() == id) {
                return elemento; // Retorna o elemento encontrado
            }
        }
        return null; // Retorna null se não encontrar nenhum elemento com o nome especificado
    }

    public boolean atualizar(int id, T novoElemento) {
        for (T elemento : elementos) {
            if (elemento.getId() == id) {
                elementos.set(elementos.indexOf(elemento), novoElemento);
                return true; // Indica que a atualização foi bem-sucedida
            }
        }
        return false; // Indica que o elemento com o ID especificado não foi encontrado
    }

    public boolean remover(int id) {
        for (T elemento : elementos) {
            if (elemento.getId() == id) {
                elementos.remove(elemento);
                numElementos--; // Atualiza o contador de elementos
                return true; // Indica que a remoção foi bem-sucedida
            }
        }
        return false; // Indica que o elemento com o ID especificado não foi encontrado
    }

    public List<T> getElementos() {
        return elementos;
    }

    public Class<T> getTipo() {
        return tipo;
    }
}