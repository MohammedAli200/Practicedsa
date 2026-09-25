package Day43;

public class MatrixExponentiationFibonacci {
    private static final long MOD = 1_000_000_007;

    public static long fibonacci(long n) {
        if (n <= 0) return 0;
        long[][] F = {{1, 1}, {1, 0}};
        power(F, n - 1);
        return F[0][0];
    }

    private static void power(long[][] F, long n) {
        if (n <= 1) return;
        long[][] M = {{1, 1}, {1, 0}};

        power(F, n / 2);
        multiply(F, F);

        if (n % 2 != 0) {
            multiply(F, M);
        }
    }

    private static void multiply(long[][] F, long[][] M) {
        long x = (F[0][0] * M[0][0] + F[0][1] * M[1][0]) % MOD;
        long y = (F[0][0] * M[0][1] + F[0][1] * M[1][1]) % MOD;
        long z = (F[1][0] * M[0][0] + F[1][1] * M[1][0]) % MOD;
        long w = (F[1][0] * M[0][1] + F[1][1] * M[1][1]) % MOD;

        F[0][0] = x;
        F[0][1] = y;
        F[1][0] = z;
        F[1][1] = w;
    }

    public static void main(String[] args) {
        long n = 1_000_000;
        System.out.println("1000000th Fibonacci (mod 10^9+7): " + fibonacci(n));
    }
}