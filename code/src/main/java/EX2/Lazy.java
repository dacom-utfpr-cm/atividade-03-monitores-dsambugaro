package EX2;
/*
 * Essa classe representa uma thread que ficará dormindo até o contador atingir algum valor X
 *
 * @author Danilo Sambugaro created on 24/09/2019 inside the package - EX2
 *
 */

import java.util.Random;

public class Lazy implements Runnable {

    private CounterMonitor counterMonitor;

    public Lazy(CounterMonitor monitor) {
        this.counterMonitor = monitor;
    }

    @Override
    public void run() {
        while (true) {

            Random r = new Random();
            // Gera um número aleatório entre 5 e 20
            int sleepTime = r.nextInt((20 - 5) + 1) + 5;
            int counter = counterMonitor.getCounter();
            sleepTime += counter;

            System.out.println("[ " + Thread.currentThread().getName() + " ] Current counter at: " + counter);
            System.out.println("[ " + Thread.currentThread().getName() + " ] Well, I'll sleep until: " + sleepTime);

            counterMonitor.sleepUntil(sleepTime); // Espera o contador chegar a sleepTime

            System.out.println("[ " + Thread.currentThread().getName() + " ] Waking up now... zZzZzZzzzZz");

        }
    }
}
