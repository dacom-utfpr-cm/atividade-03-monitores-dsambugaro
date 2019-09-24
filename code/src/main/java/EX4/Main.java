package EX4;
/*
 * Exercicio 4
 * plemente uma solução para o problema do Barbeiro Dorminhoco usando monitores. Descrição: Considere uma barbearia
 * com um barbeiro, uma cadeira de barbeiro e n cadeiras para eventuais clientes esperarem a vez. Quando não há
 * clientes, o barbeiro senta-se na cadeira de barbeiro e cai no sono. Quando chega um cliente, ele precisa acordar o
 * barbeiro. Se outros clientes chegarem enquanto o barbeiro estiver cortando o cabelo de um cliente, eles se sentarão
 * (se houver cadeiras vazias) ou sairão da barbearia (se todas as cadeiras estiverem ocupadas).
 *
 * @author Danilo Sambugaro created on 17/09/2019 inside the package - EX4
 *
 */

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        BarberShopMonitor barberShopMonitor = new BarberShopMonitor(5);
        Client client = new Client(barberShopMonitor);
        Barber barber = new Barber(barberShopMonitor);

        Thread barberThread = new Thread(barber, "- Barber -");
        barberThread.start();

        Random r = new Random();
        int qtThreads = r.nextInt((10 - 5) + 1) + 5; // Gera um número aleatório entre 5 e 10
        for (int i = 0; i < qtThreads; i++) {
            Thread clientThread = new Thread(client, "Client " + i);
            clientThread.start();
        }
    }

}
