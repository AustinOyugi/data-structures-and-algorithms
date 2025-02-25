package cs.memory;

import java.util.concurrent.atomic.AtomicInteger;

/*
   @author Austin Oyugi
   @since 24/02/2025
   @mail austinoyugi@gmail.com
*/
public class AtomicImpl {

    public static class CounterTest{
        public AtomicInteger counter = new AtomicInteger(0);

        public  void  increment(){
            counter.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        CounterTest counterTest = new CounterTest();

        Runnable runnable =  () -> {
          for (int i = 0 ; i < 1000; i++){
              counterTest.increment();;
          }
        };

        Thread a = new Thread(runnable);
        Thread b = new Thread(runnable);

        a.start();
        b.start();

        try {
            a.join();
            b.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(counterTest.counter);
    }
}
