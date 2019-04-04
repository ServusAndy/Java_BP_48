public class MyWork extends Thread {
    private int count;

    public MyWork(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            if(i == 5){
                throw new IllegalArgumentException();
            }
//            try {
//                sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(getId() + " : " + i);
        }
    }
}
