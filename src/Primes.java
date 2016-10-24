/**
 * Created by GuoYufu on 2016/10/24.
 */

// 埃拉托斯特尼筛法,计算小于给定数字的所有质数（素数）
public class Primes {
    public static void main(String[] args) {

        int n = 997;
        for (int i: primes(n)) {
            System.out.format("%4d,", i);
        }

//        int n = 29;
//        System.out.println(isPrime(n));
    }

    public static int[] primes(int n) {

        boolean[] primes = new boolean[n + 1];
        for (int i = 0; i < n + 1; i++) {
            primes[i] = true;
        }

        primes[0] = false;
        primes[1] = false;

        for (int i = 1; i < n + 1; i++) {

            if (i > 2 && i % 2 == 0) {
                primes[i] = false;
            }
        }

        int i = 3;
        while (i * i <= n) {

            for (int j = i + 1 ; j < n + 1; j++) {
                if (j % i == 0) {
                    primes[j] = false;
                }
            }

            i = i + 1;
        }

        int count = 0;
        for (int j = 0; j < n + 1; j++) {
            if (primes[j]) {
                count++;
            }
        }

        if (count == 0) {
            return new int[1];
        }
        else {
            int[] composites = new int[count];
            int index = 0;
            for (int j = 0; j < n + 1; j++) {
                if (primes[j]) {
                    composites[index] = j;
                    index++;
                }
            }
            return composites;
        }

    }

    // 单个判断某个整数是否为质数
    public static boolean isPrime(int n) {

        if (n <= 3) {
            return n > 1;
        }

        int endLoop = (int)Math.sqrt(n);
        for (int i = 2; i <= endLoop ; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
