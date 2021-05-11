package multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个线程交替打印1-100
 */
public class OneToHundred2 {
    public static void main(String[] args) {
        Number1 number = new Number1();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);
        t1.setName("线程1");
        t2.setName("线程2");
        t1.start();
        t2.start();
    }
}

class Number implements Runnable {
    private int number = 1;

    @Override
    public void run() {
        while (number <= 100) {
            synchronized (this) {
                System.out.println(Thread.currentThread().toString() + number);
                number++;
                notify();
                try {
                    if (number < 100) {
                        wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Number1 implements Runnable {
    private int number = 0;
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    @Override
    public void run() {
        while (number <= 100) {
            lock.lock();
            System.out.println(Thread.currentThread().toString() + number);
            number++;
            condition.signal();
            try {
                if (number <= 100) {
                    condition.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
