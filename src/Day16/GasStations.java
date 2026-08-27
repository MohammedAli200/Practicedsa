package Day16;

import java.util.Scanner;

public class GasStations {

    static boolean possible(
            int[] stations,
            int k,
            double distance) {

        int required = 0;

        for (int i = 1; i < stations.length; i++) {

            double gap = stations[i] - stations[i - 1];

            required += (int) Math.ceil(
                    gap / distance) - 1;

            if (required > k)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] stations = new int[n];

        for (int i = 0; i < n; i++)
            stations[i] = sc.nextInt();

        int k = sc.nextInt();

        double low = 0.0;
        double high = stations[n - 1] - stations[0];

        for (int i = 0; i < 100; i++) {

            double mid = low + (high - low) / 2;

            if (possible(stations, k, mid))
                high = mid;
            else
                low = mid;
        }

        System.out.printf(
                "Minimum Maximum Distance = %.2f%n",
                high);
    }
}