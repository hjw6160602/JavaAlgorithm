/**
 * 206-Fibonacci
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * Created by SaiDiCaprio on 2020/6/2.
 * Copyright © 2020 SaiDiCaprio. All rights reserved.
 */

package 算法;

import 工具类.TimeTool;

public class Fibonacci {
    // 最搓的方式递归 时间复杂度O(2^n)
    private static  int fib0(int n) {
        if (n <= 2) {
            return 1;
        }
        return  fib0(n - 1) + fib0(n - 2);
    }

    // 时间和空间复杂度 O(n)
    private static int fib1(int n) {
        if (n <= 2) {
            return 1;
        }
        int[] array = new int[n + 1];
        array[1] = array[2] = 1;
        return _fib1(n, array);
    }

    // 用数组去优化
    private static int _fib1(int n, int[] array) {
        if (array[n] == 0) {
            array[n] = _fib1(n-1, array) + _fib1(n-2, array);
        }
        return array[n];
    }

    private static int fib2(int n) {
        if (n <= 2) {
            return 1;
        }
        int first = 1;
        int second = 1;
        for (int i = 3; i <= n; i++) {
            int sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }

    // 时间复杂度 O(logN)
    private static int fib3(int n) {
        if (n <= 2) {
            return 1;
        }
        double c = Math.sqrt(5);
        double x = (1 + c) * 0.5;
        double y = (1 - c) * 0.5;
        double z = Math.pow(x, n) - Math.pow(y, n);
        return (int)(z / c);
    }


    public static void TestFibonacci(int n) {
        fibonacci(n);
    }

    private static void fibonacci(int n) {
//        TimeTool.check("fib0", new TimeTool.Task() {
//            @Override
//            public void execute() {
//                NSLog(Fibonacci.fib0(n));
//            }
//        });

//        TimeTool.check("fib1", new TimeTool.Task() {
//            @Override
//            public void execute() {
//                NSLog(Fibonacci.fib1(n));
//            }
//        });

        TimeTool.check("fib2", new TimeTool.Task() {
            @Override
            public void execute() {
                NSLog(Fibonacci.fib2(n));
            }
        });

        TimeTool.check("fib3", new TimeTool.Task() {
            @Override
            public void execute() {
                NSLog(Fibonacci.fib3(n));
            }
        });
    }

    private static void NSLog(Object x) {
        System.out.println(x);
    }
}