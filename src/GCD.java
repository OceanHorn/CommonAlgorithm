/**
 * Created by GuoYufu on 2016/10/24.
 */

// 辗转相除法，求最大公约数
// Greatest Common Divisor

public class GCD {
    public static void main(String[] args) {

//        int a = gcd(21, 40);
//        System.out.println(a);

//        int a = gcd_recursion(22, 40);
//        System.out.println(a);

        int a = gcd_tempVar(10, 40);
        System.out.println(a);
    }

    // 普通逻辑
    public static int gcd(int m, int n) {

        while (true) {

            m = m % n;
            if (m == 0)
                return n;

            n = n % m;
            if (n == 0)
                return m;
        }
    }

    // 递归
    public static int gcd_recursion(int m, int n) {

        if (n != 0) {
            return gcd_recursion(n, m % n);
        }
        else {
            return m;
        }
    }

    // 中间临时变量
    public static int gcd_tempVar(int m, int n) {

        int temp = 0;
        while (n != 0) {
            temp = m % n;
            m = n;
            n = temp;
        }
        return m;
    }
}
