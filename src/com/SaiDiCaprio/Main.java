package com.SaiDiCaprio;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        testMutableArray();
//        ArrayList
        System.out.println("Hello World!");
    }

    private static void testMutableArray() {
        NSMutableArray<Person> array = new NSMutableArray<Person>();
    }


    private static void testFibonacci() {
        fibonacci(46);
    }

    private static void fibonacci(int n) {
        TimeTool.check("fib1", new TimeTool.Task() {
            @Override
            public void execute() {
                System.out.println(Fibonacci.fib1(n));
            }
        });

        TimeTool.check("fib2", new TimeTool.Task() {
            @Override
            public void execute() {
                System.out.println(Fibonacci.fib2(n));
            }
        });
    }
}