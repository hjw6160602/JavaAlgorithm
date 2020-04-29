package com.SaiDiCaprio;

public class Main {
    public static void main(String[] args) {
        fibonacci(46);
        System.out.println("Hello World!");
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