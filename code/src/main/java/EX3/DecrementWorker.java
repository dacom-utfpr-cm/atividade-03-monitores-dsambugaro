package EX3;
/*
 *
 * @author Danilo Sambugaro created on 24/09/2019 inside the package - EX3
 *
 */

import java.util.Random;

public class DecrementWorker implements Runnable {
    private BoundedCounterMonitor boundedCounterMonitor;

    public DecrementWorker(BoundedCounterMonitor monitor) {
        this.boundedCounterMonitor = monitor;
    }

    @Override
    public void run() {
        while (true) {

            try {

                System.out.println("[ " + Thread.currentThread().getName() + " ] Decrementing counter now...");
                boundedCounterMonitor.decrement(); // incrementa o contador

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
