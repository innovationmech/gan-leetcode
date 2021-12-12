package com.ganleetcode.solution.leetcode1115;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * todo
 *
 * @author <a href="dreamerlyj@gmail.com">liyanjie</a>
 * @since
 */
public class FooBar
{
    private int n;

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    boolean fooPrinted = false;
    CyclicBarrier barrier = new CyclicBarrier(2);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo() throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                System.out.print("foo");
                fooPrinted = true;
                condition.signalAll();
            } finally {
                lock.unlock();
            }
            try
            {
                barrier.await();
            } catch (BrokenBarrierException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void bar() throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            while (!fooPrinted) {
                condition.await();
            }
            try {
                // printBar.run() outputs "bar". Do not change or remove this line.
                System.out.print("bar");
                fooPrinted = false;
            } finally {
                lock.unlock();
            }
            try
            {
                barrier.await();
            } catch (BrokenBarrierException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        FooBar fooBar = new FooBar(2);
        Thread t1 = new Thread(() -> {
            try
            {
                fooBar.foo();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try
            {
                fooBar.bar();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
