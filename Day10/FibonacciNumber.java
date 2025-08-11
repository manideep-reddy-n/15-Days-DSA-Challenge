package Day10;

import java.util.*;

public class FibonacciNumber {
    public int fib(int n) {
        if (n == 0 || n == 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        FibonacciNumber fb = new FibonacciNumber();
        System.out.println(fb.fib(n));
    }
}
