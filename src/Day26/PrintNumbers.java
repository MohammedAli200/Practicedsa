package Day26;

public class PrintNumbers {
    static void printNumbers(int n) {
        if (n == 0) return;

        printNumbers(n - 1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        printNumbers(5);
    }
}
