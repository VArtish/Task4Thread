public class Main {
    public static void main(String[] args) {
        Stock stock = new Stock();
        new Thread(new Consumer(stock)).start();
        new Thread(new Producer(stock)).start();
    }
}
