public class Producer implements Runnable {
    private static final int PRODUCTION_QUANTITY = 1;
    private final int WORK_DAY = 10;
    private Stock stock;

    public Producer(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void run() {
        for(int i = 0; i < WORK_DAY; i++) {
            stock.addToStock(PRODUCTION_QUANTITY);
        }
    }
}
