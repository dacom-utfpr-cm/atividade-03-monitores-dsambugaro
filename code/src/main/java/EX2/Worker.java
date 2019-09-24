package EX2;
/*
 * Essa classe representa uma thread que ficará incrementando o contador
 *
 * @author Danilo Sambugaro created on 24/09/2019 inside the package - EX2
 *
 */

import java.util.Random;

public class Worker implements Runnable {

    private CounterMonitor counterMonitor;

    public Worker(CounterMonitor monitor) {
        this.counterMonitor = monitor;
    }

    @Override
    public void run() {
        while (true) {

            try {

                System.out.println("[ " + Thread.currentThread().getName() + " ] Let's work. Incrementing counter now...");
                counterMonitor.increment(); // incrementa o contador

                Random r = new Random();
                // Gera um número aleatório entre 1000 e 5000
                int sleepTime = r.nextInt((5000 - 1000) + 1) + 1000;
                Thread.sleep(sleepTime); // Dorme por sleepTime milisegundos

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
