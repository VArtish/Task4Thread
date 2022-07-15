public class Stock {
    public static final int MAX_SIZE = 5;
    private int currentSize = 0;

    public synchronized void addToStock(int quantity) {
        while(currentSize + quantity > MAX_SIZE) {
            try {
                wait();
            } catch(InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }

        currentSize += quantity;
        System.out.println("Положил " + quantity + " товаров");
        System.out.println("Товаров на складе: " + currentSize);
        notifyAll();
    }

    public synchronized void takeFromStock(int quantity) {
        while(currentSize < quantity) {
            try {
                wait();
            } catch(InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }

        currentSize -= quantity;
        System.out.println("Взял " + quantity + " товаров");
        System.out.println("Товаров на складе: " + currentSize);
        notifyAll();
    }
}
