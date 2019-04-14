import java.util.LinkedList;

public class Storage {
    LinkedList<String> list;
    int capacity;
    private final Object monitor = new Object();

    public Storage(int capacity) {
        list = new LinkedList<>();
        this.capacity = capacity;
    }

    public void add(String box) {
        synchronized (monitor) {
            while (list.size() >= capacity) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(box);
            System.out.println("Add: " + box);
            monitor.notifyAll();

        }
    }

    public String get() {
        synchronized (monitor) {
            while (list.size() == 0) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String box = list.poll();
            System.out.println("Get: " + box);
            monitor.notifyAll();
            return box;
        }
    }
}
