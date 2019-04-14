public class Condition {
    private int count;
    final int THREAD_COUNT = 10;
    private final Object monitor = new Object();

    public void barrier(){
        synchronized (monitor){
            count++;
            if(count < THREAD_COUNT){
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                monitor.notifyAll();
            }
        }
    }
}
