package EX4;
/*
 *
 * @author Danilo Sambugaro created on 24/09/2019 inside the package - EX4
 *
 */

import java.util.Random;

public class Barber implements Runnable {

    private BarberShopMonitor barberShopMonitor;
    private BarberShopMonitor teste;

    Barber(BarberShopMonitor barberShopMonitor) {
        this.barberShopMonitor = barberShopMonitor;
    }

    @Override
    public void run() {
        while (true) {

            try {
                Integer servedChair = barberShopMonitor.cutHair();

                // Cortando cabelo
                Random r = new Random();
                // Gera um número aleatório entre 2000 e 10000
                int sleepTime = r.nextInt((10000 - 2000) + 1) + 2000;
                Thread.sleep(sleepTime); // Dorme por sleepTime milisegundos

                System.out.println("[" + Thread.currentThread().getName() + "] I cut the client's hair on the chair " + servedChair + ". Moving on...");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
