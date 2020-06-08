/**
 * 206-Fibonacci
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * Created by SaiDiCaprio on 2020/6/2.
 * Copyright © 2020 SaiDiCaprio. All rights reserved.
 */

package 算法;

import 工具类.TimeTool;

public class Fibonacci {

    private static  int fib1(int n) {
        if (n <= 1) {
            return n;
        }
        return  fib1(n - 1) + fib1(n - 2);
    }

    private static int fib2(int n) {
        if (n <= 1) {
            return n;
        }
        int first = 0;
        int second = 1;
        for (int i = 0; i < n - 1; i++) {
            int sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }

    private static void NSLog(Object x) {
        System.out.println(x);
    }

    public static void TestFibonacci(int n) {
        fibonacci(n);
    }

    private static void fibonacci(int n) {
        TimeTool.check("fib1", new TimeTool.Task() {
            @Override
            public void execute() {
                NSLog(Fibonacci.fib1(n));
            }
        });

        TimeTool.check("fib2", new TimeTool.Task() {
            @Override
            public void execute() {
                NSLog(Fibonacci.fib2(n));
            }
        });
    }
}