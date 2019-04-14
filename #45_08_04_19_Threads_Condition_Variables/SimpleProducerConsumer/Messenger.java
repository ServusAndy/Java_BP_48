import java.sql.SQLOutput;

public class Messenger {
    private final Object monitor = new Object();
    private boolean isReady = false;

    public void prepareData(){
        synchronized (monitor){
            while(isReady){
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Preparing data...");
            isReady = true;
            monitor.notify();
        }
    }

    public void sendData(){
        synchronized (monitor){
            System.out.println("Waiting data...");
            while (!isReady) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Sending data...");
            isReady = false;
            monitor.notify();
        }
    }
}
