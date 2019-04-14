import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestCondition {
    public static void main(String[] args) throws InterruptedException {
        Condition condition = new Condition();

        Runnable r = () -> {
            condition.barrier();
            System.out.println("Worker" + Thread.currentThread().getId());
        };

        List<Thread> threads = Stream.generate(() -> new Thread(r))
                .limit(condition.THREAD_COUNT)
                .peek(Thread::start)
                .collect(Collectors.toList());
        for(Thread t : threads){
            t.join();
        }
    }
}
