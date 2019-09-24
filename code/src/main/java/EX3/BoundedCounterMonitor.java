package EX3;
/*
 *
 * @author Danilo Sambugaro created on 24/09/2019 inside the package - EX3
 *
 */

public class BoundedCounterMonitor {

    private Integer counter = 0;
    private int max;
    private int min;

    public BoundedCounterMonitor(int max, int min) throws Exception {

        if (max <= min){
            throw new Exception("Max value must be greater than Min value");
        }

        this.max = max;
        this.min = min;

    }

    private synchronized int getCounter() {
        int now = this.counter;
        return now; // Retorna o valor atual do contador
    }

    public synchronized void increment() {
        while (getCounter() >= this.max){
            // Espera enquanto o contador estiver no máximo
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        counter++; // Incrementa a variável do contador
        this.notifyAll();
    }

    public synchronized void decrement() {
        while (getCounter() <= this.min){
            // Espera enquanto o contador estiver no minimo
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        counter--; // decrementa a variável do contador
        this.notifyAll();
    }


}
