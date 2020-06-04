import 数据结构.链表.*;
import 算法.Fibonacci;

public class Main {
    public static void main(String[] args) {
        testLinkedList();
//        testMutableArray();
        NSLog("Hello World!");
    }

    private static void NSLog(Object x) {
        System.out.println(x);
    }
    private static  void testLinkedList() {
        List<Integer> list = new LinkedList<>();
        list.add(20);
        list.add(0, 10);
        list.add(30);
        list.add(list.size(), 40);
        NSLog(list);
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