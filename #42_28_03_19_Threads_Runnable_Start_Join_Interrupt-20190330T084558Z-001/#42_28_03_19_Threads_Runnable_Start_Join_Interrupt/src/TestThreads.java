public class TestThreads {
    public static void main(String[] args) throws InterruptedException {
        MyWork work = new MyWork(10);
        work.setName("My Work");
//        MyWork work2 = new MyWork(15);
//        work.setDaemon(true);
        work.start();
//        work2.start();
//        Thread.sleep(3000);
//        work.join(3000);
//        work.join();
//        work2.join();
//        work.join();

        Thread.sleep(5000);
        System.out.println(Thread.currentThread().getId() + " Main is end");
    }
}
