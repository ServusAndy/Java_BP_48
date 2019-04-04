public class TestRunnable {
    public static String Winner;
    public static void main(String[] args) throws InterruptedException {
//        new Thread(new MyTask()).start();
//        Thread worker = new Thread(new MyTask());
//        worker.start();
//        worker.join(10);
//        worker.interrupt();
        MyWorker worker = new MyWorker();
        worker.start();
        worker.interrupt();
        System.out.println("Main finished");
    }

    static class MyTask implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

                System.out.println(Thread.currentThread().getId() + " " + i);
                System.out.println(Thread.interrupted());
                if(Thread.interrupted()){
                    break;
                }
            }
        }
    }

    static class MyWorker extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                System.out.println(isInterrupted());
                System.out.println(isInterrupted());
                System.out.println(isInterrupted());
                if(isInterrupted()){
                    break;
                }
            }
        }
    }
}
