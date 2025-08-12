public class ClimbingStairs {
    public static int climbStairs(int n) {
        if (n <= 2) return n;
        int a = 1; // ways for step 1
        int b = 2; // ways for step 2
        for (int i = 3; i <= n; i++) {
            int c = a + b; // fib-like relation
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3)); // 3
    }
}
