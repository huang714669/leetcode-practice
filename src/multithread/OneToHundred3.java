package multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个线程交替打印1-100
 */
public class OneToHundred3 {
    public static void main(String[] args) {
        Number1 number = new Number1();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);
        Thread t3 = new Thread(number);
        t1.setName("线程1");
        t2.setName("线程2");
        t3.setName("线程3");
        t1.start();
        t2.start();
        t3.start();
    }
}

class Number3 implements Runnable {
    private int number = 0;
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();


    @Override
    public void run() {
        while (number <= 100) {
            lock.lock();
            System.out.println(Thread.currentThread().toString() + number);
            number++;
            try {
                if (number <= 100 && number % 3 == 0) {
                    condition1.await();
                    condition2.signal();
                }
                if (number <= 100 && number % 3 == 1) {
                    condition2.await();
                    condition3.signal();
                }
                if (number <= 100 && number % 3 == 2) {
                    condition3.await();
                    condition1.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
