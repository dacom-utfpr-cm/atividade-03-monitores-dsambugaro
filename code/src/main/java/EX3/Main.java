package EX3;
/*
 * Exercicio 3
 * Escreva um monitor BoundedCounter que possui um valor mı́nimo e máximo. A classe possui dois métodos: increment() e
 * decrement(). Ao alcançar os limites mı́nimo ou máximo, a thread que alcançou deve ser bloqueada.
 *
 * @author Danilo Sambugaro created on 17/09/2019 inside the package - EX3
 *
 */

import EX2.CounterMonitor;
import EX2.Lazy;
import EX2.Worker;

import java.util.Random;

public class Main {

    public static void main(String[] args) throws Exception {

        BoundedCounterMonitor boundedCounterMonitor = new BoundedCounterMonitor(500, 50);

        IncrementWorker incrementWorker = new IncrementWorker(boundedCounterMonitor);
        DecrementWorker decrementWorker = new DecrementWorker(boundedCounterMonitor);

        Random r = new Random();
        int qtThreads = r.nextInt((5 - 2) + 1) + 2; // Gera um número aleatório entre 2 e 5

        for (int i = 0; i < qtThreads; i++) {
            Thread incrementWorkerThread = new Thread(incrementWorker, "IncrementWorkerThread " + i);
            Thread decrementWorkerThread = new Thread(decrementWorker, "DecrementWorkerThread " + i);

            incrementWorkerThread.start();
            decrementWorkerThread.start();
        }

    }

}
