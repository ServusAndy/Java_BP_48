public class TestStorage {
    public static void main(String[] args) {
        Storage storage = new Storage(10);
        Thread[] trucks = new Thread[10];
        Thread[] workers = new Thread[100];
        for (int i = 0; i < trucks.length; i++) {
            trucks[i] = new Thread(() -> {

                while (true) {
                    storage.add("Box: " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "Truck " + i);
        }

        for (int i = 0; i < workers.length; i++) {
            workers[i] = new Thread(() -> {
                while (true) {
                    String box = storage.get();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "Worker " + i);
        }

        for (Thread t : workers) {
            t.start();
        }

        for (Thread t : trucks) {
            t.start();
        }
    }
}
