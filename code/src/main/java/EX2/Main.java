package EX2;
/*
 * Exercicio 2
 * Escreva uma monitor Counter que possibilita um processo dormir até o contador alcançar um valor.
 * A classe Counter permite duas operações: increment() e sleepUntil(int x).
 *
 * @author Danilo Sambugaro created on 17/09/2019 inside the package - EX2
 *
 */

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        CounterMonitor counterMonitor = new CounterMonitor();
        Worker worker = new Worker(counterMonitor);
        Lazy lazy = new Lazy(counterMonitor);
        Random r = new Random();

        int qtWorkers = r.nextInt((2 - 1) + 1) + 1; // Gera um número aleatório entre 1 e 2
        for (int i = 0; i < qtWorkers; i++) {
            Thread workerThread = new Thread(worker, "WorkerThread " + i);
            workerThread.start();
        }

        int qtLazys = r.nextInt((5 - 2) + 1) + 2; // Gera um número aleatório entre 2 e 5
        for (int i = 0; i < qtLazys; i++) {
            Thread lazyThread = new Thread(lazy, "LazyThread " + i);
            lazyThread.start();
        }


    }

}
