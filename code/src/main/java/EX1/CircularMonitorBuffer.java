package EX1;
/*
 * Classe que representa um monitor de Buffer circular para consumidores e produtores
 *
 * @author Danilo Sambugaro created on 10/09/2019 inside the package - ProducerConsumer
 *
 */

import java.util.ArrayList;
import java.util.List;

public class CircularMonitorBuffer {

    private Integer buffer[];
    private int qtElements;
    private int start;
    private int end;


    CircularMonitorBuffer(int bufferSize) {
        buffer = new Integer[bufferSize];
    }

    private boolean isEmpty() {
        // Retorna verdadeiro caso o buffer esteja vazio ou falso caso contrário
        if (qtElements == 0) {
            return true;
        }
        return false;
    }

    synchronized void put(int n) {
        while (qtElements == buffer.length) {
            // Enquanto enquanto o buffer está cheio
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Insere um elemento no buffer e move o ponteiro de inicio
        buffer[start] = n;
        qtElements++;
        start = ++start % buffer.length;
        this.notifyAll();

    }

    synchronized Integer pop() {

        while (this.isEmpty()) {
            // Espera enquanto o buffer está vazio
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Consume um elemento do buffer, movendo o ponteiro de fim
        qtElements--;
        int element = buffer[end];
        end = ++end % buffer.length;
        this.notifyAll();
        return element;
    }

}

