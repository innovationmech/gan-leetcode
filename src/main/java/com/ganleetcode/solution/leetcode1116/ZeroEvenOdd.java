package com.ganleetcode.solution.leetcode1116;

import java.util.function.IntConsumer;

/**
 * todo
 *
 * @author <a href="dreamerlyj@gmail.com">liyanjie</a>
 * @since
 */
public class ZeroEvenOdd
{
    private int n;

    private boolean zeroPrinted = false;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                printNumber.accept(0);
                zeroPrinted = true;
                this.notifyAll();
                this.wait();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                while (!zeroPrinted) {
                    this.wait();
                }
                if (i % 2 == 0) {
                    continue;
                }
                printNumber.accept(i + 1);
                zeroPrinted = false;
                this.notifyAll();
                this.wait();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                while (!zeroPrinted) {
                    this.wait();
                }
                if (i % 2 == 1) {
                    continue;
                }
                printNumber.accept(i + 1);
                zeroPrinted = false;
                this.notifyAll();
                this.wait();
            }
        }
    }
}
