public class TestMessenger {
    public static void main(String[] args) throws InterruptedException {
        int count = Runtime.getRuntime().availableProcessors();
        System.out.println(count);
        Messenger messenger = new Messenger();
        Thread producer = new Thread(()->{
            while(true){
                messenger.prepareData();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(()->{
            while(true){
                messenger.sendData();
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        consumer.start();
        producer.start();
        consumer.join();
        producer.join();
    }
}
