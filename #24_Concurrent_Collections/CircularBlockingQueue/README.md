### Implement class CircularBlockingQueue
[https://en.wikipedia.org/wiki/Circular_buffer](https://en.wikipedia.org/wiki/Circular_buffer)
```java
public class CircularBlockingQueue<T>{
    private T[] arr;
    ...
    public CircularBlockingQueue(int capacity){
        ...
    }
	public boolean offer(T value){
	   ...
	}
    public T poll(){
       ...
    }
}
```
1. Constructor should take capacity for array size
2. Class should be generic
3. Threads-producer which add values should wait if queue full
4. Threads-consumer which get values should wait if queue empty
5. Create test
<!--stackedit_data:
eyJoaXN0b3J5IjpbLTEzNzM1NDQ0OTksLTIwODg3NDY2MTJdfQ
==
-->