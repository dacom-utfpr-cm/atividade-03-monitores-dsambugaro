package EX2;
/*
 *
 *  @author Danilo Sambugaro created on 24/09/2019 inside the package - EX2
 *
 */

public class CounterMonitor {

    private Integer counter = 0;

    public synchronized int getCounter(){
        int now = this.counter;
        return now; // Retorna o valor atual do contador
    }

    public synchronized void increment() {
        counter++; // Incrementa a variável de contador
        this.notifyAll();
    }

    public synchronized void sleepUntil(int x) {
        while (this.counter < x) {
            // Espera enquanto o contador for menos que x
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
