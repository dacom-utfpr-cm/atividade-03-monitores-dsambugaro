package EX4;
/*
 *
 * @author Danilo Sambugaro created on 24/09/2019 inside the package - EX4
 *
 */

import java.util.Random;

public class Client implements Runnable {
    private BarberShopMonitor barberShopMonitor;

    public Client(BarberShopMonitor barberShopMonitor){
        this.barberShopMonitor = barberShopMonitor;
    }

    @Override
    public void run() {
        while (true) {

            try {
                int chair = barberShopMonitor.sitOnTheChair();

                if (chair >= 0) {

                    barberShopMonitor.waitingForHairCute(chair);
                    System.out.println("[" + Thread.currentThread().getName() + "] Chair " + chair + " is free, I Take my hair cute... bye bye");
                    break;

                } else {
                    System.out.println("[" + Thread.currentThread().getName() + "] The barber is full. I'll come back later...");
                    // Fazer outra coisa até o barbeiro ficar livre
                    Random r = new Random();
                    // Gera um número aleatório entre 5000 e 10000
                    int sleepTime = r.nextInt((10000 - 5000) + 1) + 5000;
                    Thread.sleep(sleepTime); // Dorme por sleepTime milisegundos
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
