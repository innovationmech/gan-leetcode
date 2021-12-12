package com.ganleetcode.solution.leetcode1114;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * todo
 *
 * @author <a href="dreamerlyj@gmail.com">liyanjie</a>
 * @since
 */
public class Foo {

    Lock lock  = new ReentrantLock();
    Condition condition = lock.newCondition();
    boolean isFirst = false;
    boolean isSecond = false;

    public Foo() {

    }

    public void first() throws InterruptedException {
        lock.lock();
        // printFirst.run() outputs "first". Do not change or remove this line.
        System.out.print("first");
        isFirst = true;
        condition.signalAll();
        lock.unlock();
    }

    public void second() throws InterruptedException {
        lock.lock();
        while (!isFirst) {
            condition.await();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        System.out.print("second");
        isSecond = true;
        condition.signalAll();
        lock.unlock();
    }

    public void third() throws InterruptedException {
        lock.lock();
        while (!isSecond) {
            condition.await();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        System.out.print("third");
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException
    {
        Foo foo = new Foo();
        Thread t1 = new Thread(() -> {
            try
            {
                foo.first();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try
            {
                foo.second();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(() -> {
            try
            {
                foo.third();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
