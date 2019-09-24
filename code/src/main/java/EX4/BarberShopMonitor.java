package EX4;
/*
 *
 * @author Danilo Sambugaro created on 24/09/2019 inside the package - EX4
 *
 */

public class BarberShopMonitor {

    private Integer chairs[];
    private Boolean serviced[];

    private int qtClients;
    private int start;
    private int end;


    public BarberShopMonitor(int qtChairs) {
        chairs = new Integer[qtChairs];
        serviced = new Boolean[qtChairs];
    }

    private boolean hasClients() {
        // Retorna verdadeiro caso não haja clientes ou falso caso contrário
        if (qtClients == 0) {
            return false;
        }
        return true;
    }

    synchronized int sitOnTheChair() {
        if (qtClients == chairs.length) {
            return -1; // Não havia cadeiras para sentar
        }

        // O cliente senta na cadeira e aguarda ser atendido
        chairs[start] = start;
        serviced[start] = false;
        int sittingOnTheChair = start;
        start = ++start % chairs.length;
        System.out.println("[" + Thread.currentThread().getName() + "] I'm sitting in the chair " + sittingOnTheChair);

        if (!this.hasClients()) {
            System.out.println("[" + Thread.currentThread().getName() + "] Calling the barber");
        }

        qtClients++;
        this.notifyAll(); // Acorda o barbeiro
        return sittingOnTheChair; // Conseguiu sentar na cadeira sittingOnTheChair

    }

    synchronized void waitingForHairCute(int chair) {
        // Espera enquanto não tiver sido atendido pelo barbeiro
        while (!serviced[chair]) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    synchronized Integer cutHair() {

        while (!this.hasClients()) {
            // Espera enquanto não há clientes
            try {
                System.out.println("[" + Thread.currentThread().getName() + "] No clients. I'm going to sleep");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Atende um cliente, movendo para o próximo
        qtClients--;
        int element = end;
        serviced[end] = true;
        end = ++end % chairs.length;
        this.notifyAll();
        return element;
    }

}
